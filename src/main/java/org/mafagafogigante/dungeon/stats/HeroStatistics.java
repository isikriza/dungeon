package org.mafagafogigante.dungeon.stats;

import org.mafagafogigante.dungeon.io.Version;

import java.io.Serializable;

/**
 * HeroStatistics class that tracks the Hero's statistics.
 */
public final class HeroStatistics implements Serializable {

  private static final long serialVersionUID = Version.MAJOR;

  private long healingThroughEating;
  private long damageInflicted;
  private long damageTaken;
  private long sleepingTime;
  private long restingTime;
  private long totalDamage;
  private long healingThroughDrinking;

  public void incrementHealingThroughEating(long healing) {
    healingThroughEating += healing;
  }

  public void incrementDamageTakenThroughDrinking(long perc) {
    damageTaken -= damageTaken * (perc / 100);
  }

  public void incrementHealingThroughDrinking(long healing) {
    healingThroughDrinking += healing;
  }

  public void incrementDamageInflicted(long damage) {
    damageInflicted += damage;
  }

  public void incrementDamageTaken(long damage) {
    damageTaken += damage;
  }

  public void incrementSleepingTime(long seconds) {
    sleepingTime += 1000L * seconds;
  }

  public void incrementRestingTime(long seconds) {
    restingTime += 1000L * seconds;
  }

  long getHealingThroughEating() {
    return healingThroughEating;
  }

  long getDamageInflicted() {
    return damageInflicted;
  }

  long getDamageTaken() {
    return damageTaken;
  }

  long getSleepingTime() {
    return sleepingTime;
  }

  long getRestingTime() {
    return restingTime;
  }

  long getHealingThroughDrinking() {
    return healingThroughDrinking;
  }

}
