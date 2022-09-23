package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;
import game.items.Pokefruit;
import game.pokemons.Squirtle;
/**
 * @author Shyam Kamalesh Borkar
 * Class for Waterfall (Spawning Ground)
 */
public class Waterfall extends SpawningGround{
    /**
     * Waterfall constructor
     */
    public Waterfall() {
        super('W', 0.2, 0.2, 2, Element.WATER);
    }
    /**
     * Overridden method to spawn the ground specific pokemon
     * @param spawnLocation location to spawn the pokemon
     */
    @Override
    public void spawnPokemon(Location spawnLocation) {
        spawnLocation.addActor(new Squirtle());
    }
}
