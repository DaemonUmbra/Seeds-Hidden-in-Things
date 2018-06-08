package daemonumbra.seedshiddeninthings.proxy;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.SERVER)
public class ServerProxy implements IProxy {
    @Override
    public void registerEntityRenders() {
        //Does nothing, this is a client only thing
    }
}
