package game.pokemoncenter;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
/**
 * Door item class
 * Created by:
 * @author Shyam Kamalesh Borkar
 */
public class Door extends Item {

    /**
     * The enter action associated with the door
     */
    EnterAction enterAction;

    /***
     * Door Constructor.
     */
    public Door(EnterAction enterAction) {
        super("Door", '=', false);
        this.enterAction = enterAction;
        addAction(enterAction);
    }
}
