package ch.piyamon.neogeum.item;

import ch.piyamon.neogeum.Neogeum;
import ch.piyamon.neogeum.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Neogeum.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COURSE_TAB = CREATIVE_MODE_TABS.register("neogeum",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NEOGEUM.get()))
                    .title(Component.translatable("creativetab.neogeum"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.NEOGEUM.get());
                        output.accept(ModItems.NEOGEUMSHARD.get());

                        output.accept(ModBlocks.NEOGEUM_BLOCK.get());
                        output.accept(ModBlocks.NEOGEUM_ORE.get());
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
