package daemonumbra.seedshiddeninthings.listeners;

import daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class MiscHandler {
    @SubscribeEvent
    public static void ConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.getModID().equals(Constants.MOD_ID)){
            ConfigManager.sync(Constants.MOD_ID, net.minecraftforge.common.config.Config.Type.INSTANCE);
        }
    }
}
