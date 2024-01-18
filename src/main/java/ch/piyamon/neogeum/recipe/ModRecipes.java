package ch.piyamon.neogeum.recipe;

import ch.piyamon.neogeum.Neogeum;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Neogeum.MOD_ID);

    public static final RegistryObject<RecipeSerializer<MilkProcessingRecipe>> MILK_PROCESSING_SERIALIZER =
            SERIALIZERS.register("milk_processing", () -> MilkProcessingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}