package game.pokemons;

import edu.monash.fit2099.engine.actors.Actor;
import game.Status;

public abstract class Pokemon extends Actor {
    private final int MAX_POKEMON_HP = 100;
    public Pokemon(String pokemonName, char pokemonDisplayChar) {
        super(pokemonName, pokemonDisplayChar, 100);
        this.addCapability(Status.CANNOT_ENTER_FLOOR);
    }
}
