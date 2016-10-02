package crystekteam.crystek.client.gui;

import crystekteam.crystek.container.ContainerBase;
import crystekteam.crystek.lib.ModInfo;
import crystekteam.crystek.tiles.prefab.TileBase;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import reborncore.client.guibuilder.GuiBuilder;

/**
 * Created by Gigabit101 on 01/06/2016.
 */
public class GuiBase extends GuiContainer
{
    public static final ResourceLocation overlays = new ResourceLocation(ModInfo.MOD_NAME.toLowerCase() + ":" + "textures/gui/builder.png");

    public String name;
    public TileBase tile;
    public ContainerBase container;
    public GuiBuilder builder = new GuiBuilder(overlays);

    public GuiBase(EntityPlayer player, TileBase tile, ContainerBase container, String name)
    {
        super(container);
        this.container = container;
        this.name = name;
        this.tile = tile;
        this.xSize = 176;
        this.ySize = 167;
    }

    @Override
    public void initGui()
    {
        super.initGui();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int mouseX, int mouseY)
    {
        builder.drawDefaultBackground(this, guiLeft, guiTop, xSize, ySize);
        builder.drawPlayerSlots(this, guiLeft + xSize / 2, guiTop + 80, true);
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        builder.drawEnergyBar(this, 5, 5, 70, (int) container.power, (int) tile.getMaxCapacity(), mouseX - guiLeft, mouseY - guiTop, "Tesla");
    }


    public void drawTankOverlay(TileBase tile, int x, int y)
    {
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.mc.getTextureManager().bindTexture(overlays);
        this.drawTexturedModalRect(k + x, l + y, 26, 150, 16, 66);
    }
}
