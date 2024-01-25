package ch.piyamon.neogeum.entity.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class MegablazeEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(MegablazeEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Byte> ID = SynchedEntityData.defineId(MegablazeEntity.class, EntityDataSerializers.BYTE);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    private float allowedHeightOffset = 0.5F;
    private int nextHeightOffsetChangeTick;

    private final ServerBossEvent bossEvent =

            new ServerBossEvent(Component.literal("Megablaze"), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.NOTCHED_12);


    public MegablazeEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0F);
        this.xpReward = 300;
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(4, new MegablazeEntity.MegablazeAttackGoal(this));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes().add(Attributes.MAX_HEALTH, 1000D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 48D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 4f)
                .add(Attributes.ATTACK_DAMAGE, 8f);
    }

    @Nullable

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 20; // Length in ticks of your animation
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    protected void updateWalkAnimation(float v) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.walkAnimation.update(f, 0.2F);
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID, (byte)0);
        this.entityData.define(ATTACKING, false);
    }

    @Override
    public void startSeenByPlayer(ServerPlayer pServerPlayer) {
        super.startSeenByPlayer(pServerPlayer);
        this.bossEvent.addPlayer(pServerPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer pServerPlayer) {
        super.stopSeenByPlayer(pServerPlayer);
        this.bossEvent.removePlayer(pServerPlayer);
    }

    @Override
    public void aiStep() {
        if (!this.onGround() && this.getDeltaMovement().y < 0.0D) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }

        if (this.level().isClientSide) {
            this.setupAnimationStates();



            if (this.random.nextInt(24) == 0 && !this.isSilent()) {
                this.level().playLocalSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, SoundEvents.BLAZE_BURN, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
            }

            for(int i = 0; i < 2; ++i) {
                this.level().addParticle(ParticleTypes.LARGE_SMOKE, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
            }
        }

        super.aiStep();

        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    public boolean isSensitiveToWater() {
        return true;
    }

    protected void customServerAiStep() {
        --this.nextHeightOffsetChangeTick;
        if (this.nextHeightOffsetChangeTick <= 0) {
            this.nextHeightOffsetChangeTick = 100;
            this.allowedHeightOffset = (float)this.random.triangle(0.5D, 6.891D);
        }

        LivingEntity livingentity = this.getTarget();
        if (livingentity != null && livingentity.getEyeY() > this.getEyeY() + (double)this.allowedHeightOffset && this.canAttack(livingentity)) {
            Vec3 vec3 = this.getDeltaMovement();
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, ((double)0.3F - vec3.y) * (double)0.3F, 0.0D));
            this.hasImpulse = true;
        }

        super.customServerAiStep();
    }

    /**
     * Returns {@code true} if the entity is on fire. Used by render to add the fire effect on rendering.
     */

    private boolean isCharged() {
        return (this.entityData.get(ID) & 1) != 0;
    }

    void setCharged(boolean pCharged) {
        byte b0 = this.entityData.get(ID);
        if (pCharged) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(ID, b0);
    }

    static class MegablazeAttackGoal extends Goal {
        private final MegablazeEntity megablaze;
        private int attackStep;
        private int attackTime;
        private int lastSeen;

        public MegablazeAttackGoal(MegablazeEntity pBlaze) {
            this.megablaze = pBlaze;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            LivingEntity livingentity = this.megablaze.getTarget();
            return livingentity != null && livingentity.isAlive() && this.megablaze.canAttack(livingentity);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            this.attackStep = 0;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void stop() {
            this.megablaze.setCharged(false);
            this.lastSeen = 0;
            megablaze.setAttacking(false);
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            --this.attackTime;
            LivingEntity livingentity = this.megablaze.getTarget();
            if (livingentity != null) {
                boolean flag = this.megablaze.getSensing().hasLineOfSight(livingentity);
                if (flag) {
                    this.lastSeen = 0;
                } else {
                    ++this.lastSeen;
                }

                double d0 = this.megablaze.distanceToSqr(livingentity);
                if (d0 < 4.0D) {
                    if (!flag) {
                        return;
                    }

                    if (this.attackTime <= 0) {
                        this.attackTime = 20;
                        this.megablaze.doHurtTarget(livingentity);
                    }

                    this.megablaze.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                } else if (d0 < this.getFollowDistance() * this.getFollowDistance() && flag) {
                    double d1 = livingentity.getX() - this.megablaze.getX();
                    double d2 = livingentity.getY(0.5D) - this.megablaze.getY(0.5D);
                    double d3 = livingentity.getZ() - this.megablaze.getZ();
                    if (this.attackTime <= 0) {
                        ++this.attackStep;
                        if (this.attackStep == 1) {
                            this.attackTime = 60;
                            this.megablaze.setCharged(true);
                        } else if (this.attackStep <= 4) {
                            this.attackTime = 6;
                        } else {
                            this.attackTime = 100;
                            this.attackStep = 0;
                            this.megablaze.setCharged(false);
                        }

                        if (this.attackStep > 1) {
                            double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5D;
                            if (!this.megablaze.isSilent()) {
                                this.megablaze.level().levelEvent((Player)null, 1018, this.megablaze.blockPosition(), 0);
                            }

                            for(int i = 0; i < 3; ++i) {
                                megablaze.setAttacking(true);
                                SmallFireball fireball = new SmallFireball(this.megablaze.level(), this.megablaze, this.megablaze.getRandom().triangle(d1, 2.297D * d4), d2, this.megablaze.getRandom().triangle(d3, 2.297D * d4));
                                fireball.setPos(fireball.getX(), this.megablaze.getY(0.5D) + 0.5D, fireball.getZ());
                                this.megablaze.level().addFreshEntity(fireball);
                            }
                        }
                    }

                    this.megablaze.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
                } else if (this.lastSeen < 5) {
                    this.megablaze.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                }

                super.tick();
            }
        }

        private double getFollowDistance() {
            return this.megablaze.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
    }
}