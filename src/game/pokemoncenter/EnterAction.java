package game.pokemoncenter;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
/**
 * A class representing an enter action
 * Created by:
 * @author Shyam Kamalesh Borkar
 */
public abstract class EnterAction extends Action {

    /**
     * map the actor needs to enter into
     */
    GameMap mapToEnter;

    /**
     * location the actor arrives at
     */
    Location locationToEnter;

    /**
     * Enter Action constructor
     * @param mapToEnter map the actor needs to enter into
     * @param locationToEnter location the actor arrives at
     */
    public EnterAction(GameMap mapToEnter, Location locationToEnter){
        this.mapToEnter = mapToEnter;
        this.locationToEnter = locationToEnter;
    }

    /**
     * move the actor from one map to the other
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return null, no execute string
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        mapToEnter.addActor(actor, locationToEnter);
        return null;
    }

    /**
     * description that will show up on the menu
     * @param actor The actor performing the action.
     * @return classes that extend this class will provide the string
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
