package net.daemonumbra.seedshiddeninthings.init;

import net.daemonumbra.seedshiddeninthings.entity.EntitySeedyPoo;
import net.daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

import java.util.function.Function;

import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * Manages Entities for SHiT
 */
@ObjectHolder(Constants.MOD_ID)
public class SHiTEntities {
    private static int ID = 0;

    @ObjectHolder("entityseedypoo")
    public EntityEntry entitySeedyPoo = null;

    @SuppressWarnings("unchecked")
    public static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySeedyPoo.class, EntitySeedyPoo.getRenderFactory());
    }

    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        registerEntity(event, EntitySeedyPoo.class,EntitySeedyPoo::new);
    }

    private static <T extends Entity> void registerEntity(RegistryEvent.Register<EntityEntry> event, Class<T> entityClass, final Function<World, ? extends Entity> factory) {
        EntityEntryBuilder builder = EntityEntryBuilder.create();
        builder.entity(entityClass);
        builder.id(new ResourceLocation(Constants.MOD_ID, entityClass.getName()), ID++);
        builder.name(entityClass.getName());
        builder.tracker(128, 152, true);
        event.getRegistry().register(builder.build());
    }

    private static <T extends Entity> void registerEntity(RegistryEvent.Register<EntityEntry> event, Class<T> entityClass, final Function<World, ? extends Entity> factory, int eggPrimaryColor, int eggSecondaryColor) {
        EntityEntryBuilder builder = EntityEntryBuilder.create();
        builder.entity(entityClass);
        builder.id(new ResourceLocation(Constants.MOD_ID, entityClass.getName()), ID++);
        builder.name(entityClass.getName());
        builder.tracker(128, 152, true);
        builder.egg(eggPrimaryColor, eggSecondaryColor);
        event.getRegistry().register(builder.build());
    }
}
