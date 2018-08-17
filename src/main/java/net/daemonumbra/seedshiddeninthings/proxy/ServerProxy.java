package net.daemonumbra.seedshiddeninthings.proxy;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * SHiT's Server-Side Proxy
 */
public class ServerProxy implements IProxy {

    @Override
    public Side getSide() {
        return Side.SERVER;
    }

    @Override
    public void registerItemRenders(ModelRegistryEvent event) {

    }

    @Override
    public void registerEntityRenders() {
        //Does nothing, this is a client only thing
    }


}
