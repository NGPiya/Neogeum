package ch.piyamon.neogeum.item;

import ch.piyamon.neogeum.Neogeum;
import ch.piyamon.neogeum.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier NEOGEUM = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1400, 11.0F, 3f, 26,
                    ModTags.Blocks.NEEDS_NEOGEUM_TOOL, () -> Ingredient.of(ModItems.NEOGEUM.get())),
            new ResourceLocation(Neogeum.MOD_ID, "neogeum"), List.of(Tiers.NETHERITE), List.of());

}