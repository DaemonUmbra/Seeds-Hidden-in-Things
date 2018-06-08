package daemonumbra.seedshiddeninthings;

import daemonumbra.seedshiddeninthings.config.Config;
import daemonumbra.seedshiddeninthings.item.Items;
import daemonumbra.seedshiddeninthings.proxy.IProxy;
import daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static daemonumbra.seedshiddeninthings.util.Constants.*;

@Mod(
        modid = MOD_ID,
        name = MOD_NAME,
        version = VERSION,
        updateJSON = UPDATE_URL
)
public class SeedsHiddenInThings {

    @Mod.Instance(MOD_ID)
    public static SeedsHiddenInThings INSTANCE;

    @SidedProxy(clientSide = CLIENT_PROXY,serverSide = SERVER_PROXY)
    public static IProxy PROXY;

    public static final CreativeTabs CREATIVE_TAB = new CreativeTabs(Constants.MOD_ID) {
        @Override
        public ItemStack getTabIconItem() {
            return  new ItemStack(Items.SEEDY_POO);
        }
    };

    public static Logger logger = LogManager.getLogger(MOD_ID);
    public static List<Item> seedItems = new ArrayList<Item>();

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        SeedsHiddenInThings.PROXY.registerEntityRenders();
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        loadSeeds();
    }

    private void loadSeeds() {
        logger.info("Reading seed list from config");
        seedItems.clear();
        for(String seed: Config.hiddenSeeds){
            if(seed.contains(":")) {
                Item seedItem = Item.getByNameOrId(seed);
                if (seedItem != null) {
                    seedItems.add(seedItem);
                }
            }else{
                NonNullList<ItemStack> seedStacks = OreDictionary.getOres(seed);
                if(!seedStacks.isEmpty()){
                    for(ItemStack seedStack:seedStacks){
                        seedItems.add(seedStack.getItem());
                    }
                }
            }
        }
        logger.info("Seeds found:");
        for (Item item: seedItems) {
            logger.info(item.getRegistryName());
        }
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
