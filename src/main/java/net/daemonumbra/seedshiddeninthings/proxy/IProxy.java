package net.daemonumbra.seedshiddeninthings.proxy;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Lists methods implemented in the proxies
 */
public interface IProxy {
    void registerEntityRenders();

    Side getSide();

    void registerItemRenders(ModelRegistryEvent event);
}
