package ch.piyamon.neogeum.event;

import ch.piyamon.neogeum.Neogeum;
import ch.piyamon.neogeum.entity.Client.MegablazeModel;
import ch.piyamon.neogeum.entity.ModEntities;
import ch.piyamon.neogeum.entity.custom.MegablazeEntity;
import ch.piyamon.neogeum.entity.layers.ModModelLayers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Neogeum.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.MEGABLAZE_LOCATION, MegablazeModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MEGABLAZE.get(), MegablazeEntity.createAttributes().build());
    }

}