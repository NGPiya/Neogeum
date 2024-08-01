package ch.piyamon.neogeum.datagen;

import ch.piyamon.neogeum.Neogeum;
import ch.piyamon.neogeum.block.ModBlocks;
import ch.piyamon.neogeum.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Neogeum.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NEOGEUM_ORE.get(),
                        ModBlocks.NEOGEUM_BLOCK.get(),
                        ModBlocks.ROSEQUARTZ_ORE.get(),
                        ModBlocks.ROSEQUARTZ_BLOCK.get(),
                        ModBlocks.CARRUPTIUM_ORE.get(),
                        ModBlocks.CARRUPTIUM_BLOCK.get(),
                        ModBlocks.MILK_PROCESSOR.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MILK_PROCESSOR.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NEOGEUM_ORE.get(),
                        ModBlocks.NEOGEUM_BLOCK.get());

        this.tag(ModTags.Blocks.NEEDS_NEOGEUM_TOOL)
                .add(ModBlocks.ROSEQUARTZ_ORE.get(),
                        ModBlocks.ROSEQUARTZ_BLOCK.get(),
                        ModBlocks.CARRUPTIUM_ORE.get(),
                        ModBlocks.CARRUPTIUM_BLOCK.get(),
                        ModBlocks.MILK_PROCESSOR.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}