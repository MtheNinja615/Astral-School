package net.mtheninja.novayage;

import net.minecraft.resources.ResourceLocation;
import net.mtheninja.novayage.registries.NovayageAttributeRegistry;
import net.mtheninja.novayage.registries.NovayageCreativeModeTabs;
import net.mtheninja.novayage.registries.NovayageItemRegistry;
import net.mtheninja.novayage.registries.NovayageSchoolRegistry;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Novayage.MOD_ID)
public class Novayage {
    public static final String MOD_ID = "novayage";
    private static final Logger LOGGER = LogUtils.getLogger();


    public Novayage(IEventBus modEventBus, ModContainer modContainer)
    {

           NovayageItemRegistry.register(modEventBus);
           NovayageItemRegistry.NovayageBlocks.register(modEventBus);
           NovayageCreativeModeTabs.register(modEventBus);

           NovayageAttributeRegistry.register(modEventBus);
           NovayageSchoolRegistry.register(modEventBus);

           NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, NovayageConfig.SPEC);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (NovayageConfig.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", NovayageConfig.MAGIC_NUMBER_INTRODUCTION.get(), NovayageConfig.MAGIC_NUMBER.getAsInt());

        NovayageConfig.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME => {}", Minecraft.getInstance().getUser().getName());
        }
    }

    public static ResourceLocation id(@NotNull String path)
    {
        return ResourceLocation.fromNamespaceAndPath(Novayage.MOD_ID, path);
    }
}