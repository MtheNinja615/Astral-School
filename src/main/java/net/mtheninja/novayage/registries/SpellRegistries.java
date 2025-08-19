package net.mtheninja.novayage.registries;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.mtheninja.novayage.Novayage;
import net.mtheninja.novayage.spells.StarStrikeSpell;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SpellRegistry.SPELL_REGISTRY_KEY;

public class SpellRegistries {
    public static final DeferredRegister<AbstractSpell> SPELLS = DeferredRegister.create(SPELL_REGISTRY_KEY, Novayage.MOD_ID);

    public static Supplier<AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }


    //Star Strike
    public static final Supplier<AbstractSpell> STAR_STRIKE = registerSpell(new StarStrikeSpell());

    public static void register(IEventBus eventBus)
    {
        SPELLS.register(eventBus);
    }
}
