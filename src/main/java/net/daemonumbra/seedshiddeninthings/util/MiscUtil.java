package net.daemonumbra.seedshiddeninthings.util;

import net.daemonumbra.seedshiddeninthings.capabilities.PooManagerProvider;
import net.daemonumbra.seedshiddeninthings.config.SHiTConfig;
import net.daemonumbra.seedshiddeninthings.init.SHiTItems;
import net.daemonumbra.seedshiddeninthings.init.SHiTSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

public class MiscUtil {
    public static void poop(Entity entity) {
        if(entity.rand.nextInt(100) < SHiTConfig.poopChance) {//Let them try to poop
            entity.world.playSound(entity.posX, entity.posY, entity.posZ, SHiTSounds.POOP_SOUND, entity.getSoundCategory(), 1, 1, true);
            entity.world.spawnEntity(new EntityItem(entity.world, entity.posX, entity.posY, entity.posZ, new ItemStack(SHiTItems.SEEDY_POO, 1)));
            entity.getCapability(PooManagerProvider.POO_MANAGER,null).resetTTPC();
        }
    }
}
