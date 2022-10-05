package game.pokemoncenter;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class Door extends Item {

    EnterAction enterAction;
    /***
     * Constructor.
     */
    public Door(EnterAction enterAction) {
        super("Door", '=', false);
        this.enterAction = enterAction;
        addAction(enterAction);
    }
}
