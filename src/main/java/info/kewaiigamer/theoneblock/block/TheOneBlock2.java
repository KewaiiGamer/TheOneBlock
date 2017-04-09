package info.kewaiigamer.theoneblock.block;

import info.kewaiigamer.kewaiilib.custom.CustomBlock;
import info.kewaiigamer.theoneblock.Main;
import info.kewaiigamer.theoneblock.Ref;
import info.kewaiigamer.theoneblock.registry.ModBlocks;
import info.kewaiigamer.theoneblock.tileentity.TheOneTileEntity2;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;

/**
 * Created by ΑΛΕΧ on 8/4/2017.
 */
public class TheOneBlock2 extends CustomBlock implements ITileEntityProvider{


    public TheOneBlock2(String name, Material material) {
        super(Ref.MODID, name, Main.tab, material);
        GameRegistry.registerTileEntity(TheOneTileEntity2.class, Ref.MODID + "");
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TheOneTileEntity2();
    }

    public TheOneTileEntity2 getTE(World world, BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TheOneTileEntity2) {
            return (TheOneTileEntity2) tile;
        }
        return null;
    }

    public Item acceptables[] = {Items.DIAMOND, Item.getItemFromBlock(Blocks.REDSTONE_BLOCK), Item.getItemFromBlock(Blocks.FURNACE), Item.getItemFromBlock(Blocks.CRAFTING_TABLE)};

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        final ItemStack held = playerIn.getHeldItem(hand);
        if(!held.isEmpty()){
            if(changeState(held.getItem(), worldIn, pos)){
                if(!playerIn.isCreative()){
                    held.shrink(1);
                }
            }else{
                final ITextComponent signText = new TextComponentString(TextFormatting.RED + "Can't activate with " + held.getDisplayName());
                playerIn.sendStatusMessage(signText, false);
            }
        }
        return true;
    }

    public boolean changeState(Item heldItem, World world, BlockPos pos){
        int index = 0;
            for(int x = 0; x < acceptables.length; x++){
                index = x + 1;
                if(heldItem == acceptables[x]){
                    TheOneTileEntity2.id += index;
                    transform(TheOneTileEntity2.id, world, pos);
                    return true;
                }

            }
        return false;
    }

        public void transform(String identity, World world, BlockPos pos){
        if(identity == "3"){
            world.setBlockState(pos, ModBlocks.replicator.getDefaultState(), 2);
        }
    }


}
