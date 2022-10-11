package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.behaviours.EvolveBehaviour;
import game.pokemons.AffectionManager;
import game.pokemons.EvolvingPokemon;
/**
 * Class that provides the action to evolve pokemon
 * Created by:
 * @author Shyam Kamalesh Borkar
 */
public class EvolveAction extends Action {
    /**
     * The pokemon that is going to evolve
     */
    EvolvingPokemon evolvingPokemon;

    /**
     * EvolveAction Constructor
     * @param evolvingPokemon The pokemon that is going to evolve
     */
    public EvolveAction(EvolvingPokemon evolvingPokemon) {
        this.evolvingPokemon = evolvingPokemon;
    }

    /**
     * Logic to evolve the pokemon and transfer its AP
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int previousAffection = AffectionManager.getInstance().getAffectionPoint(evolvingPokemon);
        Location location = map.locationOf(evolvingPokemon);
        map.removeActor(evolvingPokemon);
        map.addActor(evolvingPokemon.getEvolvedPokemon(), location);

        // Carry over the evolving pokemon's affection points to the evolved pokemon
        AffectionManager.getInstance().registerPokemon(evolvingPokemon.getEvolvedPokemon(), previousAffection);

        return evolvingPokemon + " evolves to " + evolvingPokemon.getEvolvedPokemon();
    }

    /**
     * Menu description fore the evolve action
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Evolve " + evolvingPokemon;
    }
}
