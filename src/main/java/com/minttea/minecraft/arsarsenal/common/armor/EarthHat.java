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
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.function.Consumer;

public class EarthHat extends SchoolArmor {

    public EarthHat() {
        super(Materials.earth, EquipmentSlot.HEAD, SpellSchools.ELEMENTAL_EARTH, Arrays.asList(DamageSource.CACTUS,
                DamageSource.STARVE,
                DamageSource.SWEET_BERRY_BUSH,
                DamageSource.IN_WALL,
                DamageSource.FALLING_BLOCK,
                DamageSource.WITHER));


    }
    @Override
    public String getTextureName() {
        return "earth_hat";
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        super.initializeClient(consumer);
        consumer.accept(new IItemRenderProperties() {

            @SuppressWarnings("unchecked")
            @Override
            public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
                                                                EquipmentSlot armorSlot, A _default) {
                return (A) GeoArmorRenderer.getRenderer(EarthHat.this.getClass()).applyEntityStats(_default)
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
