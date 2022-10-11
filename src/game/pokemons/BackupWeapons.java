package game.pokemons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;

import java.util.ArrayList;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Shyam Kamalesh Borkar and Arrtish Suthan
 *
 * If a Pokemon needs to use a weapon, put it into that Pokemon's inventory.
 * @see Actor#getWeapon() method.
 * @see AttackAction uses getWeapon() in the execute() method.
 */
public class BackupWeapons {
    /**
     * List of weapon items of the pokemon
     */
    private ArrayList<WeaponItem> backupWeapons;

    /**
     * BackupWeapons constructor
     */
    public BackupWeapons(){
        this.backupWeapons = new ArrayList<>();
    }

    /**
     * @return list of weapon items
     */
    public ArrayList<WeaponItem> getBackupWeapon() {
        return this.backupWeapons;
    }

    /**
     * add a new weapon item
     * @param newWeaponItem the new weapon item
     */
    public void addWeapon(WeaponItem newWeaponItem) {
        this.backupWeapons.add(newWeaponItem);
    }
}
