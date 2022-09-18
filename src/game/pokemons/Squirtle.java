package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.elements.Element;
import game.time.TimePerception;
import game.time.TimePerceptionManager;

import java.util.HashMap;
import java.util.Map;

public class Squirtle extends Pokemon implements TimePerception {

    public Squirtle() {
        super("Squirtle", 's');
        this.addCapability(Element.WATER);
        this.addCapability(Status.CATCHABLE);
        registerInstance();
    }

    /**
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return new ActionList();
    }

    /**
     * By using behaviour loops, it will decide what will be the next action automatically.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!this.isConscious()){
            TimePerceptionManager.getInstance().cleanUp(this);
            AffectionManager.getInstance().cleanUp(this);
            map.removeActor(this);
        }
        return super.playTurn(actions, lastAction, map, display);
    }
    /**
     * @param isEquipping FIXME: develop a logic to toggle weapon (put a selected weapon to the inventory - used!);
     */
    public void toggleWeapon(boolean isEquipping) {
    }

    @Override
    public void dayEffect() {
        hurt(10);
    }

    @Override
    public void nightEffect() {
        heal(10);
    }


}
