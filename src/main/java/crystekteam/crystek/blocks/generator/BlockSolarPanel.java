package crystekteam.crystek.blocks.generator;

import crystekteam.crystek.Crystek;
import crystekteam.crystek.GuiHandler;
import crystekteam.crystek.blocks.BlockBase;
import crystekteam.crystek.lib.ModInfo;
import crystekteam.crystek.tiles.generator.TileSolarPanel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Gigabit101 on 25/06/2016.
 */
public class BlockSolarPanel extends BlockBase {
    public BlockSolarPanel() {
        setUnlocalizedName(ModInfo.MOD_ID.toLowerCase() + ".solarpanel");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileSolarPanel();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!playerIn.isSneaking())
            playerIn.openGui(Crystek.instance, GuiHandler.solarPanel, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
