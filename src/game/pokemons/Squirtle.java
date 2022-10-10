package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
import game.elements.Element;
import game.nurse.Tradeable;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.weapons.Bubble;
import game.weapons.VineWhip;

/**
 * Class representing the Squirtle pokemon daughter class
 *
 * Created by:
 * @author Shyam Kamalesh Borkar
 * Modified by: Arrtish Suthan
 *
 */
public class Squirtle extends Pokemon implements TimePerception, Hatchable, Tradeable {

    /**
     * pokemonBackupWeapons attribute made from BackupWeapons class
     */
    private BackupWeapons pokemonBackupWeapons;

    /**
     * Constructor
     */
    public Squirtle() {
        super("Squirtle", 's', 100);
        this.addCapability(Element.WATER);
        this.addCapability(Status.CATCHABLE);
        this.pokemonBackupWeapons = new BackupWeapons();
        this.pokemonBackupWeapons.addWeapon(new Bubble());
        registerInstance();
    }

    /**
     * Method to toggle a weapon from the pokemon's respective backupweapon attribute to its item inventory
     * @param pokemon pokemon actor calling for the toggleweapon method
     * @param map map of the world in which the pokemon is in
     */
    @Override
    public void toggleWeapon(Pokemon pokemon, GameMap map) {
        boolean containsSpecial = this.getInventory().contains(this.pokemonBackupWeapons.getBackupWeapon().get(0));

        if (pokemon.hasCapability(Element.WATER) && map.locationOf(pokemon).getGround().hasCapability(Element.WATER)){
            //need to fix squirtle second condition
            if(!containsSpecial){
                this.addItemToInventory(this.pokemonBackupWeapons.getBackupWeapon().get(0));
            }
        }
        else{
            if (containsSpecial) {
                this.removeItemFromInventory(this.pokemonBackupWeapons.getBackupWeapon().get(0));
            }
        }
    }

    /**
     * method to affect Squirtle object when the time shifts from night to day
     */
    @Override
    public void dayEffect() {
        hurt(10);
        if (!this.isConscious()) {
            TimePerceptionManager.getInstance().cleanUp(this);
        }
    }

    /**
     * method to affect Squirtle object when the time shifts from day to night
     */
    @Override
    public void nightEffect() {
        heal(10);
    }

    /**
     * method to set the Squirtle's intrinsic attack
     * @return the Squirtle's intrinsic weapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }


    @Override
    public int getHatchTime() {
        int hatchTime = 2;
        return hatchTime;
    }

    /**
     * method to check for Squirtle to be tradable as a Pokemon
     * @return true if the object is a Pokemon
     */
    @Override
    public boolean isPokemon() {
        return true;
    }
}
