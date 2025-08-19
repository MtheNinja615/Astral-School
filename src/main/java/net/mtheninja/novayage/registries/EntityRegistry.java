package net.mtheninja.novayage.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.mtheninja.novayage.Novayage;
import net.mtheninja.novayage.entity.spells.starstrike.StarStrike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EntityRegistry {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister
            .create(Registries.ENTITY_TYPE, Novayage.MOD_ID);

    //Star Strike
    public static final DeferredHolder<EntityType<?>, EntityType<StarStrike>> STAR_STRIKE =
            ENTITIES.register("star_strike", () -> EntityType.Builder.<StarStrike>of(StarStrike::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(4)
                    .build(ResourceLocation.fromNamespaceAndPath(Novayage.MOD_ID, "star_strike").toString())
            );



    public static void register(IEventBus eventBus)
    {
        ENTITIES.register(eventBus);
    }
}