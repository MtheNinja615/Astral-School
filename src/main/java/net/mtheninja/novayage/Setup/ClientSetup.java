package net.mtheninja.novayage.Setup;

import net.mtheninja.novayage.Novayage;
import net.mtheninja.novayage.entity.spells.starstrike.StarStrikeRenderer;
import net.mtheninja.novayage.registries.EntityRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Novayage.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegistry.STAR_STRIKE.get(), StarStrikeRenderer::new);

    }



}
