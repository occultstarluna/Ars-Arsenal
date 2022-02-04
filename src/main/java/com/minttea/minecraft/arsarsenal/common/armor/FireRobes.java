package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.Arrays;

public class FireRobes extends  SchoolArmor{

    public FireRobes(EquipmentSlot slot) {
        super(Materials.fire, slot, SpellSchools.ELEMENTAL_FIRE, Arrays.asList(DamageSource.ON_FIRE,
                DamageSource.LAVA,
                DamageSource.IN_FIRE,
                DamageSource.HOT_FLOOR,
                DamageSource.DRAGON_BREATH));


    }
}
