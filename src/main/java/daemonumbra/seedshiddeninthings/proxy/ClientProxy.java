package daemonumbra.seedshiddeninthings.proxy;

import daemonumbra.seedshiddeninthings.entity.EntitySeedyPoo;
import daemonumbra.seedshiddeninthings.item.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy implements IProxy {
    @Override
    public void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySeedyPoo.class, renderManager -> new RenderSnowball(renderManager, Items.SEEDY_POO,Minecraft.getMinecraft().getRenderItem()));
    }
}
