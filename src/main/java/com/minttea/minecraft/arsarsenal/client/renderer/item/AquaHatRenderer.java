package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.minttea.minecraft.arsarsenal.common.armor.AquaHat;
import com.minttea.minecraft.arsarsenal.common.armor.EarthHat;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class AquaHatRenderer extends GeoArmorRenderer<AquaHat> {
    public AquaHatRenderer() {
        super(new AquaHatModel());

        this.headBone = "bipedHead";
    }

}
