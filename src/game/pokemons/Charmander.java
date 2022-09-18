package game.pokemons;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.elements.Element;
import game.nusre.Tradeable;
import game.weapons.Ember;

/**
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class Charmander extends Pokemon implements Tradeable, TimePerception {

    private BackupWeapons pokemonBackupWeapons;
    /**
     * Constructor.
     */
    public Charmander() {
        super("Charmander", 'c');
        this.addCapability(Element.FIRE);
        this.pokemonBackupWeapons = new BackupWeapons(new Ember("Ember",'|',20,"sparks", 90));
        registerInstance();

    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!this.isConscious()){
            TimePerceptionManager.getInstance().cleanUp(this);
            AffectionManager.getInstance().cleanUp(this);
            map.removeActor(this);
        }
        this.toggleWeapon(this, map);
        return super.playTurn(actions, lastAction, map, display);
    }

    /**
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
       return new ActionList();
    }


//    /**
//     * @param isEquipping FIXME: develop a logic to toggle weapon (put a selected weapon to the inventory - used!);
//     */
public void toggleWeapon(Pokemon pokemon, GameMap map) {
    boolean containsSpecial = this.getInventory().contains(this.pokemonBackupWeapons.getBackupWeapon());

    if (pokemon.hasCapability(Element.FIRE) && map.locationOf(pokemon).getGround().hasCapability(Element.FIRE)){
        if(!containsSpecial){
            this.addItemToInventory(this.pokemonBackupWeapons.getBackupWeapon());
        }
    }
    else{
        if (containsSpecial) {
            this.removeItemFromInventory(this.pokemonBackupWeapons.getBackupWeapon());
        }
    }
}


    @Override
    public boolean isPokemon() {
        return true;
    }

    @Override
    public void dayEffect() {
        heal(10);
    }

    @Override
    public void nightEffect() {
        hurt(10);
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "scratch");
    }

}