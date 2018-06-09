package daemonumbra.seedshiddeninthings.proxy;

import daemonumbra.seedshiddeninthings.init.SHiTEntities;
import net.minecraftforge.fml.relauncher.Side;

/**
 * SHiT's Client-Side Proxy
 */
public class ClientProxy implements IProxy {
    @Override
    public void registerEntityRenders() {
        SHiTEntities.registerEntityRenderers();
    }

    @Override
    public Side getSide() {
        return Side.CLIENT;
    }
}
