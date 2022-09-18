package game.pokemons;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.HashMap;
import java.util.Map;

/**
 * Affection Manager
 * <p>
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class AffectionManager {

    /**
     * Singleton instance (the one and only for a whole game).
     */
    private static AffectionManager instance;
    /**
     * Map of Pokemons and their AP
     */
    private final Map<Pokemon, Integer> affectionPoints;

    /**
     * We assume there's only one trainer in this manager.
     * Think about how will you extend it.
     */
    private Actor trainer;

    /**
     * private singleton constructor
     */
    private AffectionManager() {
        this.affectionPoints = new HashMap<>();
    }

    /**
     * Access single instance publicly
     *
     * @return this instance
     */
    public static AffectionManager getInstance() {
        if (instance == null) {
            instance = new AffectionManager();
        }
        return instance;
    }

    /**
     * Add a trainer to this class's attribute. Assume there's only one trainer at a time.
     *
     * @param trainer the actor instance
     */
    public void registerTrainer(Actor trainer) {
        this.trainer = trainer;
    }

    /**
     * Get the trainer.
     */
    public Actor getTrainer() {
        return this.trainer;
    }

    /**
     * Add Pokemon to the collection. By default, it has 0 affection point. Ideally, you'll register all instantiated Pokemon
     *
     * @param pokemon
     */
    public void registerPokemon(Pokemon pokemon) {
        affectionPoints.put(pokemon, 0);
    }

    /**
     * Get the affection point by using the pokemon instance as the key.
     *
     * @param pokemon Pokemon instance
     * @return integer of affection point.
     */
    public int getAffectionPoint(Pokemon pokemon) {
        return affectionPoints.get(pokemon);
    }

    /**
     * Useful method to search a pokemon by using Actor instance.
     *
     * @param actor general actor instance
     * @return the Pokemon instance.
     */
    private Pokemon findPokemon(Actor actor) {
        for (Pokemon pokemon : affectionPoints.keySet()) {
            if (pokemon.equals(actor)) {
                return pokemon;
            }
        }
        return null;
    }

    /**
     * Increase the affection. Work on both cases when there's a Pokemon,
     * or when it doesn't exist in the collection.
     *
     * @param pokemon Pokemon instance.
     * @param point positive affection modifier
     * @return custom message to be printed by Display instance later.
     */
    public String increaseAffection(Pokemon pokemon, int point) {
        if (!affectionPoints.containsKey(pokemon)) {
            this.registerPokemon(pokemon);
        }
        int affectionPoint = affectionPoints.get(pokemon);
        affectionPoint += point;
        if (affectionPoint > 100) {
            affectionPoint = 100;
        }
        affectionPoints.put(pokemon, affectionPoint);

        return "";
    }

    /**
     * Decrease the affection level of the . Work on both cases when it is
     *
     * @param pokemon Pokemon instance.
     * @param point positive affection modifier (to be subtracted later)
     * @return custom message to be printed by Display instance later.
     */
    public String decreaseAffection(Pokemon pokemon, int point) {
        if (!affectionPoints.containsKey(pokemon)) {
            this.registerPokemon(pokemon);
        }
        int affectionPoint = affectionPoints.get(pokemon);
        affectionPoint -= point;
        affectionPoints.put(pokemon, affectionPoint);

        return "";
    }

}
