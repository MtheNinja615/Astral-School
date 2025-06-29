package net.mtheninja.novayage.registries;

import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja.novayage.Novayage;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SchoolRegistry.SCHOOL_REGISTRY_KEY;

public class NovayageSchoolRegistry {
    private static final DeferredRegister<SchoolType> NOVAYAGE_SCHOOLS = DeferredRegister.create(SCHOOL_REGISTRY_KEY, Novayage.MOD_ID);

    public static void register(IEventBus eventBus)
    {
        NOVAYAGE_SCHOOLS.register(eventBus);
    }

    private static Supplier<SchoolType> registerSchool(SchoolType type)
    {
        return NOVAYAGE_SCHOOLS.register(type.getId().getPath(), () -> type);
    }

    public static final ResourceLocation ASTRAL_RESOURCE = Novayage.id("astral");

    public static final Supplier<SchoolType> ASTRAL = registerSchool(new SchoolType
            (
                    ASTRAL_RESOURCE,
                    NovayageTags.ASTRAL_FOCUS,
                    Component.translatable("school.novayage.luminescent").withStyle(Style.EMPTY.withColor(0x2c2fb0)),
                    NovayageAttributeRegistry.ASTRAL_MAGIC_POWER,
                    NovayageAttributeRegistry.ASTRAL_MAGIC_RESIST,
                    SoundRegistry.EVOCATION_CAST,
                    NovayageDamageTypes.ASTRAL_MAGIC
            ));
}