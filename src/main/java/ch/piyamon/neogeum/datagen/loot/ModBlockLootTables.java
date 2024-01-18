package ch.piyamon.neogeum.datagen.loot;

import ch.piyamon.neogeum.block.ModBlocks;
import ch.piyamon.neogeum.block.custom.TomatoCropBlock;
import ch.piyamon.neogeum.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.NEOGEUM_BLOCK.get());
        this.dropSelf(ModBlocks.ROSEQUARTZ_BLOCK.get());
        this.dropSelf(ModBlocks.CARRUPTIUM_BLOCK.get());
        this.dropSelf(ModBlocks.MILK_PROCESSOR.get());

        this.add(ModBlocks.NEOGEUM_ORE.get(),
                block -> createOreDrop(ModBlocks.NEOGEUM_ORE.get(), ModItems.NEOGEUMSHARD.get()));
        this.add(ModBlocks.ROSEQUARTZ_ORE.get(),
                block -> createOreDrop(ModBlocks.ROSEQUARTZ_ORE.get(), ModItems.ROSEQUARTZ.get()));
        this.add(ModBlocks.CARRUPTIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.CARRUPTIUM_ORE.get(), ModItems.CARRUPTIUM.get()));




        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 5));
        this.add(ModBlocks.TOMATO_CROP.get(), this.createCropDrops(ModBlocks.TOMATO_CROP.get(),
                ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.get(), lootitemcondition$builder1));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}