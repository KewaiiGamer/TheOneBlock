package info.kewaiigamer.theoneblock.compat.guideapi;

import amerifrance.guideapi.api.GuideAPI;
import amerifrance.guideapi.api.GuideBook;
import amerifrance.guideapi.api.IGuideBook;
import amerifrance.guideapi.api.IPage;
import amerifrance.guideapi.api.impl.Book;
import amerifrance.guideapi.api.impl.abstraction.CategoryAbstract;
import amerifrance.guideapi.api.impl.abstraction.EntryAbstract;
import amerifrance.guideapi.category.CategoryItemStack;
import amerifrance.guideapi.entry.EntryItemStack;
import amerifrance.guideapi.page.PageFurnaceRecipe;
import amerifrance.guideapi.page.PageIRecipe;
import amerifrance.guideapi.page.PageText;
import info.kewaiigamer.theoneblock.compat.guideapi.category.CategoryTheOneBlock;
import info.kewaiigamer.theoneblock.registry.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapedOreRecipe;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by KewaiiGamer on 11/04/2017.
 */
@GuideBook
public class TheOneGuide implements IGuideBook {

    public static Book TheOneGuide;
    @Nullable
    @Override
    public Book buildBook() {
        // Create the map of entries. A LinkedHashMap is used to retain the order of entries.
        //Map<ResourceLocation, EntryAbstract> entries = new LinkedHashMap<ResourceLocation, EntryAbstract>();

        // Creation of our first entry.
        /*List<IPage> pages1 = new ArrayList<IPage>();
        pages1.add(new PageText("This is a page in my guide!"));
        entries.put(new ResourceLocation("example", "entry_one"), new EntryItemStack(pages1, "Entry One", new ItemStack(Blocks.BEACON)));
*/
        // Creation of our second entry.

        /*   List<IPage> pages2 = new ArrayList<IPage>();
        pages2.add(new PageIRecipe(new ShapedOreRecipe(Items.DIAMOND_SWORD, "D", "D", "S", 'D', Items.DIAMOND, 'S', Items.STICK)));
        pages2.add(new PageFurnaceRecipe("oreGold"));
        entries.put(new ResourceLocation("example", "entry_two"), new EntryItemStack(pages2, "Entry Two", new ItemStack(Items.DIAMOND_SWORD)));
*/
        // Setup the list of categories and add our entries to it.
  /*      List<CategoryAbstract> categories = new ArrayList<CategoryAbstract>();
        categories.add(new CategoryItemStack(entries, "", new ItemStack(Blocks.COMMAND_BLOCK)));
*/
        TheOneGuide = new Book();
        TheOneGuide.setTitle("The One Guide");
        TheOneGuide.setDisplayName("The One Guide");
        TheOneGuide.setAuthor("The One Mod");
        TheOneGuide.setColor(Color.CYAN);
        TheOneGuide.setRegistryName(new ResourceLocation("tob", "theoneguide"));
        return TheOneGuide;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void handleModel(ItemStack bookStack) {
        // Use the default GuideAPI model
        GuideAPI.setModel(TheOneGuide);
    }

    @Override
    public void handlePost(ItemStack bookStack) {
        // Register a recipe so player's can obtain the book
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            TheOneGuide.addCategory(new CategoryItemStack(CategoryTheOneBlock.buildCategory(), "guide.tob.category.theoneblock", new ItemStack(ModBlocks.theoneblock2)));
        }
        GameRegistry.addShapelessRecipe(bookStack, Items.BOOK, Items.PAPER);
    }
}
