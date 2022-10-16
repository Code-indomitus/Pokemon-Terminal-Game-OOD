package game.nonplayer;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Candy;
import game.items.Pokeball;
import game.pokemons.AffectionManager;
import game.pokemons.Pokemon;

/**
 * Class for the catch action that a trainer will have
 * Created by:
 * @author Arrtish Suthan and Shyam Kamalesh Borkar
 */
public class TrainerCatchAction extends Action {
    /**
     * the trainer that does the catch action
     */
    Trainer trainer;

    /**
     * pokemon that is attempted to be caught
     */
    Pokemon pokemonToBeCaught;

    /**
     * TrainerCatchAction constructor
     * @param trainer the trainer that does the catch action
     * @param pokemonToBeCaught pokemon that is attempted to be caught
     */
    public TrainerCatchAction(Trainer trainer, Pokemon pokemonToBeCaught) {
        this.trainer = trainer;
        this.pokemonToBeCaught = pokemonToBeCaught;
    }

    /**
     * check if pokemon has sufficient AP to be caught by trainer do related logic.
     * catch the pokemon in a pokeball and add to trainers inventory if all criteria is met.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (AffectionManager.getInstance().getAffectionPoint(this.pokemonToBeCaught) < 50 ) {
            AffectionManager.getInstance().decreaseAffection(this.pokemonToBeCaught, 10);
            return pokemonToBeCaught + " could not be captured.";
        }

        Pokeball newPokeball = new Pokeball();
        newPokeball.assignCaughtPokemon(pokemonToBeCaught);
        this.trainer.addItemToInventory(newPokeball);
        // Spawn candy when pokemon is captured.
        map.locationOf(pokemonToBeCaught).addItem(new Candy());
        map.removeActor(pokemonToBeCaught);

        return pokemonToBeCaught + " has been successfully captured.";
    }

    /**
     * there is no menu description
     * @param actor The actor performing the action.
     * @return null
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
