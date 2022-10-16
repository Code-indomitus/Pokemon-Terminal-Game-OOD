package game.nonplayer;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.pokemons.AffectionManager;
import game.pokemons.Pokemon;

/**
 * Class for the Feed action that a trainer will have
 * Created by:
 * @author Arrtish Suthan and Shyam Kamalesh Borkar
 */
public class TrainerFeedAction extends Action {
    /**
     * the trainer that does the feeding
     */
    Trainer trainer;

    /**
     * pokefruit that is fed to pokemon
     */
    Item pokefruitToFeed;

    /**
     * pokemon that is fed
     */
    Pokemon pokemonToFeed;

    /**
     * TrainerFeedAction Constructor
     * @param trainer the trainer that does the feeding
     * @param pokefruitToFeed pokefruit that is fed to pokemon
     * @param pokemonToFeed pokemon that is fed
     */
    public TrainerFeedAction(Trainer trainer, Item pokefruitToFeed, Pokemon pokemonToFeed) {
        this.trainer = trainer;
        this.pokefruitToFeed = pokefruitToFeed;
        this.pokemonToFeed = pokemonToFeed;
    }

    /**
     * Check if pokemon and pokefruit have same element make changes to AP accordingly and remove the fruit
     * from the trainers inventory
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        this.trainer.removeItemFromInventory(pokefruitToFeed);
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
     * there is no menu description
     * @param actor The actor performing the action.
     * @return null
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
