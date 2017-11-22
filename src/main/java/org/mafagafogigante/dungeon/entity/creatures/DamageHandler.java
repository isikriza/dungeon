package org.mafagafogigante.dungeon.entity.creatures;

import org.mafagafogigante.dungeon.io.Writer;

/**
 * The class responsible for inflicting damage from one creature onto another.
 */
class DamageHandler {

  private DamageHandler() {
  }

  static void inflictDamage(Creature attacker, Creature defender, int damage) {
    //System.out.println(defender.getName().toString() + " :" + defender.getHealth().getCurrent());
    //System.out.println("DamageHandler   :" + damage);
    int decreasedDamage = damage - ((damage * defender.getDefendRate()) / 100);
    int increasedDamage = damage + ((damage * attacker.getExtraAttackRate()) / 100);
    if (increasedDamage > damage) {
      decreasedDamage = increasedDamage;
    }
    //System.out.println("DamageHandler_2 :" + decreasedDamage);
    defender.getHealth().decrementBy(decreasedDamage);
    attacker.getBattleLog().incrementInflicted(decreasedDamage);
    defender.getBattleLog().incrementTaken(decreasedDamage);
    //System.out.println(defender.getName().toString() + " :" + defender.getHealth().getCurrent());
  }

}
