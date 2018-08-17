package net.daemonumbra.seedshiddeninthings.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PooManagerProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IPooManager.class)
    public static final Capability<IPooManager> POO_MANAGER = null;

    private IPooManager instance = PooManager.getDefault();

    /**
     * Determines if this object has support for the capability in question on the specific side.
     * The return value of this MIGHT change during runtime if this object gains or looses support
     * for a capability.
     * <p>
     * Example:
     * A Pipe getting a cover placed on one side causing it loose the Inventory attachment function for that side.
     * <p>
     * This is a light weight version of getCapability, intended for metadata uses.
     *
     * @param capability The capability to check
     * @param facing     The Side to check from:
     *                   CAN BE NULL. Null is defined to represent 'internal' or 'self'
     * @return True if this object supports the capability.
     */
    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == POO_MANAGER;
    }

    /**
     * Retrieves the handler for the capability requested on the specific side.
     * The return value CAN be null if the object does not support the capability.
     * The return value CAN be the same for multiple faces.
     *
     * @param capability The capability to check
     * @param facing     The Side to check from:
     *                   CAN BE NULL. Null is defined to represent 'internal' or 'self'
     * @return The requested capability. Returns null when {@link #hasCapability(Capability, EnumFacing)} would return false.
     */
    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == POO_MANAGER ? POO_MANAGER.cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return POO_MANAGER.getStorage().writeNBT(POO_MANAGER,this.instance,null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        POO_MANAGER.getStorage().readNBT(POO_MANAGER,this.instance,null, nbt);
    }
}
