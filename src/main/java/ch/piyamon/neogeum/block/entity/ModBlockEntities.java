package ch.piyamon.neogeum.block.entity;

import ch.piyamon.neogeum.Neogeum;
import ch.piyamon.neogeum.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Neogeum.MOD_ID);

    public static final RegistryObject<BlockEntityType<MilkProcessorBlockEntity>> MILK_PROCESSOR =
            BLOCK_ENTITIES.register("milk_processor_block_entity", () ->
                    BlockEntityType.Builder.of(MilkProcessorBlockEntity::new,
                            ModBlocks.MILK_PROCESSOR.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}