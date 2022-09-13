package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;
import game.items.Pokefruit;
import game.pokemons.Bulbasaur;
import game.time.TimePerception;

public class Tree extends SpawningGround implements TimePerception {

    /**
     * Constructor.
     *
     */
    public Tree() {
        super('T', 0.15, 0.15, 1, Element.GRASS);
    }

    @Override
    public void spawnPokemon(Location spawnLocation) {
        spawnLocation.addActor(new Bulbasaur());
        this.registerInstance();

    }

    @Override
    public void dayEffect() {

    }

    @Override
    public void nightEffect() {

    }
}
