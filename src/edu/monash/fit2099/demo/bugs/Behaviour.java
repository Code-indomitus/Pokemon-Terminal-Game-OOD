package edu.monash.fit2099.demo.bugs;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public interface Behaviour {
    Action getAction(Actor actor, GameMap map);
}
