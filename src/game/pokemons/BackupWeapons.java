package game.pokemons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;

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
    private WeaponItem backupWeapon;

    public BackupWeapons(WeaponItem backupWeapon){
        this.backupWeapon = backupWeapon;
    }

    public WeaponItem getBackupWeapon() {
        return backupWeapon;
    }
}
