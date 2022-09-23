package game.grounds;

import edu.monash.fit2099.demo.bugs.Bug;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;
import game.items.Pokefruit;
/**
 * @author Shyam Kamalesh Borkar
 * Abstract Class for Spawning Ground (Ground)
 */
public abstract class SpawningGround extends Ground {
    /**
     * chance to spawn the pokemon
     */
    private final double POKEMON_CHANCE;
    /**
     * chance to spawn the pokefruit
     */
    private final double POKEFRUIT_CHANCE;
    /**
     * number of same ground elements in the surrounding required
     */
    private final int NUM_SAME_GROUND_ELEMENT;
    /**
     * element of the spawning ground
     */
    private Element groundElement;

    /**
     * constructor of spawning ground
     * @param displayChar ground display char
     * @param pokemonChance chance to spawn the pokemon
     * @param fruitChance chance to spawn the pokefruit
     * @param numSameGroundElement number of same ground elements in the surrounding required
     * @param groundElement element of the spawning ground
     */
    public SpawningGround (char displayChar, double pokemonChance, double fruitChance, int numSameGroundElement, Element groundElement){
        super(displayChar);
        this.POKEFRUIT_CHANCE = fruitChance;
        this.POKEMON_CHANCE = pokemonChance;
        this.NUM_SAME_GROUND_ELEMENT = numSameGroundElement;
        this.groundElement = groundElement;
        this.addCapability(groundElement);
    }

    /**
     * Overridden tick method to decide if a pokemon is to be spawned and/or a pokefruit
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        int sameElementGroundCount = 0;
        for(Exit exit : location.getExits()) {
            if (exit.getDestination().getGround().hasCapability(groundElement)) {
                sameElementGroundCount += 1;
            }
        }
        // Spawn Pokemon
        if ((Math.random() <= POKEMON_CHANCE) && (!location.containsAnActor()) && (sameElementGroundCount >= NUM_SAME_GROUND_ELEMENT)) {
            this.spawnPokemon(location);
        }
        // Spawn Pokefruit
        if (Math.random() <= POKEFRUIT_CHANCE) {
            this.spawnPokefruit(location);
        }
    }

    /**
     * abstract method to spawn the correct Pokemon
     */
    public abstract void spawnPokemon(Location spawnLocation);

    /**
     * abstract method to spawn the correct Pokemon fruit type
     * @param spawnLocation location that the Pokefruit spawned on
     */
    public void spawnPokefruit(Location spawnLocation) {
        spawnLocation.addItem(new Pokefruit(getGroundElement()));
    }

    /**
     * get the element of the ground
     * @return element of the ground
     */
    public Element getGroundElement() {
        return this.groundElement;
    }



}
