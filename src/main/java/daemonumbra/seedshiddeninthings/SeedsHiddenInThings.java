package daemonumbra.seedshiddeninthings;

import daemonumbra.seedshiddeninthings.config.SHiTConfig;
import daemonumbra.seedshiddeninthings.init.SHiTCommands;
import daemonumbra.seedshiddeninthings.init.SHiTTab;
import daemonumbra.seedshiddeninthings.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static daemonumbra.seedshiddeninthings.util.Constants.*;


/**
 * Main Class for SHiT Mod
 */
@Mod(
        modid = MOD_ID,
        name = MOD_NAME,
        version = VERSION,
        updateJSON = UPDATE_URL
)
public class SeedsHiddenInThings {

    public static final SHiTTab CREATIVE_TAB = new SHiTTab();
    @Instance(MOD_ID)
    public static SeedsHiddenInThings INSTANCE;
    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static IProxy PROXY;
    public static Logger logger = LogManager.getLogger(MOD_ID);

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        SHiTCommands.registerCommands(event);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        SeedsHiddenInThings.PROXY.registerEntityRenders();
        SHiTConfig.loadSeeds();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
