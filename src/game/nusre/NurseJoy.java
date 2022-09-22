package game.nusre;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Class fo Nurse Joy (Actor)
 *
 * @author Shyam Kamalesh Borkar
 */
public class NurseJoy extends Actor {

    /**
     * Nurse Joy Constructor
     */
    public NurseJoy() {
        super("Nurse Joy", '%', 100);
    }

    /**
     * Returns all the allowable actions the player of the game can do with Nures Joy
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions =  TradeManager.getTradeActions(otherActor);
        return actions;
    }

    /**
     * Returns what nurse joy will do every turn (she does nothing)
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

}
