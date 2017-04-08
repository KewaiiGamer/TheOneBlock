package info.kewaiigamer.theoneblock.block;

import info.kewaiigamer.kewaiilib.custom.CustomBlockContainer;
import info.kewaiigamer.theoneblock.Main;
import info.kewaiigamer.theoneblock.Ref;
import info.kewaiigamer.theoneblock.tileentity.TheOneBlockTE;
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
import net.minecraft.world.World;

/**
 * Created by KewaiiGamer on 06/04/2017.
 */
public class TheOneBlock extends CustomBlockContainer {

    public static String mode = "Default";
    public static String replicate = "Nothing";
    public static ItemStack replicateItemStack;

    public TheOneBlock(String name, Material material) {
        super(Ref.MODID, name, Main.tab, material);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TheOneBlockTE();
    }

    public TheOneBlockTE getTE(World world, BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TheOneBlockTE) {
            return (TheOneBlockTE) tile;
        }
        return null;

    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        final ItemStack itemstack = player.getHeldItem(hand);
        if (mode.equalsIgnoreCase("replicator")) {
            if (!itemstack.isEmpty()) {
                if (!itemstack.isItemEqual(new ItemStack(Item.getItemFromBlock(Blocks.COAL_BLOCK)))) {
                    if (!replicate.equals(itemstack.getDisplayName())) {
                        //final Block block = state.getBlock();
                        final ITextComponent signText = new TextComponentString("Now replicating " + getReplicate(itemstack));
                        player.sendStatusMessage(signText, true);
                    }
                }
            }
            if (itemstack.isItemEqual(new ItemStack(Item.getItemFromBlock(Blocks.COAL_BLOCK)))) {
                if (!world.isRemote) {
                    player.entityDropItem(replicateItemStack, 0);
                }
                itemstack.shrink(1);
            }
            if (player.isSneaking()) {
                if (itemstack.isEmpty()) {
                    final ITextComponent signText = new TextComponentString("Mode Changed " + getMode(itemstack));
                    player.sendStatusMessage(signText, true);
                }
            }

        }
        if (mode.equalsIgnoreCase("default")) {
            if (!itemstack.isEmpty() && itemstack.isItemEqual(new ItemStack(Items.DIAMOND))) {
                final ITextComponent signText = new TextComponentString("Mode changed to " + getMode(itemstack));
                player.sendStatusMessage(signText, true);
            }
        }
        return true;
    }

    public String getReplicate(ItemStack itemStack) {
        if (!itemStack.isEmpty()) {
            replicate = itemStack.getDisplayName();
            ItemStack one = new ItemStack(itemStack.getItem(), 1);
            replicateItemStack = one;
        }
        if (itemStack.isEmpty()) {
            replicate = "Default";
        }
        return replicate;
    }

    public String getMode(ItemStack itemStack) {
        if (itemStack.isItemEqual(new ItemStack(Items.DIAMOND))) {
            mode = "Replicator";
        }
        if (itemStack.isEmpty()) {
            mode = "Default";
        }
        return mode;
    }
}