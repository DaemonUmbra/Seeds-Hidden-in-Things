package daemonumbra.seedshiddeninthings.init;

import daemonumbra.seedshiddeninthings.entity.EntitySeedyPoo;
import daemonumbra.seedshiddeninthings.rendering.EntitySeedyPooRenderer;
import daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

/**
 * Manages Entities for SHiT
 */
public class SHiTEntities {
    private static int ID = 0;

    @SuppressWarnings("unchecked")
    public static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySeedyPoo.class, EntitySeedyPooRenderer.FACTORY);
    }

    public static void registerEntities() {
        registerEntity(EntitySeedyPoo.class);
    }

    private static <T extends Entity> void registerEntity(Class<T> entityClass) {
        EntityEntryBuilder builder = EntityEntryBuilder.create();
        builder.name(entityClass.getName());
        builder.id(new ResourceLocation(Constants.MOD_ID, entityClass.getName()), ID++);
        builder.tracker(128, 152, true);
    }

    private static <T extends Entity> void registerEntity(Class<T> entityClass, int eggPrimaryColor, int eggSecondaryColor) {
        EntityEntryBuilder builder = EntityEntryBuilder.create();
        builder.name(entityClass.getName());
        builder.id(new ResourceLocation(Constants.MOD_ID, entityClass.getName()), ID++);
        builder.tracker(128, 152, true);
        builder.egg(eggPrimaryColor, eggSecondaryColor);
    }
}
