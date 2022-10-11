package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.elements.Element;

/**
 * Class representing the Blaze weapon item
 * Created by:
 * @author Shyam Kamalesh Borkar
 */
public class Blaze extends WeaponItem {
    /**
     * Blaze Constructor.
     */
    public Blaze() {
        super("Blaze", ']', 60, "blazes", 90);
        this.addCapability(Element.FIRE);
    }
}
