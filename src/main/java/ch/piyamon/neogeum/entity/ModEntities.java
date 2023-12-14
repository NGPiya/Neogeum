package ch.piyamon.neogeum.entity;

import ch.piyamon.neogeum.Neogeum;
import ch.piyamon.neogeum.entity.custom.MegablazeEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Neogeum.MOD_ID);

    public static final RegistryObject<EntityType<MegablazeEntity>> MEGABLAZE =
            ENTITY_TYPES.register("megablaze", () -> EntityType.Builder.of(MegablazeEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("megablaze"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}