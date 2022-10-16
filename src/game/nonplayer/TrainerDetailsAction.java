package game.nonplayer;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Action to view details of a trainer
 * Created by:
 * @author Shyam Kamalesh Borkar
 */
public class TrainerDetailsAction extends Action {

    /**
     * trainer whose details is to be viewed
     */
    Trainer trainer;

    /**
     * TrainerDetailsAction Constructor
     * @param trainer trainer whose details is to be viewed
     */
    public TrainerDetailsAction(Trainer trainer) {
        this.trainer = trainer;
    }

    /**
     * return the string of the trainer's details
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location trainerLocation = map.locationOf(this.trainer);
        String result = this.trainer + " | " + trainerLocation.x() + "," + trainerLocation.y() + " | inventory: " + this.trainer.getInventory();
        return result;
    }

    /**
     * menu description to view trainer's details
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "View Trainer " + this.trainer + " details";
    }
}
