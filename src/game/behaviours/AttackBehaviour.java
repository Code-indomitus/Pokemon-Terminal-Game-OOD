package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.AttackAction;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.pokemons.Charmander;
import game.pokemons.Squirtle;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class AttackBehaviour implements Behaviour {

    private Actor attackingActor;

    public AttackBehaviour(Actor attackingActor) {
        this.attackingActor = attackingActor;
    }

    /**
     *  HINT: develop a logic to check surrounding, check elements, and return an action to attack that opponent.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor() && !destination.getActor().hasCapability(Status.IMMUNE)) {
                if (!ElementsHelper.hasAnySimilarElements(destination.getActor(), attackingActor.findCapabilitiesByType(Element.class))){
                    return new AttackAction(destination.getActor(),"there");// behaviour will stop here.
                }
            }
        }


        return null; // go to next behaviour
    }
}
