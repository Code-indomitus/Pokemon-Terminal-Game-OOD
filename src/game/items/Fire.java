package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.elements.Element;

public class Fire extends Item {

    int turn;
    /***
     * Fire Constructor.
     */
    public Fire() {
        super("Fire", 'v', false);
        this.addCapability(Element.FIRE);
        this.turn = 0;
    }

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
