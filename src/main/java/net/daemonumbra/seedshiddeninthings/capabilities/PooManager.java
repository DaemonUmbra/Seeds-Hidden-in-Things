package net.daemonumbra.seedshiddeninthings.capabilities;

import net.daemonumbra.seedshiddeninthings.config.SHiTConfig;

public class PooManager implements IPooManager {
    private int ticksToPoopChance;

    @Override
    public int getTicksToPoopChance() {
        return ticksToPoopChance;
    }

    @Override
    public void setTicksToPoopChance(int ticks) {
        ticksToPoopChance = ticks;
    }

    @Override
    public void decrementTTPC() {
        if(ticksToPoopChance>=0)
            ticksToPoopChance = 0;
        else
            ticksToPoopChance--;
    }

    @Override
    public void resetTTPC() {
        ticksToPoopChance = SHiTConfig.ticksToPoopChance;
    }

    public static IPooManager getDefault(){
        IPooManager retVal = new PooManager();
        retVal.resetTTPC();
        return retVal;
    }
}
