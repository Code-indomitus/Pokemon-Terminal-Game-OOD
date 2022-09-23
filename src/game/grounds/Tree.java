package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.items.Candy;
import game.items.Pokefruit;
import game.pokemons.Bulbasaur;
import game.time.TimePerception;
import game.time.TimePerceptionManager;

import java.util.Random;
/**
 * @author Shyam Kamalesh Borkar
 * Class for Tree (Spawning Ground)
 */
public class Tree extends SpawningGround implements TimePerception {

    Location location;
    /***
     * Random class used to randomly expand Tree or Hay
     */
    private final Random randomGenerator = new Random();

    /**
     * Tree Constructor
     */
    public Tree() {
        super('T', 0.15, 0.15, 1, Element.GRASS);
        this.registerInstance();
    }
    /**
     * Overridden tick method to get the location of the ground and call spawning ground tick
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        this.location = location;
        super.tick(location);
    }

    /**
     * Overridden method to spawn the ground specific pokemon
     * @param spawnLocation location to spawn the pokemon
     */
    @Override
    public void spawnPokemon(Location spawnLocation) {
        spawnLocation.addActor(new Bulbasaur());
    }
    /**
     * Dayeffect of tree class
     */
    @Override
    public void dayEffect() {
        if (Math.random() <= 0.05 && this.location != null) {
            this.location.addItem(new Candy());
        }
    }
    /**
     * Nighteffect of tree class
     */
    @Override
    public void nightEffect() {
        if (Math.random() <= 0.1 && this.location != null) {
            boolean treeExpander = randomGenerator.nextBoolean();
            for(Exit exit : this.location.getExits()) {
                Ground surroundingGround = exit.getDestination().getGround();
                if (!ElementsHelper.hasAnySimilarElements(surroundingGround, this.findCapabilitiesByType(Element.class)) && !surroundingGround.hasCapability(Status.CANNOT_BE_EXPANDED)) {
                    if (treeExpander) {
                        exit.getDestination().setGround(new Tree());
                    }
                    else {
                        exit.getDestination().setGround(new Hay());
                    }

                }
            }
        }
    }
}
