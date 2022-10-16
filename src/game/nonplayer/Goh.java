package game.nonplayer;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.behaviours.WanderBehaviour;

/**
 * Class for Trainer Goh
 * Created by:
 * @author Arrtish Suthan
 */
public class Goh extends Trainer{

    /**
     * Goh Constructor.
     */
    public Goh() {
        super("Goh", 'G', 100);
        this.addCapability(Status.IMMUNE);
        super.behaviours.put(2, new FeedBehaviour(this));
        super.behaviours.put(3, new PickUpBehaviour(this));
        super.behaviours.put(4, new WanderBehaviour());
    }

}