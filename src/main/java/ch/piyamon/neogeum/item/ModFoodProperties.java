package ch.piyamon.neogeum.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties NEOGEUMPOTATO = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(3).saturationMod(0.25f).build();

    public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(4).saturationMod(0.5f).build();

    public static final FoodProperties PIZZA = new FoodProperties.Builder().nutrition(7).saturationMod(1f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 1), 0.2F)
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 540, 2), 1.0F)
            .alwaysEat().build();

}