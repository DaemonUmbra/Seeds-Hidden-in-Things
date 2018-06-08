package daemonumbra.seedshiddeninthings.config;

import daemonumbra.seedshiddeninthings.util.Constants;

import static net.minecraftforge.common.config.Config.*;

@net.minecraftforge.common.config.Config(modid = Constants.MOD_ID,type = Type.INSTANCE,name = "SHiT Settings")
public class Config {
    @RangeInt(min = 0,max = 100)
    @Comment("The frequency (as a percent) that a thrown Seedy Poo will drop a seed.")
    @LangKey("daemonumbra.seedshiddeninthings.config.seedrng")
    public static int seedWeight = 3;

    @Comment("The seeds that can drop from a Seedy Poo. Accepts item IDs and oreDict values")
    @LangKey("daemonumbra.seedshiddeninthings.config.seeds")
    public static String[] hiddenSeeds = {
            "minecraft:wheat_seeds",
            "minecraft:pumpkin_seeds",
            "minecraft:melon_seeds",
            "minecraft:beetroot_seeds"
    };
}
