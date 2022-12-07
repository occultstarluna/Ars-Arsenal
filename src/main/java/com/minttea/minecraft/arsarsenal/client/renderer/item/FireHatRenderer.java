package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.minttea.minecraft.arsarsenal.common.armor.FireHat;
import software.bernie.ars_nouveau.geckolib3.renderers.geo.GeoArmorRenderer;

public class FireHatRenderer extends GeoArmorRenderer<FireHat> {
    public FireHatRenderer() {
        super(new FireHatModel());

        this.headBone = "bipedHead";
    }

}
