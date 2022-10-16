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

public class FeedBehaviour implements Behaviour {

    Trainer trainer;

    public FeedBehaviour(Trainer trainer) {
        this.trainer = trainer;
    }

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
