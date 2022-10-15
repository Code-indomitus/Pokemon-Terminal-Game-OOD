package game.nonplayer;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Action to allow non player trainers to pick up items
 * Created by:
 * @author Arrtish Suthan
 */
public class TrainerPickItemAction extends Action {

    Trainer trainer;

    Item item;

    /**
     * Constructor
     * @param trainer non player trainer picking item
     * @param item item to be picked
     */
    public TrainerPickItemAction(Trainer trainer, Item item) {
        this.trainer = trainer;
        this.item = item;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return null
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        this.trainer.addItemToInventory(this.item);
        return null;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return NULL
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}