package game.nonplayer;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.behaviours.Behaviour;

import java.util.List;

/**
 * Behaviour class for trainers to pick up items
 *
 * Created by:
 * @author Arrtish Suthan
 */
public class PickUpBehaviour implements Behaviour {

    Trainer trainer;

    /**
     * Constructor
     * @param trainer non player trainer that will pick up item
     */
    public PickUpBehaviour(Trainer trainer) {
        this.trainer = trainer;
    }

    /**
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return action for trainer to pick up item
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location trainerLocation = map.locationOf(this.trainer);
        List<Item> itemsAtLoction = trainerLocation.getItems();
        if (itemsAtLoction.size() > 0) {
            Item itemToAdd = itemsAtLoction.get(0);
            trainerLocation.removeItem(itemToAdd);
            return new TrainerPickItemAction(this.trainer, itemToAdd);
        }
        return null;
    }
}
