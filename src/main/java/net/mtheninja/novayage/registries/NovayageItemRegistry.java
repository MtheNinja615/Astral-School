package net.mtheninja.novayage.registries;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.item.UpgradeOrbItem;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.*;
import net.mtheninja.novayage.Items.Weapons.NovayageExtendedWeaponsTiers;
import net.mtheninja.novayage.Novayage;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;
import java.util.function.Supplier;

public class NovayageItemRegistry {
    // Ace comment here, but as a tip for organization, leave some comments for whatever section of
    // Items you want to be organized
    // In DTE, I use comment blocks to organize between different types of items I have (armor, weapons, staves, etc.)
    // Just a little info for you!
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Novayage.MOD_ID);

    //Weapons

    //Rudimentary Dusk Axe
    public static final DeferredHolder<Item, Item> RUDIMENTARY_DUSK_AXE = ITEMS.register("rudimentary_dusk_axe", () ->
            new MagicSwordItem(NovayageExtendedWeaponsTiers.RUDIMENTARY_DUSK_AXE, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(NovayageExtendedWeaponsTiers.RUDIMENTARY_DUSK_AXE)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.STARFALL_SPELL, 1))));
    //Rudimentary Dawn Sword
    public static final DeferredHolder<Item, Item> RUDIMENTARY_DAWN_SWORD = ITEMS.register("rudimentary_dawn_sword", () ->
            new MagicSwordItem(NovayageExtendedWeaponsTiers.RUDIMENTARY_DAWN_SWORD, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(NovayageExtendedWeaponsTiers.RUDIMENTARY_DAWN_SWORD)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.SUNBEAM_SPELL, 1))));

    //Crafting Items
    public static final DeferredItem<Item> SUNFALL_INGOT = ITEMS.register("sunfall_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MOONFALL_INGOT = ITEMS.register("moonfall_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUSK_CRYSTAL = ITEMS.register("dusk_crystal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DAWN_CRYSTAL = ITEMS.register("dawn_crystal",
            () -> new Item(new Item.Properties()));
    /***
     * Upgrade orbs
     */

// Astral Upgrade Orb
    public static final DeferredHolder<Item, Item> ASTRAL_UPGRADE_ORB = ITEMS.register("astral_upgrade_orb",
            () -> new UpgradeOrbItem(ItemPropertiesHelper
                    .material()
                    .rarity(Rarity.UNCOMMON)
                    .component(ComponentRegistry.UPGRADE_ORB_TYPE, NovayageUpgradeOrbTypeRegistry.ASTRAL_SPELL_POWER))
    );


    public static Collection<DeferredHolder<Item, ? extends Item>> getNovaItems()
    {
        return ITEMS.getEntries();
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

    public static class NovayageBlocks {
        public static final DeferredRegister.Blocks BLOCKS =
                DeferredRegister.createBlocks(Novayage.MOD_ID);


        private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
            DeferredBlock<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn);
            return toReturn;
        }

        private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
            ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }

        public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
        }

    }
}
