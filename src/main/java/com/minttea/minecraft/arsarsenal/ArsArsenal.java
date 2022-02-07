package com.minttea.minecraft.arsarsenal;

import com.minttea.minecraft.arsarsenal.setup.ClientEvents;
import com.minttea.minecraft.arsarsenal.setup.registries.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("arsarsenal")
@Mod.EventBusSubscriber(modid = ArsArsenal.MODID)
public class ArsArsenal {

    public static final String MODID = "arsarsenal";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static CreativeModeTab itemGroup = new CreativeModeTab(CreativeModeTab.getGroupCountSafe(), MODID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return ItemRegistry.fireSigil.getDefaultInstance();
        }
    };


    public ArsArsenal() {

        MinecraftForge.EVENT_BUS.register(this);
     //   FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

//    public void clientSetup(final FMLClientSetupEvent event){
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientEvents::registerRenderers);
//
//    }


}
