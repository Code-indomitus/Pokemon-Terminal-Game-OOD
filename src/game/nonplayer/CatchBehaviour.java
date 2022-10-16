package game.nonplayer;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.behaviours.Behaviour;
import game.pokemons.Pokemon;

/**
 * Class for the catch behaviour that a trainer will have
 * Created by:
 * @author Arrtish Suthan and Shyam Kamalesh Borkar
 */
public class CatchBehaviour implements Behaviour {
    /**
     * the trainer that does the behaviour
     */
    Trainer trainer;

    /**
     * CatchBehaviour constructor
     * @param trainer the trainer that does the behaviour
     */
    public CatchBehaviour(Trainer trainer) {
        this.trainer = trainer;
    }

    /**
     * check if a pokemon is near to be caught and can be caught. If so then return catch pokemon action
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return action
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        boolean pokemonNear = false;
        Pokemon pokemon = null;

        // check if trainer next to pokemon
        for (Exit exit : map.locationOf(this.trainer).getExits()) {
            if (exit.getDestination().containsAnActor() && exit.getDestination().getActor().hasCapability(Status.POKEMON) && exit.getDestination().getActor().hasCapability(Status.CATCHABLE)) {
                pokemon = (Pokemon) exit.getDestination().getActor();
                pokemonNear = true;
                break;
            }
        }

        if (pokemonNear) {
            return new TrainerCatchAction(this.trainer, pokemon);
        }
        return null;
    }
}
