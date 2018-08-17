package net.daemonumbra.seedshiddeninthings.capabilities;

public interface IPooManager {
    int getTicksToPoopChance();
    void setTicksToPoopChance(int ticks);
    void decrementTTPC();
    void resetTTPC();
}
