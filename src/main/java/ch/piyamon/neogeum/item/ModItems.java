package ch.piyamon.neogeum.item;

import ch.piyamon.neogeum.Neogeum;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
        public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, Neogeum.MOD_ID);

        public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
        }

        public static final RegistryObject<Item> NEOGEUM = ITEMS.register("neogeum",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> NEOGEUMSHARD = ITEMS.register("neogeum_shard",
            () -> new Item(new Item.Properties()));


}
