package info.kewaiigamer.theoneblock.registry;

import info.kewaiigamer.theoneblock.block.TheOneReplicator;
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
    public static Block theoneblock2;
    public static Block replicator;
    public static String tob_name = "theoneblock";
    public static String tob2_name = "theoneblock2";
    public static String rep_name = "replicator";
    public static Material material = Material.ROCK;

    public static void registerModels() {
        Utils.registerTOBRender(theoneblock, tob_name);
        Utils.registerTOBRender(theoneblock2, tob2_name);
        Utils.registerTOBRender(replicator, rep_name);
    }

    public static void init() {
        theoneblock = new TheOneBlock(tob_name, material);
        theoneblock2 = new TheOneBlock2(tob2_name, material);
        replicator = new TheOneReplicator(rep_name, material);
    }


}
