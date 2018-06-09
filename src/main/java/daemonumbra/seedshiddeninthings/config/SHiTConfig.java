package daemonumbra.seedshiddeninthings.config;

import daemonumbra.seedshiddeninthings.SeedsHiddenInThings;
import daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

import static net.minecraftforge.common.config.Config.*;

/**
 * Config Class for SHiT
 */
@Config(modid = Constants.MOD_ID, type = Type.INSTANCE, name = "SHiT Settings")
public class SHiTConfig {

    @RangeInt(min = 0, max = 100)
    @Comment("The frequency (as a percent) that a thrown Seedy Poo will drop a seed.")
    @LangKey("daemonumbra.seedshiddeninthings.config.seedrng")
    public static int seedWeight = 10;
    @Comment("The seeds that can drop from a Seedy Poo. Accepts item IDs and oreDict values")
    @LangKey("daemonumbra.seedshiddeninthings.config.seeds")
    public static String[] hiddenSeeds = {
            "minecraft:wheat_seeds",
            "minecraft:pumpkin_seeds",
            "minecraft:melon_seeds",
            "minecraft:beetroot_seeds"
    };

    /**
     * Internal seed list
     */
    private static List<Item> seedItems = new ArrayList<>();

    /**
     * Accessor for internal seed list
     *
     * @return Seed list
     */
    public static List<Item> getSeedItems() {
        return seedItems;
    }

    /**
     * Reloads the seed ID's from config and parses them into items
     */
    public static void loadSeeds() {
        ConfigManager.sync(Constants.MOD_ID, Type.INSTANCE);
        SeedsHiddenInThings.logger.info("Reading seed list from config");
        seedItems.clear();
        for (String seed : SHiTConfig.hiddenSeeds) {
            if (seed.contains(":")) {
                Item seedItem = Item.getByNameOrId(seed);
                if (seedItem != null) {
                    seedItems.add(seedItem);
                }
            } else {
                NonNullList<ItemStack> seedStacks = OreDictionary.getOres(seed);
                if (!seedStacks.isEmpty()) {
                    for (ItemStack seedStack : seedStacks) {
                        seedItems.add(seedStack.getItem());
                    }
                }
            }
        }
        SeedsHiddenInThings.logger.info("Seeds found:");
        for (Item item : seedItems) {
            SeedsHiddenInThings.logger.info(item.getRegistryName());
        }
    }
}
