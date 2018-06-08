package daemonumbra.seedshiddeninthings.listeners;

import daemonumbra.seedshiddeninthings.SeedsHiddenInThings;
import daemonumbra.seedshiddeninthings.entity.EntitySeedyPoo;
import daemonumbra.seedshiddeninthings.item.ItemSeedyPoo;
import daemonumbra.seedshiddeninthings.item.Items;
import daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class RegistryHandler {


    @SubscribeEvent
    public static void addItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemSeedyPoo().setUnlocalizedName("daemonumbra.seedshiddeninthings.seedypoo").setRegistryName(Constants.MOD_ID,"seedypoo"));
    }

    @SubscribeEvent
    public static void addItemRenders(ModelRegistryEvent event){
        ModelLoader.setCustomModelResourceLocation(Items.SEEDY_POO,0,new ModelResourceLocation(Items.SEEDY_POO.getRegistryName(),"inventory"));
    }

    @SubscribeEvent
    public static void addEntities(RegistryEvent.Register<EntityEntry> event){
        event.getRegistry().register(new EntityEntry(EntitySeedyPoo.class,"Seedy Poo").setRegistryName(Constants.MOD_ID,"seedypoo"));
    }
}
