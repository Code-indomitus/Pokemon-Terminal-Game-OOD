package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;
import game.items.Pokefruit;
import game.pokemons.Squirtle;

public class Waterfall extends SpawningGround{

    public Waterfall() {
        super('W', 0.2, 0.2, 2, Element.WATER);
    }

    @Override
    public void spawnPokemon(Location spawnLocation) {
        spawnLocation.addActor(new Squirtle());
    }
}
