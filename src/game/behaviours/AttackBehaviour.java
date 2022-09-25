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
 * A class that figures out an Attack action that will make an actor attack a valid target
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Arrtish Suthan, Shyam Kamalesh Borkar
 *
 */
public class AttackBehaviour implements Behaviour {

    /**
     * attackbehaviour attribute to store the attacking actor
     */
    private Actor attackingActor;

    /**
     *
     * @param attackingActor actor carrying out the attack
     */
    public AttackBehaviour(Actor attackingActor) {
        this.attackingActor = attackingActor;
    }

    /**
     * method to check the current pokemon's surrounding's for a valid target to attack. If there is a valid target, the AttackAction class is called.
     * @param actor the current actor checking its surroundings
     * @param map the GameMap containing the Actor
     * @return an attack action if the conditions are met, or null if the conditions aren't met
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
