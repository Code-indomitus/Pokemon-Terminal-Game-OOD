package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;
import game.items.Pokefruit;
import game.pokemons.Charmander;

public class Crater extends SpawningGround{

    public Crater() {
        super('O', 0.1, 0.25, 0, Element.FIRE);
    }

    @Override
    public void spawnPokemon(Location spawnLocation) {
        spawnLocation.addActor(new Charmander());
    }

}
