package game.nonplayer;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.pokemons.AffectionManager;
import game.pokemons.Pokemon;

public class TrainerFeedAction extends Action {

    Trainer trainer;
    Item pokefruitToFeed;
    Pokemon pokemonToFeed;
    public TrainerFeedAction(Trainer trainer, Item pokefruitToFeed, Pokemon pokemonToFeed) {
        this.trainer = trainer;
        this.pokefruitToFeed = pokefruitToFeed;
        this.pokemonToFeed = pokemonToFeed;
    }


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

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
