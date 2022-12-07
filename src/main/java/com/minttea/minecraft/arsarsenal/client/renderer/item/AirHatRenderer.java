package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.minttea.minecraft.arsarsenal.common.armor.AirHat;
import com.minttea.minecraft.arsarsenal.common.armor.AquaHat;
import software.bernie.ars_nouveau.geckolib3.renderers.geo.GeoArmorRenderer;

public class AirHatRenderer extends GeoArmorRenderer<AirHat> {
    public AirHatRenderer() {
        super(new AirHatModel());

        this.headBone = "bipedHead";
    }

}
