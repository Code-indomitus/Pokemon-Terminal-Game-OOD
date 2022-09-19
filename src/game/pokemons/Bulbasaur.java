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
import game.time.TimePerception;
import game.time.TimePerceptionManager;

import java.util.HashMap;
import java.util.Map;

public class Bulbasaur extends Pokemon implements TimePerception {

    public Bulbasaur() {
        super("Bulbasaur", 'b');
        this.addCapability(Status.CATCHABLE);
        registerInstance();
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
        hurt(5);
    }

    @Override
    public void nightEffect() {
        heal(5);
    }


}
