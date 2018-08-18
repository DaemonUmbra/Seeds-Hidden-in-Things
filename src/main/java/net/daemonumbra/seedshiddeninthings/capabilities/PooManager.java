package net.daemonumbra.seedshiddeninthings.capabilities;

import net.daemonumbra.seedshiddeninthings.config.SHiTConfig;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class PooManager implements IPooManager {
    private Instant lastPoop;

    @Override
    public void resetTTPC() {
        this.lastPoop = java.time.Instant.now();
    }

    @Override
    public void setLastPoopTime(long aLong) {
        this.lastPoop = java.time.Instant.ofEpochMilli(aLong);
    }

    @Override
    public int getTimeToPoopChance() {
        int ttpc = (int)Duration.between(java.time.Instant.now(),lastPoop.plus(SHiTConfig.timeToPoopChance,ChronoUnit.SECONDS)).getSeconds();
        if(ttpc > 0)
            return ttpc;
        else
            return 0;
    }

    @Override
    public Instant getLastPoopTime() {
        return this.lastPoop;
    }

    @Override
    public boolean canPoop() {
        return getTimeToPoopChance() == 0;
    }

    public static IPooManager getDefault(){
        IPooManager retVal = new PooManager();
        retVal.resetTTPC();
        return retVal;
    }
}
