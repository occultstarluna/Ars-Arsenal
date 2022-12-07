package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.minttea.minecraft.arsarsenal.ArsArsenal;
import com.minttea.minecraft.arsarsenal.common.armor.FireHat;
import net.minecraft.resources.ResourceLocation;
import software.bernie.ars_nouveau.geckolib3.model.AnimatedGeoModel;

public class FireHatModel extends AnimatedGeoModel<FireHat> {
    @Override
    public ResourceLocation getModelLocation(FireHat wand) {
        return new ResourceLocation(ArsArsenal.MODID , "geo/fire_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(FireHat hat) {
        return  new ResourceLocation(ArsArsenal.MODID, "textures/items/"+hat.getTextureName()+"_tex.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(FireHat wand) {
        return new ResourceLocation(ArsArsenal.MODID , "animations/axe.json");
    }

}
