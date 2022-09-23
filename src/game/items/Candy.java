package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.Status;

/**
 * @author Eng Lim Ooi
 * A class that represents Candy item.
 */
public class Candy extends Item {
    /**
     * Candy Constructor.
     */
    public Candy() {
        super("Candy", '*', true);
        this.addCapability(Status.TRADEABLE_CANDY);
    }
}
