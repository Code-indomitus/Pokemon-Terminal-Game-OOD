package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.Status;

public class Incubator extends Ground {

    /**
     * Incubator Constructor.
     */
    public Incubator() {
        super('x');
        this.addCapability(Status.INCUBATE);
    }
}
