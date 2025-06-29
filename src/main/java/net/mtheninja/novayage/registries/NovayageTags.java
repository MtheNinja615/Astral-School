package net.mtheninja.novayage.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.mtheninja.novayage.Novayage;

public class NovayageTags {

    /***
     * Items
     */

    // Astral School Focus
    public static final TagKey<Item> ASTRAL_FOCUS = ItemTags.create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(Novayage.MOD_ID, "astral_focus").toString()));
}