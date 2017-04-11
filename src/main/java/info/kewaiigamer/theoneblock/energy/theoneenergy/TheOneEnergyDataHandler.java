package info.kewaiigamer.theoneblock.energy.theoneenergy;

import info.kewaiigamer.kewaiilib.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by KewaiiGamer on 11/04/2017.
 */
public class TheOneEnergyDataHandler {
    @CapabilityInject(ITheOneEnergyHandler.class)
    public static final Capability<ITheOneEnergyHandler> CAPABILITY_THE_ONE_ENERGY = null;

    public static void register() {

        CapabilityManager.INSTANCE.register(ITheOneEnergyHandler.class, new Storage(), DefaultTheOneEnergyHandler.class);
        MinecraftForge.EVENT_BUS.register(new TheOneEnergyDataHandler());
    }

    @SubscribeEvent
    public void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {

        if (event.getObject() instanceof EntityPlayer)
            event.addCapability(new ResourceLocation(Ref.MODID, "theoneenergy   "), new Provider());
    }

    @SubscribeEvent
    public void clonePlayer(PlayerEvent.Clone event) {

        final ITheOneEnergyHandler original = getHandler(event.getOriginal());
        final ITheOneEnergyHandler clone = getHandler(event.getEntity());
        clone.setTheOneEnergy(original.getTheOneEnergy());
    }

    public static ITheOneEnergyHandler getHandler(Entity entity) {

        if (entity.hasCapability(CAPABILITY_THE_ONE_ENERGY, EnumFacing.DOWN))
            return entity.getCapability(CAPABILITY_THE_ONE_ENERGY, EnumFacing.DOWN);

        return null;
    }

    public interface ITheOneEnergyHandler {

        int getTheOneEnergy();
        void setTheOneEnergy(int mana);
        void addTheOneEnergy(int mana);
        void removeTheOneEnergy(int mana);
    }

    public static class DefaultTheOneEnergyHandler implements ITheOneEnergyHandler {

        private int theoneenergy;

        @Override
        public int getTheOneEnergy () {

            return this.theoneenergy;
        }

        @Override
        public void setTheOneEnergy (int theoneenergy) {

            this.theoneenergy = theoneenergy;
        }

        @Override
        public void addTheOneEnergy (int theoneenergy) {

            this.theoneenergy += theoneenergy;
        }

        @Override
        public void removeTheOneEnergy (int theoneenergy) {

            this.theoneenergy -= theoneenergy;

            if (this.theoneenergy < 0)
                this.theoneenergy = 0;
        }
    }
    public static class Storage implements Capability.IStorage<ITheOneEnergyHandler> {

        @Override
        public NBTBase writeNBT (Capability<ITheOneEnergyHandler> capability, ITheOneEnergyHandler instance, EnumFacing side) {

            final NBTTagCompound tag = new NBTTagCompound();
            tag.setInteger("theoneenergy", instance.getTheOneEnergy());
            return tag;
        }

        @Override
        public void readNBT (Capability<ITheOneEnergyHandler> capability, ITheOneEnergyHandler instance, EnumFacing side, NBTBase nbt) {

            final NBTTagCompound tag = (NBTTagCompound) nbt;
            instance.setTheOneEnergy(tag.getInteger("theoneenergy"));
        }
    }
    public static class Provider implements ICapabilitySerializable<NBTTagCompound> {

        ITheOneEnergyHandler instance = CAPABILITY_THE_ONE_ENERGY.getDefaultInstance();

        @Override
        public boolean hasCapability(Capability<?> capability, EnumFacing facing) {

            return capability == CAPABILITY_THE_ONE_ENERGY;
        }

        @Override
        public <T> T getCapability(Capability<T> capability, EnumFacing facing) {

            return hasCapability(capability, facing) ? CAPABILITY_THE_ONE_ENERGY.<T>cast(instance) : null;
        }

        @Override
        public NBTTagCompound serializeNBT() {

            return (NBTTagCompound) CAPABILITY_THE_ONE_ENERGY.getStorage().writeNBT(CAPABILITY_THE_ONE_ENERGY, instance, null);
        }

        @Override
        public void deserializeNBT(NBTTagCompound nbt) {

            CAPABILITY_THE_ONE_ENERGY.getStorage().readNBT(CAPABILITY_THE_ONE_ENERGY, instance, null, nbt);
        }
    }
}