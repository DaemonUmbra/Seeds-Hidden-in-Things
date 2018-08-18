package net.daemonumbra.seedshiddeninthings;

import net.daemonumbra.seedshiddeninthings.config.SHiTConfig;
import net.daemonumbra.seedshiddeninthings.init.SHiTCapabilities;
import net.daemonumbra.seedshiddeninthings.init.SHiTCommands;
import net.daemonumbra.seedshiddeninthings.init.SHiTTab;
import net.daemonumbra.seedshiddeninthings.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.daemonumbra.seedshiddeninthings.util.Constants.*;


/**
 * Main Class for SHiT Mod
 */
@Mod(
        modid = MOD_ID,
        name = MOD_NAME,
        version = VERSION,
        updateJSON = UPDATE_URL,
        certificateFingerprint = FINGERPRINT,
        acceptedMinecraftVersions = MC_VERSION

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
        SHiTCapabilities.RegisterCapabilities();
        SHiTConfig.loadSeeds();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @EventHandler
    public void fingerprintViolation(FMLFingerprintViolationEvent event) throws Exception {
        if(!event.isDirectory()){
            throw new Exception("Detected a modified Seeds Hidden in Things jar, please get a clean jar and try again");
        }
    }
}
