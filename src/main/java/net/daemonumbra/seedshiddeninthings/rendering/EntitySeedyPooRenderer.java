package net.daemonumbra.seedshiddeninthings.rendering;

import net.daemonumbra.seedshiddeninthings.SeedsHiddenInThings;
import net.daemonumbra.seedshiddeninthings.entity.EntitySeedyPoo;
import net.daemonumbra.seedshiddeninthings.init.SHiTItems;
import net.daemonumbra.seedshiddeninthings.rendering.factories.EntitySeedyPooRenderFactory;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * The Renderer for EntitySeedyPoo
 */
public class EntitySeedyPooRenderer extends RenderSnowball<EntitySeedyPoo> {

    public static final IRenderFactory FACTORY = new EntitySeedyPooRenderFactory();

    public EntitySeedyPooRenderer(RenderManager renderManagerIn, RenderItem itemRendererIn) {
        super(renderManagerIn, SHiTItems.SEEDY_POO, itemRendererIn);
        if (SHiTItems.SEEDY_POO == null) {
            throw new NullPointerException("Attempted to construct render with null item");
        }
    }

    @Override
    public ItemStack getStackToRender(EntitySeedyPoo entityIn) {
        if (SHiTItems.SEEDY_POO == null) {
            throw new NullPointerException("Attempted to register render with null item");
        }
        return new ItemStack(SHiTItems.SEEDY_POO, 1);
    }

    /**
     * Renders the desired {@code T} type Entity.
     *
     * @param entity
     * @param x
     * @param y
     * @param z
     * @param entityYaw
     * @param partialTicks
     */
    @Override
    public void doRender(EntitySeedyPoo entity, double x, double y, double z, float entityYaw, float partialTicks) {
        SeedsHiddenInThings.logger.info("Rendering...");
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
