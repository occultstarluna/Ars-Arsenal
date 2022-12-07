package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.minttea.minecraft.arsarsenal.common.armor.EarthHat;
import com.minttea.minecraft.arsarsenal.common.armor.FireHat;
import software.bernie.ars_nouveau.geckolib3.renderers.geo.GeoArmorRenderer;

public class EarthHatRenderer extends GeoArmorRenderer<EarthHat> {
    public EarthHatRenderer() {
        super(new EarthHatModel());

        this.headBone = "bipedHead";
    }

}
