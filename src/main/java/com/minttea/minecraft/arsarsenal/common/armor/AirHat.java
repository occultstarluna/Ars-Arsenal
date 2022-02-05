package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.world.damagesource.DamageSource;

import java.util.Arrays;

public class AirHat extends MagicHat {

    protected Class thisClass = AirHat.this.getClass();

    public AirHat() {
        super(Materials.air, SpellSchools.ELEMENTAL_AIR, Arrays.asList(DamageSource.FALL,
                DamageSource.FLY_INTO_WALL,
                DamageSource.IN_WALL,
                DamageSource.LIGHTNING_BOLT));


    }
    @Override
    public String getTextureName() {
        return "air_hat";
    }

}
