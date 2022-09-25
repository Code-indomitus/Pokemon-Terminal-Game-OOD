package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An Action to kill an Actor.
 * Created by:
 * @author Shyam Kamalesh Borkar
 * Modified by: Arrtish Suthan
 */
public class KilledAction extends Action {

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return null
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return null
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
