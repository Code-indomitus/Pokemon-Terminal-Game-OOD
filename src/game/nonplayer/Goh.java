package game.nonplayer;

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
        super.behaviours.put(3, new PickUpBehaviour(this));
        super.behaviours.put(4, new WanderBehaviour());
    }
}