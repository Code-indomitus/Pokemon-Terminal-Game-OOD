package game.pokemons;

import edu.monash.fit2099.demo.mars.items.Stick;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.EvolveAction;
import game.behaviours.EvolveBehaviour;

public abstract class EvolvingPokemon extends Pokemon{

    protected Pokemon evolvedPokemon;

    int turnsSurvived;
    /**
     * constructor
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

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        this.turnsSurvived += 1;
        return super.playTurn(actions, lastAction, map, display);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (AffectionManager.getInstance().getAffectionPoint(this)  == 100) {
            actions.add(new EvolveAction(this));
        }
        return actions;
    }

    public boolean shouldEvolve() {
        if (this.turnsSurvived >= 20) {
            return true;
        }
        else {
            return false;
        }
    }

    public abstract Pokemon getEvolvedPokemon();

}