//package game.pokemoncenter;
//
//import edu.monash.fit2099.engine.actions.Action;
//import edu.monash.fit2099.engine.items.Item;
//import edu.monash.fit2099.engine.positions.GameMap;
//import edu.monash.fit2099.engine.positions.Location;
///**
// * Door item class
// * Created by:
// * @author Shyam Kamalesh Borkar
// */
//public class Door extends Item {
//
//    /**
//     * The enter action associated with the door
//     */
//    EnterAction enterAction;
//
//    /***
//     * Door Constructor.
//     */
//    public Door(EnterAction enterAction) {
//        super("Door", '=', false);
//        this.enterAction = enterAction;
//        addAction(enterAction);
//    }
//}

package game.pokemoncenter;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;

/**
 * Door item class
 * Created by:
 * @author Shyam Kamalesh Borkar
 */
public class Door extends Ground {

    /**
     * The enter action associated with the door
     */
    EnterAction enterAction;

    public Door(EnterAction enterAction) {
        super('=');
        this.enterAction = enterAction;
    }

    /**
     * return the enter action to the actor
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        actions.add(this.enterAction);
        return actions;
    }

    /**
     * Overridden method to stop actors that cannot enter floors
     * @param actor the Actor to check
     * @return boolean
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Status.CANNOT_ENTER_FLOOR)) {
            return false;
        } else {
            return true;
        }
    }
}

