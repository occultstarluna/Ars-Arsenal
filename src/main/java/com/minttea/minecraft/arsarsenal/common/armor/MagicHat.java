package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchool;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class MagicHat extends SchoolArmor{

    protected Class thisClass = MagicHat.this.getClass();

    public MagicHat(ArmorMaterial material, SpellSchool school, List<DamageSource> preventedTypes) {
        super(material, EquipmentSlot.HEAD, school, preventedTypes);
    }



    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        super.initializeClient(consumer);
        consumer.accept(new IItemRenderProperties() {

            @SuppressWarnings("unchecked")
            @Override
            public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
                                                                EquipmentSlot armorSlot, A _default) {
                return (A) GeoArmorRenderer.getRenderer(thisClass).applyEntityStats(_default)
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