package net.daemonumbra.seedshiddeninthings.init;

import net.daemonumbra.seedshiddeninthings.item.ItemSeedyPoo;
import net.daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * Manages items for SHiT
 */
@ObjectHolder(Constants.MOD_ID)
public class SHiTItems {
    @ObjectHolder("seedypoo")
    public static final Item SEEDY_POO = null;

    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().register(new ItemSeedyPoo().setTranslationKey("daemonumbra.seedshiddeninthings.seedypoo").setRegistryName(Constants.MOD_ID, "seedypoo"));
    }
}
