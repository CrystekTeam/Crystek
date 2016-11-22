package crystekteam.crystek.eventhandlers;

import crystekteam.crystek.api.CrystekApi;
import crystekteam.crystek.api.recipe.RecipeGrinder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldEventListener;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * @author Prospector on 27/06/16
 */
public class CrystekWorldEventListener implements IWorldEventListener {
    private World worldObj;

    public CrystekWorldEventListener(World worldObj) {
        this.worldObj = worldObj;
    }

    @Override
    public void notifyBlockUpdate(World worldIn, BlockPos pos, IBlockState oldState, IBlockState newState,
                                  int flags) {

    }

    @Override
    public void notifyLightSet(BlockPos pos) {

    }

    @Override
    public void markBlockRangeForRenderUpdate(int x1, int y1, int z1, int x2, int y2, int z2) {

    }

    @Override
    public void playSoundToAllNearExcept(@Nullable EntityPlayer player, SoundEvent soundIn,
                                         SoundCategory category, double x, double y, double z, float volume, float pitch) {

    }

    @Override
    public void playRecord(SoundEvent soundIn, BlockPos pos) {

    }

    @Override
    public void spawnParticle(int particleID, boolean ignoreRange, double xCoord, double yCoord,
                              double zCoord, double xSpeed, double ySpeed, double zSpeed, int... parameters) {

    }

    @Override
    public void onEntityAdded(Entity entityIn) {

    }

    @Override
    public void onEntityRemoved(Entity entityIn) {

    }

    @Override
    public void broadcastSound(int soundID, BlockPos pos, int data) {

    }

    @Override
    public void playEvent(EntityPlayer player, int type, BlockPos blockPosIn, int data) {
        if (!worldObj.isRemote) {
            if (type == 1031) {
                BlockPos belowPos = new BlockPos(blockPosIn.getX(), blockPosIn.getY() - 1, blockPosIn.getZ());
                if (worldObj.getBlockState(belowPos) != null) {
                    IBlockState state = worldObj.getBlockState(belowPos);
                    ItemStack input = new ItemStack(state.getBlock());
                    if (isValidRecipe(input)) {
                        if (getOutputItem(input) != null) {
                            worldObj.setBlockToAir(belowPos);
                            worldObj.spawnEntity(
                                    new EntityItem(worldObj, blockPosIn.getX(), blockPosIn.getY(), blockPosIn.getZ(),
                                            getOutputItem(input)));
                        }
                    }
                }
            }
        }
    }

    public boolean isValidRecipe(ItemStack input) {
        for (RecipeGrinder recipe : CrystekApi.grinderRecipes) {
            if (recipe.matches(input)) {
                return true;
            }
        }
        return false;
    }

    public ItemStack getOutputItem(ItemStack input) {
        for (RecipeGrinder recipe : CrystekApi.grinderRecipes) {
            if (recipe.matches(input)) {
                ItemStack output = recipe.getOutput().copy();
                return output;
            }
        }
        return null;
    }

    @Override
    public void sendBlockBreakProgress(int breakerId, BlockPos pos, int progress) {

    }

    @Override
    public void spawnParticle(int p_190570_1_, boolean p_190570_2_, boolean p_190570_3_, double p_190570_4_, double p_190570_6_, double p_190570_8_, double p_190570_10_, double p_190570_12_, double p_190570_14_, int... p_190570_16_) {

    }
}
