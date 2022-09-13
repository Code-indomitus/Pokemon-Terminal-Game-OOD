package game.grounds;

import edu.monash.fit2099.demo.bugs.Bug;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.elements.Element;
import game.items.Pokefruit;

public abstract class SpawningGround extends Ground {
    private final double POKEMON_CHANCE;
    private final double POKEFRUIT_CHANCE;
    private final int NUM_SAME_GROUND_ELEMENT;
    private Element groundElement;

    public SpawningGround (char displayChar, double pokemonChance, double fruitChance, int numSameGroundElement, Element groundElement){
        super(displayChar);
        this.POKEFRUIT_CHANCE = fruitChance;
        this.POKEMON_CHANCE = pokemonChance;
        this.NUM_SAME_GROUND_ELEMENT = numSameGroundElement;
        this.groundElement = groundElement;
        this.addCapability(groundElement);
    }

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

    // abstract method to spawn the correct pokemon
    public abstract void spawnPokemon(Location spawnLocation);

    // abstract method to spawn the correct pokemon fruit type
    public void spawnPokefruit(Location spawnLocation) {
        spawnLocation.addItem(new Pokefruit(getGroundElement()));
    }

    public Element getGroundElement() {
        return this.groundElement;
    }



}
