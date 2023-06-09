package edu.monash.fit2099.demo.bugs;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Crate extends Ground implements Breakable {
    public Crate() {
        super('=');
    }

    @Override
    public String broken(Actor by, Location at) {
        Actor actor = by;
        Location location = at;
        String result = "";
        if(Math.random() <= 0.75) {
            location.setGround(new Dirt());
            result += actor + " breaks the crate successfully! ";
            if (Math.random() <= 0.5) {
                location.addItem(new Net());
                result += "And a bug net is dropped!";
            } else {
                result += "But no bug net is dropped.";
            }
        }
        else {
            result += actor + " fails to break the crate.";
        }
        return result;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        return new ActionList(new BreakAction(this, location, direction));
    }

    @Override
    public String toString() {
        return "Crate";
    }
}
