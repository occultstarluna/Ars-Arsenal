package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.minttea.minecraft.arsarsenal.ArsArsenal;
import com.minttea.minecraft.arsarsenal.common.armor.EarthHat;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EarthHatModel extends AnimatedGeoModel<EarthHat> {
    @Override
    public ResourceLocation getModelLocation(EarthHat wand) {
        return new ResourceLocation(ArsArsenal.MODID , "geo/earth_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EarthHat hat) {
        return  new ResourceLocation(ArsArsenal.MODID, "textures/items/"+hat.getTextureName()+"_tex.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EarthHat wand) {
        return new ResourceLocation(ArsArsenal.MODID , "animations/axe.json");
    }

}
