package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.time.TimePerception;
import game.time.TimePerceptionManager;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Shyam Kamalesh Borkar
 * Class for Lava (Ground)
 */
public class Lava extends Ground implements TimePerception {

    /**
     * Location of the ground object on the map
     */
    Location location;

    /**
     * Lava Constructor.
     */
    public Lava() {
        super('^');
        this.addCapability(Element.FIRE);
        this.registerInstance();
    }

    /**
     * Overridden tick method to get the location of the ground
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        this.location = location;
    }
    /**
     * Dayeffect of Lava class
     */
    @Override
    public void dayEffect() {
        if (Math.random() <= 0.1 && this.location != null) {
            for(Exit exit : this.location.getExits()) {
                Ground surroundingGround = exit.getDestination().getGround();
                if (!ElementsHelper.hasAnySimilarElements(surroundingGround, this.findCapabilitiesByType(Element.class)) && !surroundingGround.hasCapability(Status.CANNOT_BE_EXPANDED)) {
                    exit.getDestination().setGround(new Lava());
                }
            }
        }
    }
    /**
     * Nighteffect of Lava class
     */
    @Override
    public void nightEffect() {
        if ((Math.random() <= 0.1 && this.location != null) && !location.containsAnActor()){
            this.location.setGround(new Dirt());
            TimePerceptionManager.getInstance().cleanUp(this);
        }
    }
}
