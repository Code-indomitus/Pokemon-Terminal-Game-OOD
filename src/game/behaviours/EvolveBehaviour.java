package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.EvolveAction;
import game.pokemons.EvolvingPokemon;

public class EvolveBehaviour implements Behaviour{

    EvolvingPokemon evolvingPokemon;

    public EvolveBehaviour(EvolvingPokemon evolvingPokemon) {
        this.evolvingPokemon = evolvingPokemon;
    }

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
