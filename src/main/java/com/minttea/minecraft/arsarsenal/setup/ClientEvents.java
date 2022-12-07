package com.minttea.minecraft.arsarsenal.setup;

import com.minttea.minecraft.arsarsenal.ArsArsenal;
import com.minttea.minecraft.arsarsenal.client.renderer.item.AirHatRenderer;
import com.minttea.minecraft.arsarsenal.client.renderer.item.AquaHatRenderer;
import com.minttea.minecraft.arsarsenal.client.renderer.item.EarthHatRenderer;
import com.minttea.minecraft.arsarsenal.client.renderer.item.FireHatRenderer;
import com.minttea.minecraft.arsarsenal.common.armor.AirHat;
import com.minttea.minecraft.arsarsenal.common.armor.AquaHat;
import com.minttea.minecraft.arsarsenal.common.armor.EarthHat;
import com.minttea.minecraft.arsarsenal.common.armor.FireHat;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.ars_nouveau.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = ArsArsenal.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {


    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.AddLayers event)
    {
        GeoArmorRenderer.registerArmorRenderer(FireHat.class, new FireHatRenderer());
        GeoArmorRenderer.registerArmorRenderer(EarthHat.class, new EarthHatRenderer());
        GeoArmorRenderer.registerArmorRenderer(AquaHat.class, new AquaHatRenderer());
        GeoArmorRenderer.registerArmorRenderer(AirHat.class, new AirHatRenderer());
    }

}
