package crystekteam.crystek.client.gui;

import crystekteam.crystek.container.ContainerCrate;
import crystekteam.crystek.container.ContainerTinkerTable;
import crystekteam.crystek.lib.ModInfo;
import crystekteam.crystek.tiles.TileCrate;
import crystekteam.crystek.tiles.TileTinkerTable;
import crystekteam.crystek.tiles.prefab.TileBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Gigabit101 on 24/07/2016.
 */
public class GuiCrate extends GuiBase
{
//    private static final ResourceLocation textureloc = new ResourceLocation(ModInfo.MOD_NAME.toLowerCase() + ":" +"textures/gui/crate.png");

    public TileCrate table;
    public GuiCrate(EntityPlayer player, TileBase tile)
    {
        super(player, tile, new ContainerCrate(tile, player), "crate");//, textureloc);
        this.table = (TileCrate) tile;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {}

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        super.drawGuiContainerBackgroundLayer(p_146976_1_, p_146976_2_, p_146976_3_);
    }
}
