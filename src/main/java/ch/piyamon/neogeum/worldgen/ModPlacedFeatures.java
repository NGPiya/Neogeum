package ch.piyamon.neogeum.worldgen;

import ch.piyamon.neogeum.Neogeum;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> NEOGEUM_ORE_PLACED_KEY = registerKey("neogeum_ore_placed");
    public static final ResourceKey<PlacedFeature> ROSE_QUARTZ_ORE_PLACED_KEY = registerKey("rose_quartz_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NEOGEUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NEOGEUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(100))));
        register(context, ROSE_QUARTZ_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ROSE_QUARTZ_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(-30))));

    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Neogeum.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
