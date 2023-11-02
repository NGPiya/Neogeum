package ch.piyamon.neogeum.item;

import ch.piyamon.neogeum.Neogeum;
import net.minecraft.world.item.*;
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

        public static final RegistryObject<Item> NEOGEUM_SWORD = ITEMS.register("neogeum_sword",
                () -> new SwordItem(ModToolTiers.NEOGEUM, 5, 3, new Item.Properties().durability(3001)));
        public static final RegistryObject<Item> NEOGEUM_PICKAXE = ITEMS.register("neogeum_pickaxe",
                () -> new PickaxeItem(ModToolTiers.NEOGEUM, 1, 2, new Item.Properties().durability(3001)));
        public static final RegistryObject<Item> NEOGEUM_SHOVEL = ITEMS.register("neogeum_shovel",
                () -> new ShovelItem(ModToolTiers.NEOGEUM, 2, 3, new Item.Properties().durability(3001)));
        public static final RegistryObject<Item> NEOGEUM_AXE = ITEMS.register("neogeum_axe",
                () -> new AxeItem(ModToolTiers.NEOGEUM, 2, 3, new Item.Properties().durability(3001)));
        public static final RegistryObject<Item> NEOGEUM_HOE = ITEMS.register("neogeum_hoe",
                () -> new HoeItem(ModToolTiers.NEOGEUM, 2, 3, new Item.Properties().durability(3001)));



}
