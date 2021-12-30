package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;

import java.util.Arrays;

public class AirRobes extends SchoolArmor{

    public AirRobes(EquipmentSlotType slot) {
        super(Materials.air, slot, SpellSchools.ELEMENTAL_AIR, Arrays.asList(DamageSource.FALL,
                DamageSource.FLY_INTO_WALL,
                DamageSource.DRAGON_BREATH,
                DamageSource.IN_WALL));

    }
}
