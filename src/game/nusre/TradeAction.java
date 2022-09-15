package game.nusre;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.items.Candy;
import game.items.Pokeball;
import game.pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class TradeAction extends Action {
    Tradeable itemToBeTraded;
    int numberOfCandies;

    public TradeAction(Tradeable itemToBeTraded, int numberOfCandies) {
        this.itemToBeTraded = itemToBeTraded;
        this.numberOfCandies = numberOfCandies;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (TradeManager.getCandyCount(actor) < numberOfCandies) {
            return actor + " has insufficient balance to get " + itemToBeTraded + ".";
        }
        if (itemToBeTraded.isPokemon()) {
            Pokeball pokeball = new Pokeball();
            pokeball.assignCaughtPokemon((Pokemon) itemToBeTraded);
            actor.addItemToInventory(pokeball);
        }
        else {
            actor.addItemToInventory((Item) itemToBeTraded);
        }

        // Remove the candies from the player's inventory based on the trade made
        List<Item> candies = new ArrayList<>();
        for (Item item : actor.getInventory()) {
            if (item.hasCapability(Status.TRADEABLE_CANDY)) {
                candies.add(item);
            }
        }
        for (int i = 0; i < this.numberOfCandies; i++) {
            actor.removeItemFromInventory(candies.get(i));
        }

        return actor + " trades " + numberOfCandies + " candies for a " + itemToBeTraded + ".";
    }


    @Override
    public String menuDescription(Actor actor) {
        return actor + " trades " + itemToBeTraded + " with " + numberOfCandies + " candies.";
    }
}
