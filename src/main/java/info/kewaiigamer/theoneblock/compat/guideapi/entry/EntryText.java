package info.kewaiigamer.theoneblock.compat.guideapi.entry;

import amerifrance.guideapi.api.IPage;
import amerifrance.guideapi.entry.EntryResourceLocation;
import net.minecraft.util.ResourceLocation;

import java.util.List;

/**
 * Created by KewaiiGamer on 11/04/2017.
 */
public class EntryText extends EntryResourceLocation {
    public EntryText(List<IPage> pageList, String name, boolean unicode)
    {
        super(pageList, name, new ResourceLocation("theoneguide", "textures/gui/theoneguide.png"), unicode);
    }

    public EntryText(List<IPage> pageList, String name)
    {
        this(pageList, name, false);
    }
}
