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

public class Tree extends SpawningGround implements TimePerception {

    Location location;

    private final Random randomGenerator = new Random();

    /**
     * Constructor.
     *
     */
    public Tree() {
        super('T', 0.15, 0.15, 1, Element.GRASS);
        this.registerInstance();
    }

    @Override
    public void tick(Location location) {
        this.location = location;
        super.tick(location);
    }

    @Override
    public void spawnPokemon(Location spawnLocation) {
        spawnLocation.addActor(new Bulbasaur());
    }

    @Override
    public void dayEffect() {
        if (Math.random() <= 0.05 && this.location != null) {
            this.location.addItem(new Candy());
        }
    }

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
