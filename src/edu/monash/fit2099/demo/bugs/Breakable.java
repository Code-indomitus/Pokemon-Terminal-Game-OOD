package edu.monash.fit2099.demo.bugs;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;

public interface Breakable {
    String broken(Actor by, Location at);
}
