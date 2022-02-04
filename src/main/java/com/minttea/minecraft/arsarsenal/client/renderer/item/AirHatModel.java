package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.minttea.minecraft.arsarsenal.ArsArsenal;
import com.minttea.minecraft.arsarsenal.common.armor.AirHat;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AirHatModel extends AnimatedGeoModel<AirHat> {
    @Override
    public ResourceLocation getModelLocation(AirHat hat) {
        return new ResourceLocation(ArsArsenal.MODID , "geo/air_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AirHat hat) {
        return  new ResourceLocation(ArsArsenal.MODID, "textures/items/"+hat.getTextureName()+"_tex.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AirHat hat) {
        return new ResourceLocation(ArsArsenal.MODID , "animations/axe.json");
    }

}
