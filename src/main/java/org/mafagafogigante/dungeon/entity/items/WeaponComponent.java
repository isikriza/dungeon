package org.mafagafogigante.dungeon.entity.items;

import org.mafagafogigante.dungeon.entity.Damage;
import org.mafagafogigante.dungeon.entity.DamageAmount;
import org.mafagafogigante.dungeon.entity.DamageType;
import org.mafagafogigante.dungeon.entity.Enchantment;
import org.mafagafogigante.dungeon.io.Version;
import org.mafagafogigante.dungeon.util.Percentage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * The weapon component of some items.
 */
public class WeaponComponent implements Serializable {

  private static final long serialVersionUID = Version.MAJOR;
  private int damage;
  private final Percentage hitRate;
  private final int integrityDecrementOnHit;
  private final List<Enchantment> enchantments = new ArrayList<>();
  //ycb
  private int level;
  /**
   * Constructs a new WeaponComponent.
   */
  //ycb
  WeaponComponent(int damage, Percentage hitRate, int integrityDecrementOnHit, int level) {
    this.damage = damage;
    this.hitRate = hitRate;
    this.integrityDecrementOnHit = integrityDecrementOnHit;
    this.level = level;
  }

  /**
   * Returns the total damage dealt by this weapon.
   */
  public int getDamage() {
    Damage damage = new Damage();
    damage.getAmounts().add(new DamageAmount(DamageType.BLUDGEONING, this.damage));
    for (Enchantment enchantment : enchantments) {
      enchantment.modifyAttackDamage(damage);
    }
    int total = 0;
    for (DamageAmount damageAmount : damage.getAmounts()) {
      total += damageAmount.getAmount();
    }
    return total;
  }

  //ycb
  public int getLevel() {
    return level;
  }

  public Percentage getHitRate() {
    return hitRate;
  }

  int getIntegrityDecrementOnHit() {
    return integrityDecrementOnHit;
  }

  public List<Enchantment> getEnchantments() {
    return enchantments;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  /*public void removeItem(Item item) {
    item.setInventory(null);

  }*/

}


