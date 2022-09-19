package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
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

        this.behaviours.put(10, new WanderBehaviour());
        this.behaviours.put(20, new FollowBehaviour(AffectionManager.getInstance().getTrainer()));
        this.behaviours.put(30, new AttackBehaviour());

    }

    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public String toString() {
        return name + " " + printHp() + "(AP: " + AffectionManager.getInstance().getAffectionPoint(this) + ")";

    }
}
