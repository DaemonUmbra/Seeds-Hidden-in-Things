package net.daemonumbra.seedshiddeninthings.init;

import net.daemonumbra.seedshiddeninthings.commands.SHiTDebug;
import net.daemonumbra.seedshiddeninthings.commands.SHiTReload;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

/**
 * Manages Commands for SHiT
 */
public class SHiTCommands {
    public static void registerCommands(FMLServerStartingEvent event) {
        event.registerServerCommand(new SHiTReload());
        event.registerServerCommand(new SHiTDebug());
    }
}
