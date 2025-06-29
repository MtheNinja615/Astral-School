package net.mtheninja.novayage.registries;

import io.redspace.ironsspellbooks.item.armor.UpgradeOrbType;
import io.redspace.ironsspellbooks.registries.UpgradeOrbTypeRegistry;
import net.minecraft.resources.ResourceKey;
import net.mtheninja.novayage.Novayage;

public class NovayageUpgradeOrbTypeRegistry {

    public static ResourceKey<UpgradeOrbType> ASTRAL_SPELL_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, Novayage.id("astral_power"));
   }