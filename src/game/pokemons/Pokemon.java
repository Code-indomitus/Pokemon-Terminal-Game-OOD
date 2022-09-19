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
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;

import java.util.Map;
import java.util.TreeMap;

public abstract class Pokemon extends Actor {
    private final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour


    public Pokemon(String pokemonName, char pokemonDisplayChar) {
        super(pokemonName, pokemonDisplayChar, 100);
        this.addCapability(Status.CANNOT_ENTER_FLOOR);
        AffectionManager.getInstance().registerPokemon(this);

        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(2, new FollowBehaviour(AffectionManager.getInstance().getTrainer()));
        this.behaviours.put(3, new WanderBehaviour());



    }

    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
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

    @Override
    public String toString() {
        return name + " " + printHp() + "(AP: " + AffectionManager.getInstance().getAffectionPoint(this) + ")";

    }
}
