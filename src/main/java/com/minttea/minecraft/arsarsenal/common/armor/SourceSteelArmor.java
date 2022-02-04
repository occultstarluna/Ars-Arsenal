package com.minttea.minecraft.arsarsenal.common.armor;

import com.minttea.minecraft.arsarsenal.setup.registries.ItemRegistry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class SourceSteelArmor extends MagicArmor{
    public SourceSteelArmor(EquipmentSlot slot) {
        super(Materials.sourceSteel, slot, ItemRegistry.defaultItemProperties());
        this.repairCost = 30;
    }

    @Override
    public int getMaxManaBoost(ItemStack i){
        return 60;
    }

    @Override
    public int getManaRegenBonus(ItemStack i){
        return 8;
    }



}
