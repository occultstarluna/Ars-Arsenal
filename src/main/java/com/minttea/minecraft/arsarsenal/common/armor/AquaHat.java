package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.function.Consumer;

public class AquaHat extends SchoolArmor {

    public AquaHat() {
        super(Materials.water, EquipmentSlot.HEAD, SpellSchools.ELEMENTAL_WATER, Arrays.asList(DamageSource.DROWN,
                DamageSource.WITHER,
                DamageSource.MAGIC,
                DamageSource.LIGHTNING_BOLT));


    }
    @Override
    public String getTextureName() {
        return "aqua_hat";
    }

    @Override
    public void initializeClient(@NotNull Consumer<IItemRenderProperties> consumer) {
        super.initializeClient(consumer);
        consumer.accept(new IItemRenderProperties() {

            @SuppressWarnings("unchecked")
            @Override
            public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
                                                                EquipmentSlot armorSlot, A _default) {
                return (A) GeoArmorRenderer.getRenderer(AquaHat.this.getClass()).applyEntityStats(_default)
                        .applySlot(armorSlot).setCurrentItem(entityLiving, itemStack, armorSlot);
            }
        });
    }
    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        Class<? extends ArmorItem> clazz = this.getClass();
        GeoArmorRenderer renderer = GeoArmorRenderer.getRenderer(clazz);
        return renderer.getTextureLocation((ArmorItem) stack.getItem()).toString();
    }
}
