package crystekteam.crystekold.compat.waila;

import crystekteam.crystekold.tiles.prefab.TileBase;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gigabit101 on 11/05/2016.
 */
public class WailaProviderAE implements IWailaDataProvider
{
    private List<String> info = new ArrayList<String>();

    @Override
    public List<String> getWailaBody(ItemStack item, List<String> tip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        TileBase tile = (TileBase) accessor.getTileEntity();

        tile.addWailaInfo(info);

        tip.addAll(info);
        info.clear();

        return tip;
    }

    @Override
    public List<String> getWailaHead(ItemStack item, List<String> tip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return tip;
    }

    @Override
    public List<String> getWailaTail(ItemStack item, List<String> tip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return tip;
    }

    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return null;
    }

    @Override
    public NBTTagCompound getNBTData(EntityPlayerMP arg0, TileEntity arg1, NBTTagCompound tag, World arg3, BlockPos arg4)
    {
        return tag;
    }
}
