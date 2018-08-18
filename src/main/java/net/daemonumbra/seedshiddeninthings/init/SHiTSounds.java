package net.daemonumbra.seedshiddeninthings.init;

import net.daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;

import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(Constants.MOD_ID)
public class SHiTSounds {

    @ObjectHolder("entity.poop")
    public static final SoundEvent POOP_SOUND = null;

    public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event){
        event.getRegistry().register(new SoundEvent(new ResourceLocation(Constants.MOD_ID,"entity.poop")).setRegistryName(Constants.MOD_ID,"entity.poop"));
    }
}
