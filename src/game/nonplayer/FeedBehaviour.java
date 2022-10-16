package game.nonplayer;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.actions.FeedPokemonAction;
import game.behaviours.Behaviour;
import game.pokemons.Pokemon;

/**
 * Class for the Feed behaviour that a trainer will have
 * Created by:
 * @author Arrtish Suthan and Shyam Kamalesh Borkar
 */
public class FeedBehaviour implements Behaviour {

    /**
     * the trainer that does the behaviour
     */
    Trainer trainer;

    /**
     * Feed behaviour constructor
     * @param trainer the trainer that does the behaviour
     */
    public FeedBehaviour(Trainer trainer) {
        this.trainer = trainer;
    }

    /**
     * check if there is a pokefruit to feed and a pokemon in the surroundings so that a feed action can be done accordingly
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return action
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        boolean hasPokeFruit = false;
        boolean pokemonNear = false;
        Item pokefruit = null;
        Pokemon pokemon = null;
        // check if trainer has pokefruit
        for (Item item : this.trainer.getInventory()) {
            if (item.hasCapability(Status.FEEDABLE)) {
                pokefruit = item;
                hasPokeFruit = true;
                break;
            }
        }

        // check if trainer next to pokemon
        for (Exit exit : map.locationOf(this.trainer).getExits()) {
            if (exit.getDestination().containsAnActor() && exit.getDestination().getActor().hasCapability(Status.POKEMON)) {
                pokemon = (Pokemon) exit.getDestination().getActor();
                pokemonNear = true;
                break;
            }
        }

        if (hasPokeFruit && pokemonNear) {
            return new TrainerFeedAction(this.trainer, pokefruit, pokemon);
        }


        return null;
    }
}
