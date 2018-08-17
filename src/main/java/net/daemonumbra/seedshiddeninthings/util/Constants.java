package net.daemonumbra.seedshiddeninthings.util;

import java.util.Random;

/**
 * Stores global constants for SHiT
 */
public class Constants {
    //@Mod Constants
    public static final String MOD_ID = "seedshiddeninthings";
    public static final String MOD_NAME = "Seeds Hidden in Things";
    public static final String VERSION = "0.1.0.0";
    public static final String UPDATE_URL = "https://raw.githubusercontent.com/DaemonUmbra/Version/master/SHiT.json";

    //@SidedProxy Constants
    public static final String SERVER_PROXY = "net.daemonumbra.seedshiddeninthings.proxy.ServerProxy";
    public static final String CLIENT_PROXY = "net.daemonumbra.seedshiddeninthings.proxy.ClientProxy";

    //Util Constants
    public static final Random RNG = new Random();
}
