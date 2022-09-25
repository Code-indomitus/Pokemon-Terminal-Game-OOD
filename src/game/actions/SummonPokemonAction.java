package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.items.Pokeball;
import game.pokemons.Pokemon;

/**
 * An Action to summon a Pokemon from a pokeball in the player's inventory.
 * Created by:
 * @author Shyam Kamalesh Borkar
 * Modified by: Arrtish Suthan
 */
public class SummonPokemonAction extends Action {

    /**
     * an attribute for the target pokeball containing the pokemon
     */
    Pokeball summonFromPokeball;

    /**
     * Constructor
     * @param summonFromPokeball pokeball in player's inventory containing a pokemon
     */
    public SummonPokemonAction(Pokeball summonFromPokeball) {
        this.summonFromPokeball = summonFromPokeball;
    }

    /** Class execute method. Firstly, the location of the player is stored. Then the pokemon from a pokeball is removed and stored in a local variable.
     * The method then checks for available locations to place the pokemon being summoned. If there is a vacant location from the actor, the pokemon is summoned there and the
     * respective pokeball is removed from the player's inventory
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string literal denoting if the pokemon was summoned or couldn't be summoned
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        Pokemon pokemonToBeSummoned = summonFromPokeball.getCaughtPokemon();
        for(Exit exit : location.getExits()) {
            if (!exit.getDestination().containsAnActor() && exit.getDestination().getGround().canActorEnter(pokemonToBeSummoned)) {
                exit.getDestination().addActor(pokemonToBeSummoned);
                actor.removeItemFromInventory(this.summonFromPokeball);
                return "I choose you " + pokemonToBeSummoned + ".";
            }
        }
        return pokemonToBeSummoned + " could not be summoned.";
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return string literal denoting the player summoning a pokemon from a pokeball
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Summon " + this.summonFromPokeball.getCaughtPokemon() + ".";
    }
}