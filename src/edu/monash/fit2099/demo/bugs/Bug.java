package edu.monash.fit2099.demo.bugs;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.Map;
import java.util.TreeMap;

public class Bug extends Actor {
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();

    public Bug() {
        super("Bug", 'b', 50);
        behaviours.put(0, new CloneBehaviour());
        behaviours.put(1, new WanderBehaviour());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(Math.random() <= 0.1){
            map.removeActor(this);
            return new DoNothingAction();
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.CAPTURE_BUG)){ // it can only be captured if the Player holds Net that shares this capability
            actions.add(new CatchAction(this)); // allows the otherActor(i.e., Player) to catch "this" actor (i.e., Bug)
        }
        return actions;
    }
}
