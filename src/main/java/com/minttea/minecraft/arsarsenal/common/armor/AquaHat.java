package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import javax.annotation.Nullable;
import java.util.Arrays;

public class AquaHat extends SchoolArmor {

    public AquaHat() {
        super(Materials.water, EquipmentSlotType.HEAD, SpellSchools.ELEMENTAL_WATER, Arrays.asList(DamageSource.DROWN,
                DamageSource.WITHER,
                DamageSource.MAGIC,
                DamageSource.LIGHTNING_BOLT));


    }
    @Override
    public String getTextureName() {
        return "aqua_hat";
    }

    @SuppressWarnings("unchecked")
	@OnlyIn(Dist.CLIENT)
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
