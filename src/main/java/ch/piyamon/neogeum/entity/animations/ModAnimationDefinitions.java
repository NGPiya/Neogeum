package ch.piyamon.neogeum.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ModAnimationDefinitions {

    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(3.25f).build();
    public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(1f).build();
    public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.withLength(4.3f)
            .addAnimation("shield",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.1f, KeyframeAnimations.posVec(0f, 6f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3f, KeyframeAnimations.posVec(0f, -4f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 6f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7f, KeyframeAnimations.posVec(0f, -4f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.8f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9f, KeyframeAnimations.posVec(0f, 6f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.1f, KeyframeAnimations.posVec(0f, -4f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.3f, KeyframeAnimations.posVec(0f, 6f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -4f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.7f, KeyframeAnimations.posVec(0f, 6f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.8f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.9f, KeyframeAnimations.posVec(0f, -4f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("shield",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(0f, -1080f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
}
