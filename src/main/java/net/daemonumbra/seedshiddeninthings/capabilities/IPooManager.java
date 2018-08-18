package net.daemonumbra.seedshiddeninthings.capabilities;

import java.time.Instant;

public interface IPooManager {
    int getTimeToPoopChance();
    Instant getLastPoopTime();
    boolean canPoop();
    void resetTTPC();
    void setLastPoopTime(long aLong);
}
