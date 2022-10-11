package game.pokemons;

import edu.monash.fit2099.demo.mars.items.Stick;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.EvolveAction;
import game.behaviours.EvolveBehaviour;
/**
 * Class representing the Pokemon parent class for evolving pokemon
 *
 * Created by: Shyam Kamalesh Borkar
 */
public abstract class EvolvingPokemon extends Pokemon{

    /**
     * The evolved version of the pokemon
     */
    protected Pokemon evolvedPokemon;

    /**
     * turns the pokemon has survived
     */
    int turnsSurvived;

    /**
     * Evolving pokemon constructor
     *
     * @param pokemonName   name of the pokemon object
     * @param pokemonDisplayChar character used to denote the presence of the pokemon on the map
     * @param hitPoints the maximum hp of the pokemon
     */
    public EvolvingPokemon(String pokemonName, char pokemonDisplayChar, int hitPoints) {
        super(pokemonName, pokemonDisplayChar, hitPoints);
        super.behaviours.put(1, new EvolveBehaviour(this));
        this.turnsSurvived = 0;
    }

    /**
     * Playturn of evovling pokemon - increase the turns survived
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        this.turnsSurvived += 1;
        return super.playTurn(actions, lastAction, map, display);
    }

    /**
     * add evolve action if ap is high enough to allowable actions
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (AffectionManager.getInstance().getAffectionPoint(this)  == 100) {
            actions.add(new EvolveAction(this));
        }
        return actions;
    }

    /**
     * decides if a pokemon should evolve or not based on the turns survived
     * @return
     */
    public boolean shouldEvolve() {
        if (this.turnsSurvived >= 20) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * abstract method to get the evolved version of the pokemon
     * @return evovled pokemon
     */
    public abstract Pokemon getEvolvedPokemon();

}
