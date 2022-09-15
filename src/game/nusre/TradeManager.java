package game.nusre;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.Status;
import game.actions.AttackAction;
import game.elements.Element;
import game.items.Candy;
import game.items.Pokefruit;
import game.pokemons.Charmander;

public class TradeManager {

    public static ActionList getTradeActions(Actor actor) {
        ActionList tradeActions = new ActionList();

        tradeActions.add(new TradeAction(new Charmander(), 5));
        tradeActions.add(new TradeAction(new Pokefruit(Element.FIRE), 1));
        tradeActions.add(new TradeAction(new Pokefruit(Element.WATER), 1));
        tradeActions.add(new TradeAction(new Pokefruit(Element.GRASS), 1));

        return tradeActions;
    }

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
