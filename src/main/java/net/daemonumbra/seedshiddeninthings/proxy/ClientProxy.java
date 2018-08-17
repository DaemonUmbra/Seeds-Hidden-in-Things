package net.daemonumbra.seedshiddeninthings.proxy;

import net.daemonumbra.seedshiddeninthings.init.SHiTEntities;
import net.daemonumbra.seedshiddeninthings.init.SHiTItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;

/**
 * SHiT's Client-Side Proxy
 */
public class ClientProxy implements IProxy {

    @Override
    public Side getSide() {
        return Side.CLIENT;
    }

    @Override
    public void registerEntityRenders() {
        SHiTEntities.registerEntityRenderers();
    }

    @Override
    public void registerItemRenders(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(SHiTItems.SEEDY_POO, 0, new ModelResourceLocation(SHiTItems.SEEDY_POO.getRegistryName(), "inventory"));
    }
}
