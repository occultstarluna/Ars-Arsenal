package com.minttea.minecraft.arsarsenal.common.items;

import com.hollingsworth.arsnouveau.api.item.ICasterTool;
import com.hollingsworth.arsnouveau.api.spell.*;
import com.hollingsworth.arsnouveau.common.capability.CapabilityRegistry;
import com.hollingsworth.arsnouveau.common.spell.augment.AugmentAOE;
import com.hollingsworth.arsnouveau.common.spell.augment.AugmentAmplify;
import com.hollingsworth.arsnouveau.common.spell.augment.AugmentFortune;
import com.hollingsworth.arsnouveau.common.spell.effect.EffectBreak;
import com.hollingsworth.arsnouveau.common.spell.effect.EffectCrush;
import com.hollingsworth.arsnouveau.common.spell.effect.EffectPickup;
import com.hollingsworth.arsnouveau.common.spell.method.MethodTouch;
import com.hollingsworth.arsnouveau.common.util.PortUtil;
import com.minttea.minecraft.arsarsenal.client.renderer.item.PickRenderer;
import com.minttea.minecraft.arsarsenal.setup.registries.ItemRegistry;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.client.IItemRenderProperties;
import software.bernie.ars_nouveau.geckolib3.core.IAnimatable;
import software.bernie.ars_nouveau.geckolib3.core.manager.AnimationData;
import software.bernie.ars_nouveau.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static net.minecraft.world.item.Tiers.NETHERITE;

public class SourceSteelPick extends PickaxeItem implements ICasterTool, IAnimatable {
    public SourceSteelPick() {
        super(NETHERITE, 3, -2.8f, ItemRegistry.defaultItemProperties().stacksTo(1));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        super.inventoryTick(stack, world, entity, p_77663_4_, p_77663_5_);
        if(world.isClientSide() || world.getGameTime() % 200 !=  0 || stack.getDamageValue() == 0 || !(entity instanceof Player))
            return;

        CapabilityRegistry.getMana((LivingEntity) entity).ifPresent(mana -> {
            if(mana.getCurrentMana() > 20){
                mana.removeMana(20);
                stack.setDamageValue(stack.getDamageValue() - 1);
            }
        });
    }
    @Override
    public boolean isScribedSpellValid(ISpellCaster caster, Player player, InteractionHand hand, ItemStack stack, Spell spell) {
        return spell.recipe.stream().noneMatch(s -> s instanceof AbstractCastMethod);
    }

    @Override
    public void sendInvalidMessage(Player player) {
        PortUtil.sendMessageNoSpam(player, new TranslatableComponent("ars_nouveau.sword.invalid"));
    }

    @Override
    public boolean setSpell(ISpellCaster caster, Player player, InteractionHand hand, ItemStack stack, Spell spell) {
        ArrayList<AbstractSpellPart> recipe = new ArrayList<>();
        int discount = 0;
        recipe.add(MethodTouch.INSTANCE);
        for (AbstractSpellPart part: spell.recipe
        ) {
            recipe.add(part);
            if ( part instanceof EffectBreak)
            {
                recipe.add(AugmentAmplify.INSTANCE);
                recipe.add(AugmentAmplify.INSTANCE);
                recipe.add(AugmentFortune.INSTANCE);
                recipe.add(AugmentFortune.INSTANCE);
                discount = (AugmentAmplify.INSTANCE.getConfigCost() * 2) + (AugmentFortune.INSTANCE.getConfigCost() * 3);
            } else if( part instanceof EffectCrush)
            {
                recipe.add(AugmentAmplify.INSTANCE);
                recipe.add(AugmentAmplify.INSTANCE);
                recipe.add(AugmentAmplify.INSTANCE);
                recipe.add(AugmentAmplify.INSTANCE);
                discount = AugmentAOE.INSTANCE.getConfigCost() * 4;
            }else if(part instanceof AbstractEffect)
            {
                recipe.add(AugmentFortune.INSTANCE);
                recipe.add(AugmentFortune.INSTANCE);
                discount = (AugmentFortune.INSTANCE.getConfigCost() * 2);
            }
        }
        recipe.add(EffectPickup.INSTANCE);
        recipe.add(AugmentAOE.INSTANCE);
        recipe.add(AugmentAOE.INSTANCE);
        recipe.add(AugmentAOE.INSTANCE);
        recipe.add(AugmentAOE.INSTANCE);
        spell.recipe = recipe;
        spell.setCost(spell.getCastingCost() - discount);
        return ICasterTool.super.setSpell(caster, player, hand, stack, spell);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);
        ISpellCaster caster = getSpellCaster(stack);
        int discount = 0;
        Spell spell = caster.getSpell();
        for (AbstractSpellPart part: spell.recipe
        ) {
            if ( part instanceof EffectBreak)
            {
                discount = (AugmentAmplify.INSTANCE.getConfigCost() * 2) + (AugmentFortune.INSTANCE.getConfigCost() * 3) + (AugmentAOE.INSTANCE.getConfigCost() * 4) + EffectPickup.INSTANCE.getConfigCost();
            } else if( part instanceof EffectCrush)
            {
                discount = AugmentAOE.INSTANCE.getConfigCost() * 4 + (AugmentAOE.INSTANCE.getConfigCost() * 4) + EffectPickup.INSTANCE.getConfigCost();
            }else if(part instanceof AbstractEffect)
            {
                discount = (AugmentFortune.INSTANCE.getConfigCost() * 2) + (AugmentAOE.INSTANCE.getConfigCost() * 4) + EffectPickup.INSTANCE.getConfigCost();
            }
        }

        spell.setCost(spell.getCastingCost() - discount);
        caster.setSpell(spell);
        return caster.castSpell(worldIn, playerIn, handIn, new TranslatableComponent("ars_nouveau.wand.invalid"));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity player) {

        ISpellCaster caster = getSpellCaster(stack);
        SpellResolver resolver = new SpellResolver(new SpellContext(caster.getSpell(), player).withColors(caster.getColor()));
        EntityHitResult entityRes = new EntityHitResult(target);

        resolver.onCastOnEntity(stack, player, (LivingEntity) entityRes.getEntity(), InteractionHand.MAIN_HAND);

        return super.hurtEnemy(stack, target, player);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip2, TooltipFlag flagIn) {
        getInformation(stack, worldIn, tooltip2, flagIn);
        super.appendHoverText(stack, worldIn, tooltip2, flagIn);
    }
    @Override
    public void registerControllers(AnimationData animationData) {

    }

    public AnimationFactory factory = new AnimationFactory(this);

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        super.initializeClient(consumer);
        consumer.accept(new IItemRenderProperties() {
            private final BlockEntityWithoutLevelRenderer renderer = new PickRenderer();

            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                return renderer;
            }
        });
    }
}