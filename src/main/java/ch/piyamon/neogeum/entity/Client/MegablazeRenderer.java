package ch.piyamon.neogeum.entity.Client;

import ch.piyamon.neogeum.Neogeum;
import com.mojang.blaze3d.vertex.PoseStack;
import ch.piyamon.neogeum.entity.custom.MegablazeEntity;
import ch.piyamon.neogeum.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MegablazeRenderer extends MobRenderer<MegablazeEntity, MegablazeModel<MegablazeEntity>> {
    private static final ResourceLocation MEGABLAZE_LOCATION = new ResourceLocation(Neogeum.MOD_ID,"textures/entity/megablaze.png");

    public MegablazeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MegablazeModel<>(pContext.bakeLayer(ModModelLayers.MEGABLAZE_LOCATION)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(MegablazeEntity pEntity) {
        return MEGABLAZE_LOCATION;
    }

    @Override
    public void render(MegablazeEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}