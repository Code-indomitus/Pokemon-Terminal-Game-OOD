package edu.monash.fit2099.demo.bugs;

import edu.monash.fit2099.engine.items.Item;

public class Net extends Item {
    public Net() {
        super("Bug net", 'P', true);
        this.addCapability(Status.CAPTURE_BUG);
    }
}
