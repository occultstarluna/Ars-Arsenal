package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;

import java.util.Arrays;

public class FireRobes extends  SchoolArmor{

    public FireRobes(EquipmentSlotType slot) {
        super(Materials.fire, slot, SpellSchools.ELEMENTAL_FIRE, Arrays.asList(DamageSource.ON_FIRE,
                DamageSource.LAVA,
                DamageSource.IN_FIRE,
                DamageSource.HOT_FLOOR,
                DamageSource.DRAGON_BREATH));


    }

}
