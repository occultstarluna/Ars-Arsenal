package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.Arrays;

public class EarthRobes extends SchoolArmor{

    public EarthRobes(EquipmentSlot slot) {
        super(Materials.earth, slot, SpellSchools.ELEMENTAL_EARTH, Arrays.asList(DamageSource.CACTUS,
                DamageSource.STARVE,
                DamageSource.SWEET_BERRY_BUSH,
                DamageSource.IN_WALL,
                DamageSource.FALLING_BLOCK,
                DamageSource.WITHER));

    }


}
