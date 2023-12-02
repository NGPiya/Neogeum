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
                        output.accept(ModItems.NEOGEUM_SWORD.get());
                        output.accept(ModItems.NEOGEUM_PICKAXE.get());
                        output.accept(ModItems.NEOGEUM_AXE.get());
                        output.accept(ModItems.NEOGEUM_SHOVEL.get());
                        output.accept(ModItems.NEOGEUM_HOE.get());
                        output.accept(ModItems.ROSEQUARTZ.get());

                        output.accept(ModItems.NEOGEUM_HELMET.get());
                        output.accept(ModItems.NEOGEUM_CHESTPLATE.get());
                        output.accept(ModItems.NEOGEUM_LEGGING.get());
                        output.accept(ModItems.NEOGEUM_BOOTS.get());
                        output.accept(ModItems.ROSEQUARTZ_HELMET.get());
                        output.accept(ModItems.ROSEQUARTZ_CHESTPLATE.get());
                        output.accept(ModItems.ROSEQUARTZ_LEGGING.get());
                        output.accept(ModItems.ROSEQUARTZ_BOOTS.get());


                        output.accept(ModItems.NEOGEUMPOTATO.get());

                        output.accept(ModBlocks.NEOGEUM_BLOCK.get());
                        output.accept(ModBlocks.NEOGEUM_ORE.get());
                        output.accept(ModBlocks.ROSEQUARTZ_ORE.get());
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
