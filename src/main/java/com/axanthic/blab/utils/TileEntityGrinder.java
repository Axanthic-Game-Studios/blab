package com.axanthic.blab.utils;

import com.axanthic.blab.Recipes;
import com.axanthic.blab.blocks.BlockGrinder;
import com.axanthic.blab.gui.ContainerKiln;
import com.axanthic.blab.proxy.ClientProxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class TileEntityGrinder extends TileEntityLockable implements ITickable, ISidedInventory {
	private static final int[] SLOTS_TOP = new int[] { 0 };
	private static final int[] SLOTS_BOTTOM = new int[] { 2, 1 };
	private static final int[] SLOTS_SIDES = new int[] { 1 };
	private NonNullList<ItemStack> inventoryItems = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
	private int burnTime;
	private int currentItemBurnTime;
	private int cookTime;
	private int totalCookTime;
	private int lastSound = 285;
	private String customName;

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory() {
		return this.inventoryItems.size();
	}

	public boolean isEmpty() {
		for (ItemStack itemstack : this.inventoryItems) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the stack in the given slot.
	 */
	public ItemStack getStackInSlot(int index) {
		return this.inventoryItems.get(index);
	}

	/**
	 * Removes up to a specified number of items from an inventory slot and returns
	 * them in a new stack.
	 */
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.inventoryItems, index, count);
	}

	/**
	 * Removes a stack from the given slot and returns it.
	 */
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.inventoryItems, index);
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be
	 * crafting or armor sections).
	 */
	public void setInventorySlotContents(int index, ItemStack stack) {
		ItemStack itemstack = this.inventoryItems.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack)
				&& ItemStack.areItemStackTagsEqual(stack, itemstack);
		this.inventoryItems.set(index, stack);

		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}

		if (index == 0 && !flag) {
			this.totalCookTime = this.getCookTime(stack);
			this.cookTime = 0;
			this.markDirty();
		}
	}

	/**
	 * Get the name of this object. For players this returns their username
	 */
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.grinder";
	}

	/**
	 * Returns true if this thing is named
	 */
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.isEmpty();
	}

	public void setCustomInventoryName(String p_145951_1_) {
		this.customName = p_145951_1_;
	}

	public static void registerFixesFurnace(DataFixer fixer) {
		fixer.registerWalker(FixTypes.BLOCK_ENTITY,
				new ItemStackDataLists(TileEntityGrinder.class, new String[] { "Items" }));
	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.inventoryItems = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.inventoryItems);
		this.burnTime = compound.getInteger("BurnTime");
		this.cookTime = compound.getInteger("CookTime");
		this.totalCookTime = compound.getInteger("CookTimeTotal");
		this.currentItemBurnTime = getItemBurnTime(this.inventoryItems.get(1));

		if (compound.hasKey("CustomName", 8)) {
			this.customName = compound.getString("CustomName");
		}
	}

	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("BurnTime", (short) this.burnTime);
		compound.setInteger("CookTime", (short) this.cookTime);
		compound.setInteger("CookTimeTotal", (short) this.totalCookTime);
		ItemStackHelper.saveAllItems(compound, this.inventoryItems);

		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}

		return compound;
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return this.writeToNBT(new NBTTagCompound());
	}

	@Override
	public void handleUpdateTag(NBTTagCompound nbt) {
		this.readFromNBT(nbt);
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		NBTTagCompound nbtTag = this.getUpdateTag();
		return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.handleUpdateTag(pkt.getNbtCompound());
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64,
	 * possibly will be extended.
	 */
	public int getInventoryStackLimit() {
		return 64;
	}

	public boolean isBurning() {
		return this.burnTime > 0;
	}

	public boolean isGrinding() {
		return this.cookTime > 0;
	}

	@SideOnly(Side.CLIENT)
	public static boolean isBurning(IInventory inventory) {
		return inventory.getField(0) > 0;
	}

	/**
	 * Like the old updateEntity(), except more generic.
	 */
	public void update() {
		boolean flag = this.isGrinding();
		boolean flag1 = false;

		if (!this.world.isRemote) {
			ItemStack itemstack = this.inventoryItems.get(1);

			if (this.isBurning() || !itemstack.isEmpty() && !((ItemStack) this.inventoryItems.get(0)).isEmpty()) {
				if (!this.isBurning() && this.canSmelt()) {
					this.burnTime = getItemBurnTime(itemstack);
					this.currentItemBurnTime = this.burnTime;

					if (this.isBurning()) {
						flag1 = true;

						if (!itemstack.isEmpty()) {
							Item item = itemstack.getItem();
							itemstack.shrink(1);

							if (itemstack.isEmpty()) {
								ItemStack item1 = item.getContainerItem(itemstack);
								this.inventoryItems.set(1, item1);
							}
						}
					}
				}

				if (this.isBurning() && this.canSmelt()) {
					++this.cookTime;
					--this.burnTime;

					if (this.cookTime == this.totalCookTime) {
						this.cookTime = 0;
						this.totalCookTime = this.getCookTime(this.inventoryItems.get(0));
						this.smeltItem();
						flag1 = true;
					}
				} else {
					this.cookTime = 0;
				}
			} else if (!this.isBurning() && this.cookTime > 0) {
				this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
			}

			if (flag != this.isGrinding()) {
				flag1 = true;
				((BlockGrinder) this.world.getBlockState(this.pos).getBlock()).setState(this.world.getBlockState(this.pos).withProperty(BlockGrinder.BURNING, this.canSmelt()), this.world, pos);
			}
		} else {
			if (this.isGrinding()) {
				if (this.lastSound > 285) {
					this.world.playSound((double) pos.getX() + 0.5D, (double) pos.getY(), (double) pos.getZ() + 0.5D, ClientProxy.GRIND, SoundCategory.BLOCKS, 0.7F, 1.0F, false);
					this.lastSound = 0;
				} else
					this.lastSound++;
			} else
				this.lastSound++;
		}

		if (flag1) {
			this.markDirty();
		}

		if (this.isGrinding()) {
			double d0 = (double) pos.getX() + 8.0D / 16.0D;
			double d1 = (double) pos.getY() + 8.0D / 16.0D;
			double d2 = (double) pos.getZ() + 8.0D / 16.0D;
			ItemStack stack = this.getStackInSlot(0);
			if (!stack.isEmpty()) {
				if (this.world instanceof WorldServer)
					((WorldServer)this.world).spawnParticle(EnumParticleTypes.ITEM_CRACK, d0, d1 + 7.0D / 16.0D, d2, 0.0D, 0.3D, 0.0D, Item.getIdFromItem(stack.getItem()), stack.getMetadata());
				else
					this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, d0, d1 + 7.0D / 16.0D, d2, 0.0D, 0.3D, 0.0D, Item.getIdFromItem(stack.getItem()), stack.getMetadata());
			}
		}
	}

	public int getCookTime(ItemStack stack) {
		return 200;
	}

	private boolean canSmelt() {
		if (((ItemStack) this.inventoryItems.get(0)).isEmpty()) {
			return false;
		} else {
			ItemStack itemstack = getGrindingResult(this.inventoryItems.get(0));

			if (itemstack.isEmpty())
				return false;
			ItemStack itemstack1 = this.inventoryItems.get(2);

			if (itemstack1.isEmpty()) {
				return true;
			} else if (!itemstack1.isItemEqual(itemstack)) {
				return false;
			} else if (itemstack1.getCount() + itemstack.getCount() <= this.getInventoryStackLimit()
					&& itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize())
			{
				return true;
			} else {
				return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
			}
		}
	}

	public static ItemStack getGrindingResult(ItemStack stack) {
		ItemStack returnstack = ItemStack.EMPTY;
		String key = stack.getItem().getRegistryName().toString() + ":" + stack.getMetadata();
		if (Recipes.grindingRecipes.containsKey(key))
			return Recipes.grindingRecipes.get(key).copy();

		for (int id : OreDictionary.getOreIDs(stack)) {
			String name = OreDictionary.getOreName(id);

			if (name.startsWith("ingot"))
				if (OreDictionary.doesOreNameExist(name.replace("ingot", "dust")))
					return OreDictionary.getOres(name.replace("ingot", "dust")).get(0);

			if (name.startsWith("ore"))
				if (OreDictionary.doesOreNameExist(name.replace("ore", "dust"))) {
					returnstack = OreDictionary.getOres(name.replace("ore", "dust")).get(0);
					returnstack.setCount(2);
					return returnstack;
				}
		}
		return returnstack;
	}

	public void smeltItem() {
		if (this.canSmelt()) {
			ItemStack itemstack = this.inventoryItems.get(0);
			ItemStack itemstack1 = getGrindingResult(itemstack);
			ItemStack itemstack2 = this.inventoryItems.get(2);

			if (itemstack2.isEmpty()) {
				this.inventoryItems.set(2, itemstack1.copy());
			} else if (ItemStack.areItemsEqual(itemstack2, itemstack1)) {
				itemstack2.grow(itemstack1.getCount());
			}

			if (itemstack.getItem() == Item.getItemFromBlock(Blocks.SPONGE) && itemstack.getMetadata() == 1
					&& !((ItemStack) this.inventoryItems.get(1)).isEmpty()
					&& ((ItemStack) this.inventoryItems.get(1)).getItem() == Items.BUCKET) {
				this.inventoryItems.set(1, new ItemStack(Items.WATER_BUCKET));
			}

			itemstack.shrink(1);
		}
	}

	public static int getItemBurnTime(ItemStack stack) {
		String key = stack.getItem().getRegistryName().toString() + ":" + stack.getMetadata();
		if (Recipes.grinderFuel.containsKey(key))
			return Recipes.grinderFuel.get(key);

		return 0;
	}

	public static boolean isItemFuel(ItemStack stack) {
		return getItemBurnTime(stack) > 0;
	}

	/**
	 * Don't rename this method to canInteractWith due to conflicts with Container
	 */
	public boolean isUsableByPlayer(EntityPlayer player) {
		if (this.world.getTileEntity(this.pos) != this) {
			return false;
		} else {
			return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
					(double) this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}

	public void openInventory(EntityPlayer player) {
	}

	public void closeInventory(EntityPlayer player) {
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot. For guis use Slot.isItemValid
	 */
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (index == 2) {
			return false;
		} else if (index != 1) {
			return true;
		} else {
			ItemStack itemstack = this.inventoryItems.get(1);
			return isItemFuel(stack);
		}
	}

	public int[] getSlotsForFace(EnumFacing side) {
		if (side == EnumFacing.DOWN) {
			return SLOTS_BOTTOM;
		} else {
			return side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES;
		}
	}

	/**
	 * Returns true if automation can insert the given item in the given slot from
	 * the given side.
	 */
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	/**
	 * Returns true if automation can extract the given item in the given slot from
	 * the given side.
	 */
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		if (direction == EnumFacing.DOWN && index == 1) {
			Item item = stack.getItem();

			if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
				return false;
			}
		}

		return true;
	}

	public String getGuiID() {
		return "blab:grinder";
	}

	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerKiln(playerInventory, this);
	}

	public int getField(int id) {
		switch (id) {
		case 0:
			return this.burnTime;
		case 1:
			return this.currentItemBurnTime;
		case 2:
			return this.cookTime;
		case 3:
			return this.totalCookTime;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.burnTime = value;
			break;
		case 1:
			this.currentItemBurnTime = value;
			break;
		case 2:
			this.cookTime = value;
			break;
		case 3:
			this.totalCookTime = value;
		}
	}

	public int getFieldCount() {
		return 4;
	}

	public void clear() {
		this.inventoryItems.clear();
	}

	net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this,
			net.minecraft.util.EnumFacing.UP);
	net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this,
			net.minecraft.util.EnumFacing.DOWN);
	net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this,
			net.minecraft.util.EnumFacing.WEST);

	@Override
	@javax.annotation.Nullable
	public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability,
			@javax.annotation.Nullable net.minecraft.util.EnumFacing facing) {
		if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN)
				return (T) handlerBottom;
			else if (facing == EnumFacing.UP)
				return (T) handlerTop;
			else
				return (T) handlerSide;
		return super.getCapability(capability, facing);
	}
}