package daemonumbra.seedshiddeninthings.eventhandlers;

import daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EntityHandler {
    private static final String SHiT_MOD = Constants.MOD_NAME.replace(" ","");
    private static final String NEXT_POOP_CHANCE = "NextPoopChance";
    private static final String CAN_POOP = "CanPoop";
    private static int timeBetweenPoops = 1200; //TODO: Move to SHiTConfig
    private static int poopProbability = 50; //TODO: Move to SHiTConfig

    @SubscribeEvent
    public void livingUpdate(LivingUpdateEvent event) {
        if (!event.getEntity().world.isRemote) {
            if (!event.getEntity().getEntityData().hasKey(SHiT_MOD)) {
                NBTTagCompound newTagCompound = new NBTTagCompound();
                newTagCompound.setInteger(NEXT_POOP_CHANCE, timeBetweenPoops);
                newTagCompound.setBoolean(CAN_POOP, false);
                event.getEntity().getEntityData().setTag(SHiT_MOD, newTagCompound);
            } else {
                NBTTagCompound tagCompound = event.getEntity().getEntityData().getCompoundTag(SHiT_MOD);
                tagCompound.setInteger(NEXT_POOP_CHANCE, tagCompound.getInteger(NEXT_POOP_CHANCE) - 1);

                if (tagCompound.getInteger(NEXT_POOP_CHANCE) <= 0) {
                    tagCompound.setInteger(NEXT_POOP_CHANCE, timeBetweenPoops);
                    if (Constants.RNG.nextInt(100) <= poopProbability) {
                        tagCompound.setBoolean(CAN_POOP, true);
                    }
                }
                    if (event.getEntity() instanceof EntityPlayer) {
                        if (tagCompound.getBoolean(CAN_POOP) && (event.getEntity()).isSneaking()) {
                            Poop(event.getEntity());
                            tagCompound.setBoolean(CAN_POOP, false);
                        }
                    } else {
                        if (tagCompound.getBoolean(CAN_POOP)) {
                            Poop(event.getEntity());
                            tagCompound.setBoolean(CAN_POOP, false);
                        }
                    }
            }
        }
    }

    private void Poop(Entity entity) {

    }
}
