package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;

import java.util.Arrays;

public class EarthRobes extends SchoolArmor{

    public EarthRobes(EquipmentSlotType slot) {
        super(Materials.earth, slot, SpellSchools.ELEMENTAL_EARTH, Arrays.asList(DamageSource.CACTUS,
                DamageSource.STARVE,
                DamageSource.SWEET_BERRY_BUSH,
                DamageSource.IN_WALL,
                DamageSource.WITHER));

    }


}
