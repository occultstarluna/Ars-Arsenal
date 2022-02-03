package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import javax.annotation.Nullable;
import java.util.Arrays;

public class AirHat extends SchoolArmor {

    public AirHat() {
        super(Materials.air, EquipmentSlotType.HEAD, SpellSchools.ELEMENTAL_AIR, Arrays.asList(DamageSource.FALL,
                DamageSource.FLY_INTO_WALL,
                DamageSource.IN_WALL,
                DamageSource.LIGHTNING_BOLT));


    }
    @Override
    public String getTextureName() {
        return "air_hat";
    }

    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) GeoArmorRenderer.getRenderer(this.getClass()).applyEntityStats(_default).applySlot(armorSlot).setCurrentItem(entityLiving,itemStack,armorSlot);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        Class<? extends ArmorItem> clazz = this.getClass();
        GeoArmorRenderer renderer = GeoArmorRenderer.getRenderer(clazz);
        return renderer.getTextureLocation((ArmorItem) stack.getItem()).toString();
    }
}
