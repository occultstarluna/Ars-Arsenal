package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.world.damagesource.DamageSource;

import java.util.Arrays;

public class EarthHat extends MagicHat {

    protected Class thisClass = EarthHat.this.getClass();

    public EarthHat() {
        super(Materials.earth, SpellSchools.ELEMENTAL_EARTH, Arrays.asList(DamageSource.CACTUS,
                DamageSource.STARVE,
                DamageSource.SWEET_BERRY_BUSH,
                DamageSource.IN_WALL,
                DamageSource.FALLING_BLOCK,
                DamageSource.WITHER));


    }
    @Override
    public String getTextureName() {
        return "earth_hat";
    }

}
