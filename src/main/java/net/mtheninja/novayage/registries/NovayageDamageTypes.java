package net.mtheninja.novayage.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.mtheninja.novayage.Novayage;

public class NovayageDamageTypes {
    public static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(
                Registries.DAMAGE_TYPE,
                ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(Novayage.MOD_ID, name).toString())
        );
    }

    public static final ResourceKey<DamageType> ASTRAL_MAGIC = register("astral");

    public static void bootstrap(BootstrapContext<DamageType> context)
    {
        context.register(ASTRAL_MAGIC, new DamageType(ASTRAL_MAGIC.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0F));
    }
}