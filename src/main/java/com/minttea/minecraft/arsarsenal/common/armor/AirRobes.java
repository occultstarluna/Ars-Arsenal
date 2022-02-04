package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.Arrays;

public class AirRobes extends SchoolArmor{

    public AirRobes(EquipmentSlot slot) {
        super(Materials.air, slot, SpellSchools.ELEMENTAL_AIR, Arrays.asList(DamageSource.FALL,
                DamageSource.FLY_INTO_WALL,
                DamageSource.IN_WALL,
                DamageSource.LIGHTNING_BOLT));

    }
}
