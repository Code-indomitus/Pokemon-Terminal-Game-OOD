package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.elements.Element;
import game.time.TimePerception;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Lava extends Ground implements TimePerception {
    /**
     * Constructor.
     */
    public Lava() {
        super('^');
        this.addCapability(Element.FIRE);
        this.registerInstance();
    }

    @Override
    public void dayEffect() {

    }

    @Override
    public void nightEffect() {
//        if (Math.random() <= 0.1 && this.)

    }
}
