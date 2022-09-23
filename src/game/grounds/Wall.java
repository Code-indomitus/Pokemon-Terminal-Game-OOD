package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.Status;
/**
 * @author Shyam Kamalesh Borkar
 * Class for Wall (Ground)
 */
public class Wall extends Ground {
	/**
	 * Walll constructor
	 */
	public Wall() {
		super('#');
		this.addCapability(Status.CANNOT_BE_EXPANDED);
	}

	/**
	 * Overridden method to not allow actor to enter
	 * @param actor the Actor to check
	 * @return false
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}

	/**
	 * Overriden method to block throwable objects
	 * @return true
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
