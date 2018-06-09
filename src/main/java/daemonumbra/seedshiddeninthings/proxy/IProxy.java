package daemonumbra.seedshiddeninthings.proxy;

import net.minecraftforge.fml.relauncher.Side;

/**
 * Lists methods implemented in the proxies
 */
public interface IProxy {
    void registerEntityRenders();

    Side getSide();
}
