package daemonumbra.seedshiddeninthings.rendering.factories;

import daemonumbra.seedshiddeninthings.entity.EntitySeedyPoo;
import daemonumbra.seedshiddeninthings.rendering.EntitySeedyPooRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * The render factory for EntitySeedyPoo
 */
public class EntitySeedyPooRenderFactory implements IRenderFactory<EntitySeedyPoo> {
    @Override
    public Render<? super EntitySeedyPoo> createRenderFor(RenderManager manager) {
        return new EntitySeedyPooRenderer(manager, Minecraft.getMinecraft().getRenderItem());
    }
}
