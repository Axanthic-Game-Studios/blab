package com.axanthic.blab.items;

import com.axanthic.blab.Blab;
import com.axanthic.blab.entity.EntityBident;
import com.google.common.collect.Multimap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemTrident extends ItemBasic implements IItemCustomReach {

	public ItemTrident() {
		super("trident");		
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
		stack.damageItem(1, entityLiving);
		return true;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		if (enchantment.type.equals(EnumEnchantmentType.ALL) || enchantment.type.equals(EnumEnchantmentType.BREAKABLE) || enchantment.type.equals(EnumEnchantmentType.WEAPON)) {
			return true;
		}
		return enchantment.type.canEnchantItem(stack.getItem());
	}
	
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer)entityLiving;
			boolean flag = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;

			float f = getArrowVelocity(net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, getMaxItemUseDuration(stack) - timeLeft, true));
			if ((double)f < 0.1D)
				return;

			if (!worldIn.isRemote) {
				EntityBident entityBident = new EntityBident(worldIn, entityplayer);
				entityBident.setItemStack(stack.copy());
				entityBident.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 5.0F, 0.0F);
				
				if (f == 1.0F) {
					entityBident.setIsCritical(true);
				}

				int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, stack);
				if (j > 0)
					entityBident.setDamage(entityBident.getDamage() + (double)j * 0.5D + 0.5D);

				int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.KNOCKBACK, stack);
				if (k > 0)
					entityBident.setKnockbackStrength(k);

				if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FIRE_ASPECT, stack) > 0)
					entityBident.setFire(100);

				if (flag)
					entityBident.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;

				worldIn.spawnEntity(entityBident);
			}
			worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if (!flag) {
				entityplayer.inventory.deleteStack(stack);
			}
			entityplayer.addStat(StatList.getObjectUseStats(this));
		}
	}

	public static float getArrowVelocity(int charge) {
		float f = (float)charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;

		if (f > 1.0F) {
			f = 1.0F;
		}
		return f;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, true);
		if (ret != null)
			return ret;

		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

		if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 3.0D, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -1.0D, 0));
			multimap.put(Blab.ATTACK_RANGE.getName(), new AttributeModifier(Blab.ATTACK_RANGE_MODIFIER, "Weapon modifier", (double)this.getReach() - 5.0D, 0));
		}
		return multimap;
	}

	@Override
	public float getReach() {
		return 07.5F;
	}
}