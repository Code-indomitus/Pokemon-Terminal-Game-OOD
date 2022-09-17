package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.pokemons.Pokemon;

/**
 * @author Eng Lim Ooi
 * A class representing the Pokeball item.
 */
public class Pokeball extends Item {
    /**
     * The captured Pokemon.
     */
    Pokemon caughtPokemon;

    /**
     * Pokeball Constructor.
     */
    public Pokeball() {
        super("Pokeball", '0', false);
    }

    /**
     * Assign a Pokemon to the Pokeball when the Pokemon is successfully captured.
     * @param caughtPokemon Pokemon that has been caught
     */
    public void assignCaughtPokemon(Pokemon caughtPokemon) {
        this.caughtPokemon = caughtPokemon;
    }

    /**
     * Returns the Pokemon that has been caught.
     */
    public Pokemon getCaughtPokemon() {
        return caughtPokemon;
    }
}
