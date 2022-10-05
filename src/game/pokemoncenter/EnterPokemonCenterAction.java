package game.pokemoncenter;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class EnterPokemonCenterAction extends EnterAction {

    public EnterPokemonCenterAction(GameMap mapToEnter, Location locationToEnter){
        super(mapToEnter, locationToEnter);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " enters Pokemon Center";
    }
}
