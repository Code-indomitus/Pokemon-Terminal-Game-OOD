package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.Status;
import game.pokemons.Pokemon;

/**
 * A class that represents the floor inside a building.
 * Created by: Shyam Kamalesh Borkar
 */
public class Floor extends Ground {
	/**
	 * Floor constructor
	 */
	public Floor() {
		super('_');
		this.addCapability(Status.CANNOT_BE_EXPANDED);
	}

	/**
	 * Overridden method to stop actors that cannot enter floors
	 * @param actor the Actor to check
	 * @return
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.hasCapability(Status.CANNOT_ENTER_FLOOR)) {
			return false;
		}
		else {
			return true;
		}
	}
}
