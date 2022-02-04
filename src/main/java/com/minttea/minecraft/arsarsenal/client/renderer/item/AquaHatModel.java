package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.minttea.minecraft.arsarsenal.ArsArsenal;
import com.minttea.minecraft.arsarsenal.common.armor.AquaHat;
import com.minttea.minecraft.arsarsenal.common.armor.EarthHat;
import net.minecraft.resources.ResourceLocation;

import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AquaHatModel extends AnimatedGeoModel<AquaHat> {
    @Override
    public ResourceLocation getModelLocation(AquaHat hat) {
        return new ResourceLocation(ArsArsenal.MODID , "geo/aqua_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AquaHat hat) {
        return  new ResourceLocation(ArsArsenal.MODID, "textures/items/"+hat.getTextureName()+"_tex.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AquaHat hat) {
        return new ResourceLocation(ArsArsenal.MODID , "animations/axe.json");
    }

}
