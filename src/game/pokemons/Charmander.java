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
import game.nurse.Tradeable;
import game.weapons.Ember;

/**
 * Class representing the Charmander pokemon daughter class
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:  Shyam Kamalesh Borkar, Arrtish Suthan
 */
public class Charmander extends Pokemon implements Tradeable, TimePerception, Hatchable {

    /**
     * pokemonBackupWeapons attribute made from BackupWeapons class
     */
    private BackupWeapons pokemonBackupWeapons;

    /**
     * Constructor.
     */
    public Charmander() {
        super("Charmander", 'c');
        this.addCapability(Element.FIRE);
        this.pokemonBackupWeapons = new BackupWeapons(new Ember());
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

    /**
     * method to check for Charmander to be tradable as a Pokemon
     * @return true if the object is a Pokemon
     */
    @Override
    public boolean isPokemon() {
        return true;
    }

    /**
     * method to affect Charmander object when the time shifts from night to day
     */
    @Override
    public void dayEffect() {
        heal(10);
    }

    /**
     * method to affect Charmander object when the time shifts from day to night
     */
    @Override
    public void nightEffect() {
        hurt(10);
        if (!this.isConscious()) {
            TimePerceptionManager.getInstance().cleanUp(this);
        }
    }

    /**
     * method to set the Charmander's intrinsic attack
     * @return the Charmander's intrinsic weapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "scratch");
    }

    @Override
    public int getHatchTime() {
        int hatchTime = 4;
        return hatchTime;
    }
}