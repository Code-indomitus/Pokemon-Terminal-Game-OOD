package game.nonplayer;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;

import java.util.Map;
import java.util.TreeMap;


/**
 * Class representing the Non player Trainer actors
 *
 * Created by:
 * @author Arrtish Suthan
 */
public abstract class Trainer extends Actor {
    /**
     *
     */
    protected Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Trainer Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Trainer(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    /**
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return do nothing action if there are no actions called, or return actions available to the trainer
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }


}