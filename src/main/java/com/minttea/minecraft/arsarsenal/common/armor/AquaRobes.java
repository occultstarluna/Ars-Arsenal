package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;

import java.util.Arrays;

public class AquaRobes extends SchoolArmor{

    public AquaRobes(EquipmentSlotType slot) {
        super(Materials.water, slot, SpellSchools.ELEMENTAL_WATER, Arrays.asList(DamageSource.DROWN,
                DamageSource.WITHER,
                DamageSource.MAGIC,
                DamageSource.LIGHTNING_BOLT));

    }
}
