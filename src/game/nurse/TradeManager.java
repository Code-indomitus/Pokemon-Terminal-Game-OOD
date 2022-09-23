package game.nurse;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.Status;
import game.elements.Element;
import game.items.Pokefruit;
import game.pokemons.Charmander;

/**
 * Class that handles that lists that all the trades that Nurse Joy can make
 * and counts the number of candy items in the player's inventory.
 * @author Shyam Kamalesh Borkar
 */
public class TradeManager {
    /**
     * Method that returns all the trade action that the player can
     * do in the game.
     * @return the list of trade actions
     */
    public static ActionList getTradeActions() {
        ActionList tradeActions = new ActionList();

        tradeActions.add(new TradeAction(new Charmander(), 5));
        tradeActions.add(new TradeAction(new Pokefruit(Element.FIRE), 1));
        tradeActions.add(new TradeAction(new Pokefruit(Element.WATER), 1));
        tradeActions.add(new TradeAction(new Pokefruit(Element.GRASS), 1));

        return tradeActions;
    }

    /**
     * method that returns the number of candy items that the player possesses
     * @param actor player whose inventory will be investigated
     * @return the number of candies in the player's invevntory
     */
    public static int getCandyCount(Actor actor) {
        int numOfCandies = 0;
        for (Item item : actor.getInventory()) {
            if (item.hasCapability(Status.TRADEABLE_CANDY)) {
                numOfCandies += 1;
            }
        }
        return numOfCandies;
    }
}
