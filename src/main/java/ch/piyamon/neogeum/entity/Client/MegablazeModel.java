package ch.piyamon.neogeum.entity.Client;

import ch.piyamon.neogeum.entity.animations.ModAnimationDefinitions;
import ch.piyamon.neogeum.entity.custom.MegablazeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

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

        PartDefinition Megablaze = partdefinition.addOrReplaceChild("Megablaze", CubeListBuilder.create(), PartPose.offset(0.0F, 52.0F, 0.0F));

        PartDefinition Head = Megablaze.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -72.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Shield = Megablaze.addOrReplaceChild("Shield", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = Shield.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 16).addBox(11.0F, -63.0F, -5.0F, 2.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5798F, -1.4987F, -1.5785F));

        PartDefinition cube_r2 = Shield.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 16).addBox(-12.0F, -63.0F, -5.0F, 2.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5819F, -1.512F, 1.5832F));

        PartDefinition cube_r3 = Shield.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 16).addBox(13.0F, -63.0F, -5.0F, 2.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r4 = Shield.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 16).addBox(-14.0F, -63.0F, -5.0F, 2.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition Body = Megablaze.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, -64.0F, -2.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Helmet = Megablaze.addOrReplaceChild("Helmet", CubeListBuilder.create().texOffs(24, 18).addBox(-4.0F, -72.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(MegablazeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(ModAnimationDefinitions.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 1f);
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