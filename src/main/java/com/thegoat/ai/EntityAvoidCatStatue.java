package com.thegoat.ai;

import com.thegoat.blocks.CatStatue;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.ai.RandomPositionGenerator;

public class EntityAvoidCatStatue extends EntityAIBase {

    private final EntityCreeper creeper;
    private BlockPos catStatuePos;
    private double nearSpeed;

    public EntityAvoidCatStatue(EntityCreeper entityIn, float avoidDistance, double farSpeed, double nearSpeed) {
        this.creeper = entityIn;
        this.nearSpeed = nearSpeed;
        this.setMutexBits(1);  // Faz com que essa classe tenha privilageio sobre outras se necessario
    }


    @Override
    public boolean shouldExecute() {
        int searchRadius = 10;
        BlockPos creeperPos = new BlockPos(this.creeper);

        for (int x = -searchRadius; x <= searchRadius; x++) {
            for (int y = -searchRadius; y <= searchRadius; y++) {
                for (int z = -searchRadius; z <= searchRadius; z++) {
                    BlockPos checkPos = creeperPos.add(x, y, z);
                    if (this.creeper.world.getBlockState(checkPos).getBlock() instanceof CatStatue) {
                        this.catStatuePos = checkPos;
                        System.out.println("Creeper near CatStatue");
                        return true;
                    }
                }
            }
        }

        return false;
    }


    @Override
    public boolean shouldContinueExecuting() {
        return this.catStatuePos != null && this.creeper.getDistanceSqToCenter(this.catStatuePos) < 100.0D;
    }


    @Override
    public void startExecuting() {
        this.moveAwayFromStatue();
    }


    @Override
    public void updateTask() {

        if (this.creeper.getDistanceSqToCenter(this.catStatuePos) < 100.0D) {
            this.moveAwayFromStatue();
        } else {
            this.resetTask();
        }
    }


    @Override
    public void resetTask() {
        this.catStatuePos = null;
    }


    private void moveAwayFromStatue() {
        if (this.catStatuePos != null) {
            Vec3d avoidDirection = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.creeper, 16, 7, new Vec3d(this.catStatuePos));
            if (avoidDirection != null) {
                if(this.creeper.getNavigator().getPathToPos(new BlockPos(avoidDirection)) != null) {
                    this.creeper.getNavigator().tryMoveToXYZ(avoidDirection.x, avoidDirection.y, avoidDirection.z, this.nearSpeed);
                    System.out.println("Creeper is avoiding the CatStatue!");
                }
            }
        }
    }
}
