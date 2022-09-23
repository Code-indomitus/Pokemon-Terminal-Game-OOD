package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;
import game.items.Pokefruit;
import game.pokemons.Charmander;

/**
 * @author Shyam Kamalesh Borkar
 * Class for Crater (Spawning Ground)
 */
public class Crater extends SpawningGround{
    /**
     * Crater constructor
     */
    public Crater() {
        super('O', 0.1, 0.25, 0, Element.FIRE);
    }

    /**
     * Overridden method to spawn the pokemon, specific to the ground
     * @param spawnLocation
     */
    @Override
    public void spawnPokemon(Location spawnLocation) {
        spawnLocation.addActor(new Charmander());
    }

}
