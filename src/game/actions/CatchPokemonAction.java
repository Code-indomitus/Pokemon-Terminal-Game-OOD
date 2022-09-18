package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Pokeball;
import game.pokemons.AffectionManager;
import game.pokemons.Pokemon;

public class CatchPokemonAction extends Action {

    Pokemon pokemonToBeCaught;

    public CatchPokemonAction(Pokemon pokemonToBeCaught) {
        this.pokemonToBeCaught = pokemonToBeCaught;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (AffectionManager.getInstance().getAffectionPoint(this.pokemonToBeCaught) < 50 ) {
            AffectionManager.getInstance().decreaseAffection(this.pokemonToBeCaught, 10);
            return pokemonToBeCaught + " could not be captured.";
        }

        Pokeball newPokeball = new Pokeball();
        newPokeball.assignCaughtPokemon(pokemonToBeCaught);
        actor.addItemToInventory(newPokeball);
        map.removeActor(pokemonToBeCaught);

        return pokemonToBeCaught + " has been successfully captured.";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Catch " + pokemonToBeCaught + ".";
    }
}
