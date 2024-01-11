package ch.piyamon.neogeum.entity.Client;

import ch.piyamon.neogeum.entity.animations.ModAnimationDefinitions;
import ch.piyamon.neogeum.entity.custom.MegablazeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class MegablazeModel<T extends MegablazeEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "megablaze"), "main");
    private final ModelPart Megablaze;

    public MegablazeModel(ModelPart root) {
        this.Megablaze = root.getChild("Megablaze");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Megablaze = partdefinition.addOrReplaceChild("Megablaze", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, 0.0F));

        PartDefinition head = Megablaze.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(24, 18).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

        PartDefinition Shield = Megablaze.addOrReplaceChild("Shield", CubeListBuilder.create().texOffs(0, 26).addBox(-5.0F, -19.0F, -8.0F, 10.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 26).addBox(-5.0F, -19.0F, 6.0F, 10.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(6.0F, -19.0F, -5.0F, 2.0F, 16.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-8.0F, -19.0F, -5.0F, 2.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(MegablazeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animate(entity.attackAnimationState, ModAnimationDefinitions.ATTACK, ageInTicks, 1f);
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Megablaze.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return Megablaze;
    }
}