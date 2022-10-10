package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.behaviours.EvolveBehaviour;
import game.pokemons.EvolvingPokemon;

public class EvolveAction extends Action {

    EvolvingPokemon evolvingPokemon;

    public EvolveAction(EvolvingPokemon evolvingPokemon) {
        this.evolvingPokemon = evolvingPokemon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Location location = map.locationOf(evolvingPokemon);
        map.removeActor(evolvingPokemon);
        map.addActor(evolvingPokemon.getEvolvedPokemon(), location);
        return evolvingPokemon + " evolves to " + evolvingPokemon.getEvolvedPokemon();
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Evolve " + evolvingPokemon;
    }
}
