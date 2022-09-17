package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.pokemons.Pokemon;

public class Pokeball extends Item {

    Pokemon caughtPokemon;

    public Pokeball() {
        super("Pokeball", '0', false);
    }

    public void assignCaughtPokemon(Pokemon caughtPokemon) {
        this.caughtPokemon = caughtPokemon;
    }

    public Pokemon getCaughtPokemon() {
        return caughtPokemon;
    }
}
