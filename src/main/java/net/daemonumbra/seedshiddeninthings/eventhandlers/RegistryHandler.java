package net.daemonumbra.seedshiddeninthings.eventhandlers;

import net.daemonumbra.seedshiddeninthings.SeedsHiddenInThings;
import net.daemonumbra.seedshiddeninthings.init.SHiTEntities;
import net.daemonumbra.seedshiddeninthings.init.SHiTItems;
import net.daemonumbra.seedshiddeninthings.init.SHiTSounds;
import net.daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
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
        SHiTItems.registerItems(event);
    }

    @SubscribeEvent
    public static void addItemRenders(ModelRegistryEvent event) {
        SeedsHiddenInThings.PROXY.registerItemRenders(event);
    }

    @SubscribeEvent
    public static void addEntities(RegistryEvent.Register<EntityEntry> event) {
        SHiTEntities.registerEntities();
    }

    @SubscribeEvent
    public static void addSoundEvents(RegistryEvent.Register<SoundEvent> event){
        SHiTSounds.registerSoundEvents(event);
    }
}
