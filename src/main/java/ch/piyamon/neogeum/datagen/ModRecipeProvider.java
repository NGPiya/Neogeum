package ch.piyamon.neogeum.datagen;

import ch.piyamon.neogeum.Neogeum;
import ch.piyamon.neogeum.block.ModBlocks;
import ch.piyamon.neogeum.datagen.custom.MilkProcessorRecipeBuilder;
import ch.piyamon.neogeum.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SMELTABLES = List.of(ModBlocks.NEOGEUM_ORE.get(),ModBlocks.CARRUPTIUM_ORE.get(),
            ModBlocks.ROSEQUARTZ_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NEOGEUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.NEOGEUM.get())
                .unlockedBy("has_neogeum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NEOGEUM.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.NEOGEUMSHARD.get())
                .unlockedBy("has_neogeum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSEQUARTZ_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ROSEQUARTZ.get())
                .unlockedBy("has_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ROSEQUARTZ.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NEOGEUMPOTATO.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModItems.NEOGEUM.get())
                .define('B', Items.POTATO)
                .unlockedBy("has_neogeum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NEOGEUM_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.NEOGEUM.get())
                .define('B', Items.STICK)
                .unlockedBy("has_neogeum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NEOGEUM_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.NEOGEUM.get())
                .define('B', Items.STICK)
                .unlockedBy("has_neogeum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NEOGEUM_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.NEOGEUM.get())
                .define('B', Items.STICK)
                .unlockedBy("has_neogeum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NEOGEUM_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.NEOGEUM.get())
                .define('B', Items.STICK)
                .unlockedBy("has_neogeum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NEOGEUM_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.NEOGEUM.get())
                .define('B', Items.STICK)
                .unlockedBy("has_neogeum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARRUPTIUM_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.CARRUPTIUM.get())
                .define('B', Items.STICK)
                .unlockedBy("has_carruptium", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CARRUPTIUM.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARRUPTIUM_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.CARRUPTIUM.get())
                .define('B', Items.STICK)
                .unlockedBy("has_carruptium", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CARRUPTIUM.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARRUPTIUM_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.CARRUPTIUM.get())
                .define('B', Items.STICK)
                .unlockedBy("has_carruptium", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CARRUPTIUM.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARRUPTIUM_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.CARRUPTIUM.get())
                .define('B', Items.STICK)
                .unlockedBy("has_carruptium", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CARRUPTIUM.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARRUPTIUM_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.CARRUPTIUM.get())
                .define('B', Items.STICK)
                .unlockedBy("has_carruptium", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CARRUPTIUM.get()).build()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NEOGEUM_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.NEOGEUM.get())
                .unlockedBy("has_neogeum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NEOGEUM_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.NEOGEUM.get())
                .unlockedBy("has_neogeum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NEOGEUM_LEGGING.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.NEOGEUM.get())
                .unlockedBy("has_neogeum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NEOGEUM_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.NEOGEUM.get())
                .unlockedBy("has_neogeum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSEQUARTZ_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.ROSEQUARTZ.get())
                .unlockedBy("has_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ROSEQUARTZ.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSEQUARTZ_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ROSEQUARTZ.get())
                .unlockedBy("has_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ROSEQUARTZ.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSEQUARTZ_LEGGING.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ROSEQUARTZ.get())
                .unlockedBy("has_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ROSEQUARTZ.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ROSEQUARTZ_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ROSEQUARTZ.get())
                .unlockedBy("has_rose_quartz", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.NEOGEUM.get()).build()))
                .save(pWriter);

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.NEOGEUMSHARD.get(), RecipeCategory.MISC, ModItems.NEOGEUM.get(),
                "neogeum:neogeum_shard", "neogeum","neogeum:neogeum_to_neogeum_shard", "neogeum");

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.NEOGEUM.get(), RecipeCategory.MISC, ModBlocks.NEOGEUM_BLOCK.get(),
                "neogeum:block_neogeum", "neogeum","neogeum:neogeum_block_to_neogeum", "neogeum");

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.ROSEQUARTZ.get(), RecipeCategory.MISC, ModBlocks.ROSEQUARTZ_BLOCK.get(),
                "neogeum:block_rose_quartz", "rose_quartz","neogeum:rose_quartz_block_to_rose_quartz", "neogeum");


        new MilkProcessorRecipeBuilder(Items.MILK_BUCKET, ModItems.CHEESE.get(), 1)
                .unlockedBy("has_milk", has(Items.MILK_BUCKET)).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.PIZZA.get())
                .pattern("BBB")
                .pattern("CCC")
                .pattern("AAA")
                .define('A', Items.BREAD)
                .define('B', ModItems.CHEESE.get())
                .define('C', ModItems.TOMATO.get())
                .unlockedBy("has_tomato", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.TOMATO.get()).build()))
                .save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                            pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Neogeum.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}