package net.mtheninja.novayage.entity.spells.starstrike;

import net.minecraft.resources.ResourceLocation;
import net.mtheninja.novayage.Novayage;
import software.bernie.geckolib.model.GeoModel;

public class StarStrikeModel extends GeoModel<StarStrike> {

    @Override
    public ResourceLocation getModelResource(StarStrike animatable) {
        return ResourceLocation.fromNamespaceAndPath(Novayage.MOD_ID, "geo/entities/spells/starstrike.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StarStrike animatable) {
        int frameCount = 3;
        int frameDuration = 2; // ticks per frame
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(Novayage.MOD_ID, "textures/spells/starstrike" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(StarStrike animatable) {
        return ResourceLocation.fromNamespaceAndPath(Novayage.MOD_ID, "animations/entities/spells/starstrike.animation.json");
    }

}
