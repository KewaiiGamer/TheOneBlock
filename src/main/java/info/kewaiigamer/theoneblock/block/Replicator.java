package info.kewaiigamer.theoneblock.block;

import info.kewaiigamer.kewaiilib.custom.CustomBlock;
import info.kewaiigamer.theoneblock.Main;
import info.kewaiigamer.theoneblock.Ref;
import net.minecraft.block.material.Material;
;

/**
 * Created by ΑΛΕΧ on 8/4/2017.
 */
public class Replicator extends CustomBlock{

    public Replicator(String name, Material material){
        super(Ref.MODID, name, Main.tab, material);
    }
}
