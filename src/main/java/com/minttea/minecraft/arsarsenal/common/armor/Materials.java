package com.minttea.minecraft.arsarsenal.common.armor;

import com.minttea.minecraft.arsarsenal.ArsArsenal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class Materials {

    public final static IArmorMaterial sourceSteel = new ArmorMaterial(ArsArsenal.MODID+":sourcesteel",25,new int[]{4, 7, 9, 4}
            , 40, SoundEvents.ARMOR_EQUIP_NETHERITE,3.0f, () -> Ingredient.of(Items.NETHERITE_SCRAP));
    public final static IArmorMaterial fire = new ArmorMaterial(ArsArsenal.MODID+":fire",33,new int[]{3, 6, 8, 3}
            , 30, SoundEvents.GENERIC_BURN,3.0f, () -> Ingredient.of(Items.GHAST_TEAR));
    public final static IArmorMaterial water = new ArmorMaterial(ArsArsenal.MODID+":water",33,new int[]{3, 6, 8, 3}
            , 30, SoundEvents.BREWING_STAND_BREW,3.0f, () -> Ingredient.of(Items.ICE));
    public final static IArmorMaterial earth = new ArmorMaterial(ArsArsenal.MODID+":earth",33,new int[]{3, 6, 8, 3}
            , 30, SoundEvents.ANVIL_PLACE,3.0f, () -> Ingredient.of(Items.IRON_BLOCK));
    public final static IArmorMaterial air = new ArmorMaterial(ArsArsenal.MODID+":air",33,new int[]{3, 6, 8, 3}
            , 30, SoundEvents.ARMOR_EQUIP_ELYTRA,3.0f, () -> Ingredient.of(Items.FEATHER));


    /*
    Stealing this because mojang bad and Bailey did it better.  Bailey make yours public pls.
     */
    private static class ArmorMaterial implements IArmorMaterial{

        private static final int[] Max_Damage_Array = new int[] {13,15,16,11};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;

        public ArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> supplier) {
            this.name = name;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.toughness = toughness;
            this.repairMaterial = new LazyValue<>(supplier);
        }

        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;


        @Override
        public int getDurabilityForSlot(EquipmentSlotType slotIn) {
            return Max_Damage_Array[slotIn.getIndex()] * maxDamageFactor;
        }

        @Override
        public int getDefenseForSlot(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantmentValue() {
            return enchantability;
        }

        @Override
        public SoundEvent getEquipSound() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return repairMaterial.get();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }
    }


}
