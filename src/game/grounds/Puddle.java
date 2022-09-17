package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.time.TimePerception;
import game.time.TimePerceptionManager;

public class Puddle extends Ground implements TimePerception {

    // Location of the ground object on the map
    Location location;

    /**
     * Constructor.
     *
     */
    public Puddle() {
        super('~');
        this.addCapability(Element.WATER);
        this.registerInstance();
    }

    @Override
    public void tick(Location location) {
        this.location = location;
    }

    @Override
    public void dayEffect() {
        if (Math.random() <= 0.1 && this.location != null){
            this.location.setGround(new Dirt());
            TimePerceptionManager.getInstance().cleanUp(this);
        }
    }

    @Override
    public void nightEffect() {
        if (Math.random() <= 0.1 && this.location != null) {
            for(Exit exit : this.location.getExits()) {
                Ground surroundingGround = exit.getDestination().getGround();
                if (!ElementsHelper.hasAnySimilarElements(surroundingGround, this.findCapabilitiesByType(Element.class)) && !surroundingGround.hasCapability(Status.CANNOT_BE_EXPANDED)) {
                    exit.getDestination().setGround(new Puddle());
                }
            }
        }
    }
}

