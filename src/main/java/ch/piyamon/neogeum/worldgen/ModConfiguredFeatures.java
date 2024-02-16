package ch.piyamon.neogeum.worldgen;

import ch.piyamon.neogeum.Neogeum;
import ch.piyamon.neogeum.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> NEOGEUM_ORE_KEY = registerKey("neogeum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROSE_QUARTZ_ORE_KEY = registerKey("rose_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CARRUPTIUM_ORE_KEY = registerKey("carruptium_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest netherReplaceables = new BlockMatchTest(Blocks.BASALT);
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> NeogeumOres = List.of(OreConfiguration.target(netherReplaceables,
                        ModBlocks.NEOGEUM_ORE.get().defaultBlockState()));


        register(context, NEOGEUM_ORE_KEY, Feature.ORE, new OreConfiguration(NeogeumOres, 6));
        register(context, ROSE_QUARTZ_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                ModBlocks.ROSEQUARTZ_ORE.get().defaultBlockState(), 3));
        register(context, CARRUPTIUM_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                ModBlocks.CARRUPTIUM_ORE.get().defaultBlockState(), 3));


    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Neogeum.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
