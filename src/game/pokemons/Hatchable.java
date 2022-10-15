package game.pokemons;

/**
 * Interface for pokemons that are hatchable in the game
 * @author Eng Lim Ooi
 */
public interface Hatchable {
    /**
     * returns the time required for a specific pokemon to hatch
     * @return hatch time
     */
    int getHatchTime();
}
