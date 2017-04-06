package info.kewaiigamer.theoneblock.utils;

import info.kewaiigamer.kewaiilib.utils.BlockUtils;
import info.kewaiigamer.theoneblock.Ref;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * Created by KewaiiGamer on 06/04/2017.
 */
public class Utils {

    public static void registerTOBRender(Block block, String name) {
        BlockUtils.registerBlockRender(Ref.MODID, block, name);
    }
}
