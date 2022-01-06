package com.minttea.minecraft.arsarsenal.common.items;

import com.hollingsworth.arsnouveau.api.item.ICasterTool;
import com.hollingsworth.arsnouveau.api.spell.*;
import com.hollingsworth.arsnouveau.common.capability.ManaCapability;
import com.hollingsworth.arsnouveau.common.spell.augment.AugmentAmplify;
import com.hollingsworth.arsnouveau.common.spell.method.MethodTouch;
import com.hollingsworth.arsnouveau.common.util.PortUtil;
import com.minttea.minecraft.arsarsenal.setup.registries.ItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.util.Hand;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.ArrayList;

public class SourceSteelAxe extends AxeItem implements ICasterTool {
    public SourceSteelAxe() {
        super(ItemTier.NETHERITE, 5, -1.9f, ItemRegistry.defaultItemProperties().stacksTo(1));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        super.inventoryTick(stack, world, entity, p_77663_4_, p_77663_5_);
        if(world.isClientSide() || world.getGameTime() % 200 !=  0 || stack.getDamageValue() == 0 || !(entity instanceof PlayerEntity))
            return;

        ManaCapability.getMana((LivingEntity) entity).ifPresent(mana -> {
            if(mana.getCurrentMana() > 20){
                mana.removeMana(20);
                stack.setDamageValue(stack.getDamageValue() - 1);
            }
        });
    }
    @Override
    public boolean isScribedSpellValid(ISpellCaster caster, PlayerEntity player, Hand hand, ItemStack stack, Spell spell) {
        return spell.recipe.stream().noneMatch(s -> s instanceof AbstractCastMethod);
    }

    @Override
    public void sendInvalidMessage(PlayerEntity player) {
        PortUtil.sendMessageNoSpam(player, new TranslationTextComponent("ars_nouveau.sword.invalid"));
    }

    @Override
    public boolean setSpell(ISpellCaster caster, PlayerEntity player, Hand hand, ItemStack stack, Spell spell) {
        ArrayList<AbstractSpellPart> recipe = new ArrayList<>();
        recipe.add(MethodTouch.INSTANCE);
        for (AbstractSpellPart part: spell.recipe
             ) {
            recipe.add(part);
            if(part instanceof AbstractEffect)
            {
                recipe.add(AugmentAmplify.INSTANCE);
                recipe.add(AugmentAmplify.INSTANCE);
                recipe.add(AugmentAmplify.INSTANCE);
            }
        }
        spell.recipe = recipe;
        spell.setCost(spell.getCastingCost() - AugmentAmplify.INSTANCE.getManaCost());
        return ICasterTool.super.setSpell(caster, player, hand, stack, spell);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity player) {

        ISpellCaster caster = getSpellCaster(stack);
        SpellResolver resolver = new SpellResolver(new SpellContext(caster.getSpell(), player).withColors(caster.getColor()));
        EntityRayTraceResult entityRes = new EntityRayTraceResult(target);

        resolver.onCastOnEntity(stack, player, (LivingEntity) entityRes.getEntity(), Hand.MAIN_HAND);

        return super.hurtEnemy(stack, target, player);
    }
}
