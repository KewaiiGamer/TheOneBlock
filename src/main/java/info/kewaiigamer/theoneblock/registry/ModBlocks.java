package info.kewaiigamer.theoneblock.registry;

import info.kewaiigamer.theoneblock.block.TheOneBlock;
import info.kewaiigamer.theoneblock.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by KewaiiGamer on 06/04/2017.
 */
public class ModBlocks {

    public static Block theoneblock;
    public static String name = "theoneblock_default";
    public static Material material = Material.ROCK;

    public static void registerModels() {
        Utils.registerTOBRender(theoneblock, name);
    }

    public static void init()
    {
        theoneblock = new TheOneBlock(name, material);
    }


}
