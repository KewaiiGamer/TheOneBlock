package info.kewaiigamer.theoneblock.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by ΑΛΕΧ on 8/4/2017.
 */
public class TheOneTileEntity2 extends TileEntity{

    public String id = "";

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setString("id", id);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        id = compound.getString("id");
    }


}
