package com.minttea.minecraft.arsarsenal;

import com.hollingsworth.arsnouveau.setup.ItemsRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
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
            return ItemsRegistry.CREATIVE_SPELLBOOK.getDefaultInstance();
        }
    };


    public ArsArsenal() {

        MinecraftForge.EVENT_BUS.register(this);
    }


}
