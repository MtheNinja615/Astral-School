package net.mtheninja.novayage.entity.spells.starstrike;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.mtheninja.novayage.Novayage;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;

import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class StarStrikeRenderer extends GeoEntityRenderer<StarStrike> {
    public StarStrikeRenderer(EntityRendererProvider.Context context) {
        super(context, new StarStrikeModel());
        this.shadowRadius = 0f;
    }

    @Override
    public ResourceLocation getTextureLocation(StarStrike animatable) {
        int frame = (animatable.tickCount / 2) % 3;
        return ResourceLocation.fromNamespaceAndPath(Novayage.MOD_ID, "textures/spells/starstrike_" + frame + ".png");
    }

    @Override
    public void preRender(PoseStack poseStack, StarStrike animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {

        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, animatable.yRotO, animatable.getYRot())));
        poseStack.mulPose(Axis.XP.rotationDegrees(-Mth.lerp(partialTick, animatable.xRotO, animatable.getXRot())));

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }

    @Override
    public RenderType getRenderType(StarStrike animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.energySwirl(texture, 0, 0);
    }
}