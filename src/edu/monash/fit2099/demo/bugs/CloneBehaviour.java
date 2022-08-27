package edu.monash.fit2099.demo.bugs;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;

public class CloneBehaviour extends Action implements Behaviour {
    private int counter;

    public CloneBehaviour() {
        counter = 0;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        counter += 1;
        return counter % 3 == 0 ? this : null;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        for(Exit exit : map.locationOf(actor).getExits()){
            if(!exit.getDestination().containsAnActor()){
                exit.getDestination().addActor(new Bug());
                return actor + " successfully clones itself";
            }
        };
        return actor + " is unable to clone";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " clones itself.";
    }
}
