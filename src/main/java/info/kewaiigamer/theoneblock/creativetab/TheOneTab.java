package info.kewaiigamer.theoneblock.creativetab;

import info.kewaiigamer.theoneblock.registry.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * Created by KewaiiGamer on 06/04/2017.
 */
public class TheOneTab extends CreativeTabs {

    public TheOneTab() {
        super("The One Block");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.theoneblock);
    }
}
