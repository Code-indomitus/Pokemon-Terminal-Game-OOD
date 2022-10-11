package game.pokemoncenter;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
/**
 * An enter action to enter Pallet Town
 * Created by:
 * @author Shyam Kamalesh Borkar
 */
public class EnterPalletTownAction extends EnterAction {
    /**
     * EnterPalletTownAction constructor
     * @param mapToEnter map the actor needs to enter into
     * @param locationToEnter location the actor arrives at
     */
    public EnterPalletTownAction(GameMap mapToEnter, Location locationToEnter){
        super(mapToEnter, locationToEnter);
    }

    /**
     * description that will show up on the menu
     * @param actor The actor performing the action.
     * @return description
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " enters Pallet Town";
    }
}
