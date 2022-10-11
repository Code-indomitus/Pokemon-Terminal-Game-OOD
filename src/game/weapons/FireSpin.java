package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;


/**
 * Class representing the FireSpin weapon item
 * Created by:
 * @author Shyam Kamalesh Borkar
 */
public class FireSpin extends WeaponItem {
    /**
     * FireSpin Constructor.
     */
    public FireSpin() {
        super("Fire Spin", '[', 70, "fire spins", 90);
        this.addCapability(Status.FIRE_SPIN);
    }
}

