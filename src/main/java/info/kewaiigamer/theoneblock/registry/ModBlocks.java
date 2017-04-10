package info.kewaiigamer.theoneblock.registry;

import info.kewaiigamer.theoneblock.block.Replicator;
import info.kewaiigamer.theoneblock.block.TheOneBlock;
import info.kewaiigamer.theoneblock.block.TheOneBlock2;
import info.kewaiigamer.theoneblock.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by KewaiiGamer on 06/04/2017.
 */
public class ModBlocks {

    public static Block theoneblock;
    public static TheOneBlock2 theoneblock2;
    public static Replicator replicator;
    public static String name = "theoneblock_default";
    public static String name2 = "theoneblock2_default";
    public static String name3 = "replicator_default";
    public static Material material = Material.ROCK;
    public static Material material2 = Material.GLASS;

    public static void registerModels() {
        Utils.registerTOBRender(theoneblock, name);
        Utils.registerTOBRender(theoneblock2, name2);
        Utils.registerTOBRender(replicator, name3);
    }

    public static void init()
    {
        theoneblock = new TheOneBlock(name, material);
        theoneblock2 = new TheOneBlock2(name2, material2);
        replicator = new Replicator(name3, material);
    }


}
