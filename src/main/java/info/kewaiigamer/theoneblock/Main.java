package info.kewaiigamer.theoneblock;

import info.kewaiigamer.theoneblock.creativetab.TheOneTab;
import info.kewaiigamer.theoneblock.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static info.kewaiigamer.theoneblock.Ref.*;

/**
 * Created by KewaiiGamer on 06/04/2017.
 */


@net.minecraftforge.fml.common.Mod(modid=MODID, version= VERSION_MAJOR + VERSION_MINOR + VERSION_PATCH, name=MODNAME, acceptedMinecraftVersions=ACCEPTED_MC_VERSIONS,
        dependencies = "required-after:" + KewaiiLib_MODID + ModVersion + KewaiiLib_VERSION_MAJOR + KewaiiLib_VERSION_MINOR + KewaiiLib_VERSION_PATCH + KewaiiLib_VERSION_BUILD + NewerVersions)

public class Main {

    @Instance(MODID)
    public static Main instance = new Main();
    @SidedProxy(clientSide=CLIENT_PROXY_CLASS, serverSide=SERVER_PROXY_CLASS)
    public static CommonProxy proxy = new CommonProxy();

    public static CreativeTabs tab = new TheOneTab();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
