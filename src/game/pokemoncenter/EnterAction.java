package game.pokemoncenter;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public abstract class EnterAction extends Action {

    GameMap mapToEnter;

    Location locationToEnter;

    public EnterAction(GameMap mapToEnter, Location locationToEnter){
        this.mapToEnter = mapToEnter;
        this.locationToEnter = locationToEnter;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        mapToEnter.addActor(actor, locationToEnter);
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
