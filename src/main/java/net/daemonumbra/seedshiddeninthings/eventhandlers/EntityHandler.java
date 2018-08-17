package net.daemonumbra.seedshiddeninthings.eventhandlers;

import net.daemonumbra.seedshiddeninthings.SeedsHiddenInThings;
import net.daemonumbra.seedshiddeninthings.capabilities.IPooManager;
import net.daemonumbra.seedshiddeninthings.capabilities.PooManager;
import net.daemonumbra.seedshiddeninthings.capabilities.PooManagerProvider;
import net.daemonumbra.seedshiddeninthings.config.SHiTConfig;
import net.daemonumbra.seedshiddeninthings.init.SHiTItems;
import net.daemonumbra.seedshiddeninthings.init.SHiTSounds;
import net.daemonumbra.seedshiddeninthings.util.Constants;
import net.daemonumbra.seedshiddeninthings.util.MiscUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.ref.SoftReference;
import java.util.Random;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class EntityHandler {

    @SubscribeEvent
    public static void livingUpdate(LivingUpdateEvent event) {
        Entity entity = event.getEntity();
        if (!entity.world.isRemote) { //Check to make sure we're logical server
            if(entity.hasCapability(PooManagerProvider.POO_MANAGER,null)){ //Check that we have the capability
                IPooManager pooManager = entity.getCapability(PooManagerProvider.POO_MANAGER,null);
                if(entity instanceof EntityPlayer){//If the entity is a player
                    if(pooManager.getTicksToPoopChance() <= 0){//...they can poop
                        SeedsHiddenInThings.logger.debug(entity.getName() + " is ready to poop");
                        if(entity.isSneaking()){//...and they're sneaking
                            MiscUtil.poop(entity);
                            pooManager.resetTTPC();
                        }
                    }else{
                        pooManager.decrementTTPC();
                    }
                }else{
                    if(pooManager.getTicksToPoopChance() == 0){
                        MiscUtil.poop(entity);
                        pooManager.resetTTPC();
                    }
                }
            }
        }
    }
}
