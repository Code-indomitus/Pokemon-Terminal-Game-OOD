package game.pokemons;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.elements.Element;
import game.nusre.Tradeable;

/**
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class Charmander extends Pokemon implements Tradeable, TimePerception {

    /**
     * Constructor.
     */
    public Charmander() {
        super("Charmander", 'c');
        this.addCapability(Element.FIRE);
        registerInstance();
    }

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
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
       return new ActionList();
    }


//    /**
//     * @param isEquipping FIXME: develop a logic to toggle weapon (put a selected weapon to the inventory - used!);
//     */
    public void toggleWeapon(Pokemon pokemon, GameMap map) {
        if (pokemon.hasCapability(Element.FIRE) && map.locationOf(pokemon).getGround().hasCapability(Element.FIRE)){

        }
    }

    @Override
    public boolean isPokemon() {
        return true;
    }

    @Override
    public void dayEffect() {
        heal(10);
    }

    @Override
    public void nightEffect() {
        hurt(10);
    }
}