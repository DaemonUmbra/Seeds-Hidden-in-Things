package net.daemonumbra.seedshiddeninthings.init;

import net.daemonumbra.seedshiddeninthings.entity.EntitySeedyPoo;
import net.daemonumbra.seedshiddeninthings.rendering.EntitySeedyPooRenderer;
import net.daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.minecraftforge.fml.common.registry.GameRegistry.*;

/**
 * Manages Entities for SHiT
 */
@ObjectHolder(Constants.MOD_ID)
public class SHiTEntities {
    private static int ID = 0;

    @ObjectHolder("entityseedypoo")
    public EntityEntry entitySeedyPoo = null;

    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
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
