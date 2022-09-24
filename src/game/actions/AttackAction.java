package game.actions;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * An Action to attack another Actor.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Arrtish Suthan, Shyam Kamalesh Borkar
 */
public class AttackAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    protected Actor target;

    /**
     * The direction of incoming attack.
     */
    protected String direction;

    /**
     * Random number generator
     */
    protected Random rand = new Random();

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     */
    public AttackAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Class execute method. First, the attacking pokemon's weapons are called from its inventory. Then, a random int value is generated
     * to determine if the pokemon hit. If the random number is lesser than the weapon's chance to hit, the pokemon hits, else it misses and a string is printed.
     * When the attacker hits a target, the target pokemon is hurt by the weapon's damage and the target is checked if the pokemon is conscious or not.
     * If the pokemon is not conscious, the cleanup methods are called to remove the target from thee gamemap, and to drop its respective items.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the operation
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        Weapon weapon = actor.getWeapon();

        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        int damage = weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);
        if (!target.isConscious()) {
            ActionList dropActions = new ActionList();
            // drop all items
            for (Item item : target.getInventory())
                dropActions.add(item.getDropAction(actor));
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove actor
            map.removeActor(target);
            result += System.lineSeparator() + target + " is killed.";
        }

        return result;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return a printed string that denotes the attacker attacking a target in a given direction
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction;
    }
}
