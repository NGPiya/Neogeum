package ch.piyamon.neogeum.item;

import ch.piyamon.neogeum.Neogeum;
import ch.piyamon.neogeum.block.ModBlocks;
import ch.piyamon.neogeum.entity.ModEntities;
import ch.piyamon.neogeum.item.custom.ModArmorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
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
        public static final RegistryObject<Item> ROSEQUARTZ = ITEMS.register("rose_quartz",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CARRUPTIUM = ITEMS.register("carruptium",
                () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> NEOGEUM_SWORD = ITEMS.register("neogeum_sword",
                () -> new SwordItem(ModToolTiers.NEOGEUM, 5, -2.4F, new Item.Properties().durability(3001)));
        public static final RegistryObject<Item> NEOGEUM_PICKAXE = ITEMS.register("neogeum_pickaxe",
                () -> new PickaxeItem(ModToolTiers.NEOGEUM, 1, -2.8F, new Item.Properties().durability(3001)));
        public static final RegistryObject<Item> NEOGEUM_SHOVEL = ITEMS.register("neogeum_shovel",
                () -> new ShovelItem(ModToolTiers.NEOGEUM,  1.5F, -3.0F, new Item.Properties().durability(3001)));
        public static final RegistryObject<Item> NEOGEUM_AXE = ITEMS.register("neogeum_axe",
                () -> new AxeItem(ModToolTiers.NEOGEUM, 5.0F, -3.0F, new Item.Properties().durability(3001)));
        public static final RegistryObject<Item> NEOGEUM_HOE = ITEMS.register("neogeum_hoe",
                () -> new HoeItem(ModToolTiers.NEOGEUM, -3, 0.0F, new Item.Properties().durability(3001)));
        public static final RegistryObject<Item> CARRUPTIUM_SWORD = ITEMS.register("carruptium_sword",
                () -> new SwordItem(ModToolTiers.CARRUPTIUM, 7, -2.4F, new Item.Properties().durability(3801)));
        public static final RegistryObject<Item> CARRUPTIUM_PICKAXE = ITEMS.register("carruptium_pickaxe",
                () -> new PickaxeItem(ModToolTiers.CARRUPTIUM, 1, -2.8F, new Item.Properties().durability(3801)));
        public static final RegistryObject<Item> CARRUPTIUM_SHOVEL = ITEMS.register("carruptium_shovel",
                () -> new ShovelItem(ModToolTiers.CARRUPTIUM,  1.5F, -3.0F, new Item.Properties().durability(3801)));
        public static final RegistryObject<Item> CARRUPTIUM_AXE = ITEMS.register("carruptium_axe",
                () -> new AxeItem(ModToolTiers.CARRUPTIUM, 7.0F, -3.0F, new Item.Properties().durability(3801)));
        public static final RegistryObject<Item> CARRUPTIUM_HOE = ITEMS.register("carruptium_hoe",
                () -> new HoeItem(ModToolTiers.CARRUPTIUM, -3, 0.0F, new Item.Properties().durability(3801)));

        public static final RegistryObject<Item> NEOGEUM_HELMET = ITEMS.register("neogeum_helmet",
                () -> new ArmorItem(ModArmorMaterials.NEOGEUM, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> NEOGEUM_CHESTPLATE = ITEMS.register("neogeum_chestplate",
                () -> new ArmorItem(ModArmorMaterials.NEOGEUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> NEOGEUM_LEGGING = ITEMS.register("neogeum_leggings",
                () -> new ArmorItem(ModArmorMaterials.NEOGEUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> NEOGEUM_BOOTS = ITEMS.register("neogeum_boots",
                () -> new ArmorItem(ModArmorMaterials.NEOGEUM, ArmorItem.Type.BOOTS, new Item.Properties()));
        public static final RegistryObject<Item> ROSEQUARTZ_HELMET = ITEMS.register("rose_quartz_helmet",
                () -> new ModArmorItem(ModArmorMaterials.ROSE_QUARTZ, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> ROSEQUARTZ_CHESTPLATE = ITEMS.register("rose_quartz_chestplate",
                () -> new ModArmorItem(ModArmorMaterials.ROSE_QUARTZ, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> ROSEQUARTZ_LEGGING = ITEMS.register("rose_quartz_leggings",
                () -> new ModArmorItem(ModArmorMaterials.ROSE_QUARTZ, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> ROSEQUARTZ_BOOTS = ITEMS.register("rose_quartz_boots",
                () -> new ModArmorItem(ModArmorMaterials.ROSE_QUARTZ, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<Item> NEOGEUMPOTATO = ITEMS.register("neogeum_potato",
                () -> new Item(new Item.Properties().food(ModFoodProperties.NEOGEUMPOTATO)));

        public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
                () -> new Item(new Item.Properties().food(ModFoodProperties.CHEESE)));

        public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
                () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
                () -> new Item(new Item.Properties().food(ModFoodProperties.TOMATO)));

        public static final RegistryObject<Item> MEGABLAZE_SPAWN_EGG = ITEMS.register("megablaze_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntities.MEGABLAZE, 16167425, 9109504,
                        new Item.Properties()));

}
