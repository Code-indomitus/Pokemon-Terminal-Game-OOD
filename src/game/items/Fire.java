package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.elements.Element;
/**
 * Fire item for charizard's fire spin attack
 * Created by:
 * @author Shyam Kamalesh Borkar
 */
public class Fire extends Item {
    /**
     * Turns the fire item has been on the map
     */
    int turn;

    /***
     * Fire Constructor.
     */
    public Fire() {
        super("Fire", 'v', false);
        this.addCapability(Element.FIRE);
        this.turn = 0;
    }

    /**
     * tick method to increment turn and hurt any pokemon on the item
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation) {
        if (currentLocation.containsAnActor()) {
            Actor actor = currentLocation.getActor();
            if (!actor.hasCapability(Element.FIRE) && !actor.hasCapability(Status.IMMUNE)) {
                actor.hurt(10);
            }
        }
        this.turn += 1;
        if (this.turn >= 2) {
            currentLocation.removeItem(this);
        }
    }
}
