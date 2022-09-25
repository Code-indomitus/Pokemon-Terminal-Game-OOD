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

/**
 * An Action to feed a Pokemon.
 * Created by:
 * @author Shyam Kamalesh Borkar
 * Modified by: Arrtish Suthan
 */
public class FeedPokemonAction extends Action {
    /**
     * an attribute for the pokefruit instance from the player's inventory used for feeding
     */
    Item pokefruitToFeed;
    /**
     * an attribute for the target pokemon actor to feed
     */
    Pokemon pokemonToFeed;

    /**
     * Constructor
     * @param pokefruitToFeed fruit being feed to the pokemon
     * @param pokemonToFeed target pokemon being fed
     */
    public FeedPokemonAction(Item pokefruitToFeed, Pokemon pokemonToFeed) {
        this.pokefruitToFeed = pokefruitToFeed;
        this.pokemonToFeed = pokemonToFeed;
    }

    /** Class execute method. First, the respective fruit used for the feeding action is removed form the player's inventory.
     * Then the element of the fruit is checked against the pokemon's element . If the elements match, the pokemon's AP value increases by 20 points.
     * If the elements do not match, the pokemon's AP value decreases by 10 points.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string literal denoting if the pokemon liked or disliked the fed action and its respective AP value change
     */
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

    /**
     *
     * @param actor The actor performing the action.
     * @return string literal denoting the player feeding a pokemon a fruit
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " gives a " + pokefruitToFeed + " to " + pokemonToFeed;
    }
}
