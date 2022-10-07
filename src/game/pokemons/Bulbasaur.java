package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
import game.elements.Element;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.weapons.VineWhip;


/**
 * Class representing the Bylbasaur pokemon daughter class
 *
 * Created by:
 * @author Shyam Kamalesh Borkar
 * Modified by: Arrtish Suthan
 *
 */
public class Bulbasaur extends Pokemon implements TimePerception, Hatchable {

    /**
     * pokemonBackupWeapons attribute made from BackupWeapons class
     */
    private BackupWeapons pokemonBackupWeapons;

    /**
     * Constructor
     */
    public Bulbasaur() {
        super("Bulbasaur", 'b');
        this.addCapability(Element.GRASS);
        this.addCapability(Status.CATCHABLE);
        this.pokemonBackupWeapons = new BackupWeapons(new VineWhip());
        registerInstance();
    }

    /**
     * By using behaviour loops, it will decide what will be the next action automatically.
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        this.toggleWeapon(this, map);
        return super.playTurn(actions, lastAction, map, display);
    }


    /**
     * Method to toggle a weapon from the pokemon's respective backupweapon attribute to its item inventory
     * @param pokemon pokemon actor calling for the toggleweapon method
     * @param map map of the world in which the pokemon is in
     */
    public void toggleWeapon(Pokemon pokemon, GameMap map) {
        boolean containsSpecial = this.getInventory().contains(this.pokemonBackupWeapons.getBackupWeapon());

        if (pokemon.hasCapability(Element.GRASS) && map.locationOf(pokemon).getGround().hasCapability(Element.GRASS)){
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

    /**
     * method to affect bulbasaur object when the time shifts from night to day
     */
    @Override
    public void dayEffect() {
        hurt(5);
        if (!this.isConscious()) {
            TimePerceptionManager.getInstance().cleanUp(this);
        }
    }

    /**
     * method to affect Bulbasaur object when the time shifts from day to night
     */
    @Override
    public void nightEffect() {
        heal(5);
    }

    /**
     * method to set the Bulbasaur's intrinsic attack
     * @return the Bulbasaur's intrinsic weapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }

    @Override
    public int getHatchTime() {
        int hatchTime = 3;
        return hatchTime;
    }
}
