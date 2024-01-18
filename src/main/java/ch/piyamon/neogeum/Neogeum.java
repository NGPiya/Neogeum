package ch.piyamon.neogeum;

import ch.piyamon.neogeum.block.ModBlocks;
import ch.piyamon.neogeum.block.entity.ModBlockEntities;
import ch.piyamon.neogeum.entity.Client.MegablazeRenderer;
import ch.piyamon.neogeum.entity.ModEntities;
import ch.piyamon.neogeum.item.ModCreativeModeTabs;
import ch.piyamon.neogeum.item.ModItems;
import ch.piyamon.neogeum.recipe.ModRecipes;
import ch.piyamon.neogeum.screen.MilkProcessorScreen;
import ch.piyamon.neogeum.screen.ModMenuTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Neogeum.MOD_ID)
public class Neogeum {
    public static final String MOD_ID = "neogeum";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Neogeum() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.MEGABLAZE.get(), MegablazeRenderer::new);
            MenuScreens.register(ModMenuTypes.MILK_PROCESSOR_MENU.get(), MilkProcessorScreen::new);

        }
    }
}