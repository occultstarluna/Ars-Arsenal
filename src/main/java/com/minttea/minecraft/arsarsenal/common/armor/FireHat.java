package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import net.minecraft.world.damagesource.DamageSource;

import java.util.Arrays;

public class FireHat extends MagicHat {

    protected Class thisClass = FireHat.this.getClass();

    public FireHat() {
        super(Materials.fire,  SpellSchools.ELEMENTAL_FIRE, Arrays.asList(DamageSource.ON_FIRE,
                DamageSource.LAVA,
                DamageSource.IN_FIRE,
                DamageSource.HOT_FLOOR,
                DamageSource.DRAGON_BREATH));


    }
    @Override
    public String getTextureName() {
        return "fire_hat";
    }


}
