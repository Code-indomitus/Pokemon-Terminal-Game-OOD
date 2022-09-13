package game.pokemons;

import edu.monash.fit2099.engine.actors.Actor;

public abstract class Pokemon extends Actor {
    private final int MAX_POKEMON_HP = 100;
    public Pokemon(String pokemonName, char pokemonDisplayChar) {
        super(pokemonName, pokemonDisplayChar, 100);
    }
}
