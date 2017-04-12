package info.kewaiigamer.theoneblock.block;

import info.kewaiigamer.kewaiilib.custom.CustomBlock;
import info.kewaiigamer.theoneblock.Main;
import info.kewaiigamer.theoneblock.Ref;
import info.kewaiigamer.theoneblock.energy.theoneenergy.TheOneEnergyDataHandler;
import info.kewaiigamer.theoneblock.tileentity.TheOneReplicatorTE;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
;import javax.annotation.Nullable;

/**
 * Created by ΑΛΕΧ on 8/4/2017.
 */
public class TheOneReplicator extends CustomBlock implements ITileEntityProvider {

    public Item acceptables[] = {Items.DIAMOND, Item.getItemFromBlock(Blocks.REDSTONE_BLOCK), Item.getItemFromBlock(Blocks.FURNACE), Item.getItemFromBlock(Blocks.CRAFTING_TABLE)};

    public TheOneReplicator(String name, Material material){
        super(Ref.MODID, name, Main.tab, material);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TheOneReplicatorTE();
    }
}
