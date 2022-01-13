package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.minttea.minecraft.arsarsenal.ArsArsenal;
import com.minttea.minecraft.arsarsenal.common.armor.FireHat;
import com.minttea.minecraft.arsarsenal.common.armor.SchoolArmor;
import com.minttea.minecraft.arsarsenal.common.items.SourceSteelAxe;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FireHatModel extends AnimatedGeoModel<FireHat> {
    @Override
    public ResourceLocation getModelLocation(FireHat wand) {
        return new ResourceLocation(ArsArsenal.MODID , "geo/fire_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(FireHat hat) {
        return  new ResourceLocation(ArsArsenal.MODID, "textures/items/"+hat.getTextureName()+".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(FireHat wand) {
        return new ResourceLocation(ArsArsenal.MODID , "animations/axe.json");
    }

}
