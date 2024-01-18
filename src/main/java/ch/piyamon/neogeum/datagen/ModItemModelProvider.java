package ch.piyamon.neogeum.datagen;

import ch.piyamon.neogeum.Neogeum;
import ch.piyamon.neogeum.block.ModBlocks;
import ch.piyamon.neogeum.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Neogeum.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.NEOGEUM);
        simpleItem(ModItems.NEOGEUMSHARD);
        simpleItem(ModItems.ROSEQUARTZ);
        simpleItem(ModItems.NEOGEUMPOTATO);
        simpleItem(ModItems.CARRUPTIUM);

        simpleItem(ModItems.TOMATO);
        simpleItem(ModItems.TOMATO_SEEDS);
        simpleItem(ModItems.CHEESE);
        simpleItem(ModItems.PIZZA);

        handheldItem(ModItems.NEOGEUM_SWORD);
        handheldItem(ModItems.NEOGEUM_PICKAXE);
        handheldItem(ModItems.NEOGEUM_SHOVEL);
        handheldItem(ModItems.NEOGEUM_AXE);
        handheldItem(ModItems.NEOGEUM_HOE);
        handheldItem(ModItems.CARRUPTIUM_SWORD);
        handheldItem(ModItems.CARRUPTIUM_PICKAXE);
        handheldItem(ModItems.CARRUPTIUM_SHOVEL);
        handheldItem(ModItems.CARRUPTIUM_AXE);
        handheldItem(ModItems.CARRUPTIUM_HOE);

        simpleItem(ModItems.NEOGEUM_HELMET);
        simpleItem(ModItems.NEOGEUM_CHESTPLATE);
        simpleItem(ModItems.NEOGEUM_LEGGING);
        simpleItem(ModItems.NEOGEUM_BOOTS);
        simpleItem(ModItems.ROSEQUARTZ_HELMET);
        simpleItem(ModItems.ROSEQUARTZ_CHESTPLATE);
        simpleItem(ModItems.ROSEQUARTZ_LEGGING);
        simpleItem(ModItems.ROSEQUARTZ_BOOTS);

        withExistingParent(ModItems.MEGABLAZE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Neogeum.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Neogeum.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Neogeum.MOD_ID,"item/" + item.getId().getPath()));
    }
}