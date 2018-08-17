package net.daemonumbra.seedshiddeninthings.init;

import net.daemonumbra.seedshiddeninthings.capabilities.IPooManager;
import net.daemonumbra.seedshiddeninthings.capabilities.PooManager;
import net.daemonumbra.seedshiddeninthings.capabilities.PooManagerStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class SHiTCapabilities {
    public static void RegisterCapabilities(){
        CapabilityManager.INSTANCE.register(IPooManager.class, new PooManagerStorage(), PooManager::getDefault);
    }
}
