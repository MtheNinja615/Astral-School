package net.mtheninja.novayage.registries;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.mtheninja.novayage.Novayage;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NovayageCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Novayage.MOD_ID);

    public static final Supplier<CreativeModeTab> NOVAYAGE_MATERIALS = CREATIVE_MODE_TAB.register("novayage_materials",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NovayageItemRegistry.DAWN_CRYSTAL.get()))
                    .title(Component.translatable("creativetab.novayage.novayage"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(NovayageItemRegistry.DAWN_CRYSTAL.get());
                        output.accept(NovayageItemRegistry.DUSK_CRYSTAL.get());
                        output.accept(NovayageItemRegistry.SUNFALL_INGOT.get());
                        output.accept(NovayageItemRegistry.MOONFALL_INGOT.get());
                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
