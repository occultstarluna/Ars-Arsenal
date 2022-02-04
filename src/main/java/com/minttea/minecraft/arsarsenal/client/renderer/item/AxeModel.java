package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.hollingsworth.arsnouveau.ArsNouveau;
import com.minttea.minecraft.arsarsenal.ArsArsenal;
import com.minttea.minecraft.arsarsenal.common.items.SourceSteelAxe;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AxeModel extends AnimatedGeoModel<SourceSteelAxe> {
    @Override
    public ResourceLocation getModelLocation(SourceSteelAxe wand) {
        return new ResourceLocation(ArsArsenal.MODID , "geo/axe.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SourceSteelAxe wand) {
        return  new ResourceLocation(ArsArsenal.MODID, "textures/items/source_steel_axe.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SourceSteelAxe wand) {
        return new ResourceLocation(ArsArsenal.MODID , "animations/axe.json");
    }

}
