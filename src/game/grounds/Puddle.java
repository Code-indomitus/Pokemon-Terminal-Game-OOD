package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.elements.Element;
import game.time.TimePerception;

public class Puddle extends Ground implements TimePerception {
    /**
     * Constructor.
     *
     */
    public Puddle() {
        super('~');
        this.addCapability(Element.WATER);
        this.registerInstance();
    }

    @Override
    public void dayEffect() {

    }

    @Override
    public void nightEffect() {

    }
}
