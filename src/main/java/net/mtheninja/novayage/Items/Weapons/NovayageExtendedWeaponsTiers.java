package net.mtheninja.novayage.Items.Weapons;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.mtheninja.novayage.registries.NovayageAttributeRegistry;

import java.util.function.Supplier;

public class NovayageExtendedWeaponsTiers implements Tier, IronsWeaponTier {
    //Dusk Axe
    public static NovayageExtendedWeaponsTiers RUDIMENTARY_DUSK_AXE = new NovayageExtendedWeaponsTiers(16000, 9, -2.5F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
            new AttributeContainer(AttributeRegistry.MAX_MANA, 50, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(NovayageAttributeRegistry.ASTRAL_MAGIC_POWER, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );
    //Dusk Axe
    public static NovayageExtendedWeaponsTiers RUDIMENTARY_DAWN_SWORD = new NovayageExtendedWeaponsTiers(16000, 9, -2.5F, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
            new AttributeContainer(AttributeRegistry.MAX_MANA, 50, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(NovayageAttributeRegistry.ASTRAL_MAGIC_POWER, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );


    //private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final TagKey<Block> incorrectBlocksForDrops;
    private final Supplier<Ingredient> repairIngredient;
    private final AttributeContainer[] attributeContainers;

    private NovayageExtendedWeaponsTiers(int uses, float damage, float speed, int enchantmentValue, TagKey<Block> incorrectBlocksForDrops, Supplier<Ingredient> repairIngredient, AttributeContainer... attributes) {
        //this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.repairIngredient = repairIngredient;
        this.attributeContainers = attributes;
    }

    @Override
    public AttributeContainer[] getAdditionalAttributes() {
        return this.attributeContainers;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
