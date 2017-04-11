package info.kewaiigamer.theoneblock.compat.guideapi.category;

import amerifrance.guideapi.api.IPage;
import amerifrance.guideapi.api.impl.abstraction.EntryAbstract;
import amerifrance.guideapi.api.util.PageHelper;
import amerifrance.guideapi.api.util.TextHelper;
import info.kewaiigamer.theoneblock.Ref;
import info.kewaiigamer.theoneblock.compat.guideapi.entry.EntryText;
import net.minecraft.util.ResourceLocation;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by KewaiiGamer on 11/04/2017.
 */
public class CategoryTheOneBlock {

    public static Map<ResourceLocation, EntryAbstract> buildCategory() {
        Map<ResourceLocation, EntryAbstract> entries = new LinkedHashMap<ResourceLocation, EntryAbstract>();
        String keyBase = "guide." + Ref.MODID + ".entry.theoneblock.";

        List<IPage> introPages = new ArrayList<IPage>();
        introPages.addAll(PageHelper.pagesForLongText(TextHelper.localize(keyBase + "intro" + ".info"), 370));
        entries.put(new ResourceLocation(keyBase + "intro"), new EntryText(introPages, TextHelper.localize(keyBase + "intro"), true));



        return entries;
    }

}
