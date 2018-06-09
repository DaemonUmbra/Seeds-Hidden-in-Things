package daemonumbra.seedshiddeninthings.eventhandlers;

import daemonumbra.seedshiddeninthings.init.SHiTEntities;
import daemonumbra.seedshiddeninthings.init.SHiTItems;
import daemonumbra.seedshiddeninthings.item.ItemSeedyPoo;
import daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

/**
 * Handles Registration Events
 */
@EventBusSubscriber(modid = Constants.MOD_ID)
public class RegistryHandler {


    @SubscribeEvent
    public static void addItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemSeedyPoo().setUnlocalizedName("daemonumbra.seedshiddeninthings.seedypoo").setRegistryName(Constants.MOD_ID, "seedypoo"));
    }

    @SubscribeEvent
    public static void addItemRenders(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(SHiTItems.SEEDY_POO, 0, new ModelResourceLocation(SHiTItems.SEEDY_POO.getRegistryName(), "inventory"));
    }

    @SubscribeEvent
    public static void addEntities(RegistryEvent.Register<EntityEntry> event) {
        SHiTEntities.registerEntities();
    }
}
