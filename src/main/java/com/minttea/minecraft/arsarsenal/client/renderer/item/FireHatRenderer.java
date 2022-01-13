package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.hollingsworth.arsnouveau.client.renderer.item.FixedGeoItemRenderer;
import com.minttea.minecraft.arsarsenal.common.armor.FireHat;
import com.minttea.minecraft.arsarsenal.common.armor.SchoolArmor;
import com.minttea.minecraft.arsarsenal.common.items.SourceSteelAxe;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import javax.annotation.Nullable;

public class FireHatRenderer extends GeoArmorRenderer<FireHat> {
    public FireHatRenderer() {
        super(new FireHatModel());

        this.headBone = "bipedHead";
    }

}
