package daemonumbra.seedshiddeninthings.init;

import daemonumbra.seedshiddeninthings.commands.ReloadCommand;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

/**
 * Manages Commands for SHiT
 */
public class SHiTCommands {
    public static void registerCommands(FMLServerStartingEvent event) {
        event.registerServerCommand(new ReloadCommand());
    }
}
