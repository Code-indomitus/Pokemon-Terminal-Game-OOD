package edu.monash.fit2099.demo.bugs;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class CatchAction extends Action {
    private Actor targetActor;

    public CatchAction(Actor targetActor) {
        this.targetActor = targetActor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(targetActor);
        return actor + " captured a "+ targetActor;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " catches a " + targetActor;
    }
}
