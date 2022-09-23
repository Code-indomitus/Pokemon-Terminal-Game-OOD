package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.items.Pokefruit;
import game.pokemons.AffectionManager;
import game.pokemons.Pokemon;

public class FeedPokemonAction extends Action {
    Item pokefruitToFeed;
    Pokemon pokemonToFeed;

    public FeedPokemonAction(Item pokefruitToFeed, Pokemon pokemonToFeed) {
        this.pokefruitToFeed = pokefruitToFeed;
        this.pokemonToFeed = pokemonToFeed;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(pokefruitToFeed);
        if (ElementsHelper.hasAnySimilarElements(pokefruitToFeed, pokemonToFeed.findCapabilitiesByType(Element.class))) {
            AffectionManager.getInstance().increaseAffection(pokemonToFeed, 20);
            return pokemonToFeed + " likes it! +20 affection points";
        }
        else {
            AffectionManager.getInstance().decreaseAffection(pokemonToFeed, 10);
            return pokemonToFeed + " dislikes it! -10 affection points";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " gives a " + pokefruitToFeed + " to " + pokemonToFeed;
    }
}
