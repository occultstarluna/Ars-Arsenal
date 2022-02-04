package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.minttea.minecraft.arsarsenal.ArsArsenal;
import com.minttea.minecraft.arsarsenal.common.items.SourceSteelPick;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PickModel extends AnimatedGeoModel<SourceSteelPick> {
    @Override
    public ResourceLocation getModelLocation(SourceSteelPick wand) {
        return new ResourceLocation(ArsArsenal.MODID , "geo/pick.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SourceSteelPick wand) {
        return  new ResourceLocation(ArsArsenal.MODID, "textures/items/source_steel_pickaxe.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SourceSteelPick wand) {
        return new ResourceLocation(ArsArsenal.MODID , "animations/pick.json");
    }

}
