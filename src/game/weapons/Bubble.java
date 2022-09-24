package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Class representing the Bubble weapon item
 *
 * Created by:
 * @author Arrtish Suthan
 * Modified by:
 *
 */
public class Bubble extends WeaponItem {


    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public Bubble(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
    }
}
