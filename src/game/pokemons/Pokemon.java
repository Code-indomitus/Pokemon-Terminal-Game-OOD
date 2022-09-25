package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.actions.CatchPokemonAction;
import game.actions.FeedPokemonAction;
import game.actions.KilledAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;

import java.util.Map;
import java.util.TreeMap;

/**
 * Class representing the Pokemon parent class
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:  Shyam Kamalesh Borkar, Arrtish Suthan
 *
 */
public abstract class Pokemon extends Actor {
    private final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour

    /**
     * constructor
     * @param pokemonName name of the pokemon object
     * @param pokemonDisplayChar character used to denote the presence of the pokemon on the map
     */
    public Pokemon(String pokemonName, char pokemonDisplayChar) {
        super(pokemonName, pokemonDisplayChar, 100);
        this.addCapability(Status.CANNOT_ENTER_FLOOR);
        AffectionManager.getInstance().registerPokemon(this);

        this.behaviours.put(1, new AttackBehaviour(this));
        this.behaviours.put(2, new FollowBehaviour(AffectionManager.getInstance().getTrainer()));
        this.behaviours.put(3, new WanderBehaviour());



    }

    /**
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return
     */
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!this.isConscious()){
            AffectionManager.getInstance().cleanUp(this);
            map.removeActor(this);
            return new KilledAction();
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        for (Item item : otherActor.getInventory()) {
            if (item.hasCapability(Status.FEEDABLE)) {
                actions.add(new FeedPokemonAction(item, this));
            }
        }
        if (this.hasCapability(Status.CATCHABLE)) {
            actions.add(new CatchPokemonAction(this));
        }
        return actions;
    }

    /**
     *
     * @return the respective pokemon's name, hp and AP points
     */
    @Override
    public String toString() {
        return name + " " + printHp() + "(AP: " + AffectionManager.getInstance().getAffectionPoint(this) + ")";

    }
}
