package net.daemonumbra.seedshiddeninthings.eventhandlers;

import net.daemonumbra.seedshiddeninthings.capabilities.PooManagerProvider;
import net.daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class CapabilityHandler {
    public static final ResourceLocation POO_MANAGER = new ResourceLocation(Constants.MOD_ID,"PooManager");

    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event){
        event.addCapability(POO_MANAGER, new PooManagerProvider());
    }
}
