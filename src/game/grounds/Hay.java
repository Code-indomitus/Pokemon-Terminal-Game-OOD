package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.elements.Element;

/**
 * @author Shyam Kamalesh Borkar
 * Class for Hay (Ground)
 */
public class Hay extends Ground {
    /**
     * Hay Constructor
     */
    public Hay() {
        super(',');
        this.addCapability(Element.GRASS);
    }
}
