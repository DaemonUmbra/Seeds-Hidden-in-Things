package daemonumbra.seedshiddeninthings.proxy;

import net.minecraftforge.fml.relauncher.Side;

/**
 * SHiT's Server-Side Proxy
 */
public class ServerProxy implements IProxy {
    @Override
    public void registerEntityRenders() {
        //Does nothing, this is a client only thing
    }

    @Override
    public Side getSide() {
        return Side.SERVER;
    }
}
