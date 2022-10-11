package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.EvolveAction;
import game.pokemons.EvolvingPokemon;
/**
 * Class that provides the behaviour to evolve pokemon
 * Created by:
 * @author Shyam Kamalesh Borkar
 */
public class EvolveBehaviour implements Behaviour{

    /**
     * The pokemon that is going to evolve
     */
    EvolvingPokemon evolvingPokemon;

    /**
     * EvolveBehaviour Constructor
     * @param evolvingPokemon The pokemon that is going to evolve
     */
    public EvolveBehaviour(EvolvingPokemon evolvingPokemon) {
        this.evolvingPokemon = evolvingPokemon;
    }

    /**
     * logic to get an evolve action if it is possible
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        boolean actorInSurrounding = false;
        for (Exit exit: map.locationOf(evolvingPokemon).getExits()) {
            if (exit.getDestination().containsAnActor()) {
                actorInSurrounding = true;
            }
        }
        if (evolvingPokemon.shouldEvolve() && !actorInSurrounding) {
            return new EvolveAction(evolvingPokemon);
        }

        return null;
    }
}
