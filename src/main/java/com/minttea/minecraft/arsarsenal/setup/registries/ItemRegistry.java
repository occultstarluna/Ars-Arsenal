package com.minttea.minecraft.arsarsenal.setup.registries;

import com.minttea.minecraft.arsarsenal.ArsArsenal;
import com.minttea.minecraft.arsarsenal.client.renderer.item.AirHatRenderer;
import com.minttea.minecraft.arsarsenal.client.renderer.item.AquaHatRenderer;
import com.minttea.minecraft.arsarsenal.client.renderer.item.EarthHatRenderer;
import com.minttea.minecraft.arsarsenal.client.renderer.item.FireHatRenderer;
import com.minttea.minecraft.arsarsenal.common.armor.*;
import com.minttea.minecraft.arsarsenal.common.items.SourceSteelAxe;
import com.minttea.minecraft.arsarsenal.common.items.SourceSteelPick;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;


@Mod.EventBusSubscriber(modid = ArsArsenal.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@Mod(ArsArsenal.MODID)
public class ItemRegistry {


    @ObjectHolder("source_steel_helmet")public static SourceSteelArmor sourceSteelHelmet;
    @ObjectHolder("source_steel_chestplate")public static SourceSteelArmor sourceSteelChestplate;
    @ObjectHolder("source_steel_leggings")public static SourceSteelArmor sourceSteelLeggings;
    @ObjectHolder("source_steel_boots")public static SourceSteelArmor sourceSteelBoots;
    @ObjectHolder("fire_hat")public static FireHat fireHat;
    @ObjectHolder("fire_hood")public static FireRobes fireHood;
    @ObjectHolder("fire_robes")public static FireRobes fireRobe;
    @ObjectHolder("fire_leggings")public static FireRobes fireLegs;
    @ObjectHolder("fire_boots")public static FireRobes fireBoots;
    @ObjectHolder("aqua_hat")public static AquaHat aquaHat;
    @ObjectHolder("aqua_hood")public static AquaRobes aquaHood;
    @ObjectHolder("aqua_robes")public static AquaRobes aquaRobe;
    @ObjectHolder("aqua_leggings")public static AquaRobes aquaLegs;
    @ObjectHolder("aqua_boots")public static AquaRobes aquaBoots;
    @ObjectHolder("earth_hat")public static EarthHat earthHat;
    @ObjectHolder("earth_hood")public static EarthHat earthHood;
    @ObjectHolder("earth_robes")public static EarthRobes earthRobe;
    @ObjectHolder("earth_leggings")public static EarthRobes earthLegs;
    @ObjectHolder("earth_boots")public static EarthRobes earthBoots;
    @ObjectHolder("air_hat")public static AirHat airHat;
    @ObjectHolder("air_hood")public static AirRobes airHood;
    @ObjectHolder("air_robes")public static AirRobes airRobe;
    @ObjectHolder("air_leggings")public static AirRobes airLegs;
    @ObjectHolder("air_boots")public static AirRobes airBoots;
    @ObjectHolder("source_steel_ingot")public static Item sourceSteelIngot;
    @ObjectHolder("sigil_of_pyromancy")public static Item fireSigil;
    @ObjectHolder("sigil_of_aquamancy")public static Item aquaSigil;
    @ObjectHolder("sigil_of_geomancy")public static Item earthSigil;
    @ObjectHolder("sigil_of_aethermancy")public static Item aetherSigil;

    @ObjectHolder("source_steel_axe")public static SourceSteelAxe chargedAxe;
    @ObjectHolder("source_steel_pickaxe")public static SourceSteelPick sourcePick;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        final IForgeRegistry<Item> registry = event.getRegistry();


        Item[] items = {
        new SourceSteelArmor(EquipmentSlot.HEAD).setRegistryName("source_steel_helmet"),
        new SourceSteelArmor(EquipmentSlot.CHEST).setRegistryName("source_steel_chestplate"),
        new SourceSteelArmor(EquipmentSlot.LEGS).setRegistryName("source_steel_leggings"),
        new SourceSteelArmor(EquipmentSlot.FEET).setRegistryName("source_steel_boots"),

        new FireHat().setRegistryName("fire_hat"),
        new FireRobes(EquipmentSlot.CHEST).setRegistryName("fire_robes"),
        new FireRobes(EquipmentSlot.LEGS).setRegistryName("fire_leggings"),
        new FireRobes(EquipmentSlot.FEET).setRegistryName("fire_boots"),

        new AquaHat().setRegistryName("aqua_hat"),
        new AquaRobes(EquipmentSlot.CHEST).setRegistryName("aqua_robes"),
        new AquaRobes(EquipmentSlot.LEGS).setRegistryName("aqua_leggings"),
        new AquaRobes(EquipmentSlot.FEET).setRegistryName("aqua_boots"),

        new EarthHat().setRegistryName("earth_hat"),
        new EarthRobes(EquipmentSlot.CHEST).setRegistryName("earth_robes"),
        new EarthRobes(EquipmentSlot.LEGS).setRegistryName("earth_leggings"),
        new EarthRobes(EquipmentSlot.FEET).setRegistryName("earth_boots"),

        new AirHat().setRegistryName("air_hat"),
        new AirRobes(EquipmentSlot.CHEST).setRegistryName("air_robes"),
        new AirRobes(EquipmentSlot.LEGS).setRegistryName("air_leggings"),
        new AirRobes(EquipmentSlot.FEET).setRegistryName("air_boots"),

        new Item(defaultItemProperties().stacksTo(64)).setRegistryName("primed_iron_ingot"),
        new Item(defaultItemProperties().stacksTo(64)).setRegistryName("source_steel_ingot"),

        new Item(defaultItemProperties().stacksTo(4)).setRegistryName("sigil_of_pyromancy"),
        new Item(defaultItemProperties().stacksTo(4)).setRegistryName("sigil_of_aquamancy"),
        new Item(defaultItemProperties().stacksTo(4)).setRegistryName("sigil_of_geomancy"),
        new Item(defaultItemProperties().stacksTo(4)).setRegistryName("sigil_of_aethermancy"),

        new SourceSteelAxe().setRegistryName("source_steel_axe"),
        new SourceSteelPick().setRegistryName("source_steel_pickaxe")
        };

        for (final Item i: items) {
            registry.register(i);
        }

    }

    public static Item.Properties defaultItemProperties() {
        return new Item.Properties().tab(ArsArsenal.itemGroup);
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.AddLayers event)
    {

        GeoArmorRenderer.registerArmorRenderer(FireHat.class, new FireHatRenderer());
        GeoArmorRenderer.registerArmorRenderer(EarthHat.class, new EarthHatRenderer());
        GeoArmorRenderer.registerArmorRenderer(AquaHat.class, new AquaHatRenderer());
        GeoArmorRenderer.registerArmorRenderer(AirHat.class, new AirHatRenderer());
    }
}
