package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.Arrays;

public class AquaRobes extends SchoolArmor{

    public AquaRobes(EquipmentSlot slot) {
        super(Materials.water, slot, SpellSchools.ELEMENTAL_WATER, Arrays.asList(DamageSource.DROWN,
                DamageSource.WITHER,
                DamageSource.MAGIC,
                DamageSource.LIGHTNING_BOLT));

    }
}
