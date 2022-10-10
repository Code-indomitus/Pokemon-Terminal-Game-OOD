package game.pokemons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;

import java.util.ArrayList;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 * If a Pokemon needs to use a weapon, put it into that Pokemon's inventory.
 * @see Actor#getWeapon() method.
 * @see AttackAction uses getWeapon() in the execute() method.
 */
public class BackupWeapons {
    private ArrayList<WeaponItem> backupWeapons;

    public BackupWeapons(){
        this.backupWeapons = new ArrayList<>();
    }

    public ArrayList<WeaponItem> getBackupWeapon() {
        return this.backupWeapons;
    }

    public void addWeapon(WeaponItem newWeaponItem) {
        this.backupWeapons.add(newWeaponItem);
    }
}
