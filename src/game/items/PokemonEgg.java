package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.pokemons.Hatchable;
import game.pokemons.Pokemon;

/**
 * A class for a Pokemon egg item
 * @author Eng Lim Ooi
 *
 */
public class PokemonEgg extends Item {
    /**
     * Pokemon to be hatched
     */
    Hatchable pokemonToHatch;

    /**
     * time taken for pokemon to hatch
     */
    int hatchTime;

    /***
     * Pokemon Egg Constructor.
     */
    public PokemonEgg(Hatchable pokemonToHatch) {
        super("Egg", 'g', true);
        this.pokemonToHatch = pokemonToHatch;
        this.hatchTime = 0;
    }

    /**
     * hatch the pokemon on to the ground or surroundings if it is on an
     * incubator ground and it has exceeded its required hatch time
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation) {
        if (currentLocation.getGround().hasCapability(Status.INCUBATE)) {
            this.hatchTime += 1;
        }

        if (this.hatchTime >= pokemonToHatch.getHatchTime()) {
            if (currentLocation.containsAnActor()) {
                for (Exit exit : currentLocation.getExits()) {
                    if (!exit.getDestination().containsAnActor()) {
                        exit.getDestination().addActor((Pokemon) pokemonToHatch);
                        currentLocation.removeItem(this);
                        return;
                    }
                }
            }
            else {
                currentLocation.addActor((Pokemon) pokemonToHatch);
                currentLocation.removeItem(this);
            }
        }

    }
}
