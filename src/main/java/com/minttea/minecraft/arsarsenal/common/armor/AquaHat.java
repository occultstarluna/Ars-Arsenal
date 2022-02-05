package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.world.damagesource.DamageSource;

import java.util.Arrays;

public class AquaHat extends MagicHat {


    protected Class thisClass = AquaHat.this.getClass();

    public AquaHat() {
        super(Materials.water, SpellSchools.ELEMENTAL_WATER, Arrays.asList(DamageSource.DROWN,
                DamageSource.WITHER,
                DamageSource.MAGIC,
                DamageSource.LIGHTNING_BOLT));


    }
    @Override
    public String getTextureName() {
        return "aqua_hat";
    }

}
