package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Candy;
import game.items.Pokeball;
import game.pokemons.AffectionManager;
import game.pokemons.Pokemon;

/**
 * An Action to catch a Pokemon actor.
 * Created by:
 * @author Shyam Kamalesh Borkar
 * Modified by: Arrtish Suthan
 */
public class CatchPokemonAction extends Action {

    /**
     * class instance denoting the pokemon being targeted by the action
     */
    Pokemon pokemonToBeCaught;

    /**
     *Constructor
     * @param pokemonToBeCaught target pokemon the actor is catching
     */
    public CatchPokemonAction(Pokemon pokemonToBeCaught) {
        this.pokemonToBeCaught = pokemonToBeCaught;
    }

    /**
     * Class execute method. First the AP of the targeted pokemon is recorded, If the AP is lower than the requirements,
     * the pokemon is not caught and the AP of the pokemon is reduced. If the AP is high enough, a Pokeball instance is made and the target pokemon is assigned to the Pokeball.
     * The target pokemon is removed from the map and candy is spawned in the place where the target was.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string literal denoting the pokemon is caught if the conditions are met, or string literal denoting the pokemon is not  caught if
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (AffectionManager.getInstance().getAffectionPoint(this.pokemonToBeCaught) < 50 ) {
            AffectionManager.getInstance().decreaseAffection(this.pokemonToBeCaught, 10);
            return pokemonToBeCaught + " could not be captured.";
        }

        Pokeball newPokeball = new Pokeball();
        newPokeball.assignCaughtPokemon(pokemonToBeCaught);
        actor.addItemToInventory(newPokeball);
        // Spawn candy when pokemon is captured.
        map.locationOf(pokemonToBeCaught).addItem(new Candy());
        map.removeActor(pokemonToBeCaught);

        return pokemonToBeCaught + " has been successfully captured.";
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return a menu option in the player's menu list
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Catch " + pokemonToBeCaught + ".";
    }
}
