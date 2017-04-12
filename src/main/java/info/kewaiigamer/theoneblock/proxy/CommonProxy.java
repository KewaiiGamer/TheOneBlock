package info.kewaiigamer.theoneblock.proxy;

import info.kewaiigamer.theoneblock.energy.theoneenergy.TheOneEnergyDataHandler;
import info.kewaiigamer.theoneblock.registry.ModBlocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by KewaiiGamer on 06/04/2017.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        ModBlocks.init();
    }

    public void init(FMLInitializationEvent e) {
        TheOneEnergyDataHandler.register();
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
