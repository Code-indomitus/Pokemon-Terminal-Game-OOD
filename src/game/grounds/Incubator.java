package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.Status;

/**
 * Incubator ground to incubate pokemon egg
 * @author Eng Lim Ooi
 *
 */
public class Incubator extends Ground {

    /**
     * Incubator Constructor.
     */
    public Incubator() {
        super('X');
        this.addCapability(Status.INCUBATE);
    }
}
