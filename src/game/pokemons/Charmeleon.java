package game.pokemons;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.elements.Element;
import game.elements.ElementsHelper;
import game.weapons.Blaze;
import game.weapons.Ember;
import game.weapons.VineWhip;

import java.util.Random;
/**
 * Class representing the Charmeleon pokemon daughter class
 *
 * Created by:
 * @author Shyam Kamalesh Borkar
 */
public class Charmeleon extends EvolvingPokemon{
    /**
     * pokemonBackupWeapons attribute made from BackupWeapons class
     */
    private BackupWeapons pokemonBackupWeapons;

    /***
     * Random class used to randomly select a special weapon
     */
    private final Random randomGenerator = new Random();

    /**
     * record of the current special weapon equipped by the pokemon
     */
    private WeaponItem currentWeapon;

    /**
     * Charmeleon constructor
     */
    public Charmeleon() {
        super("Charmeleon", 'C', 150);
        this.addCapability(Element.FIRE);
        this.addCapability(Status.CATCHABLE);
        this.pokemonBackupWeapons = new BackupWeapons();
        this.pokemonBackupWeapons.addWeapon(new Ember());
        this.pokemonBackupWeapons.addWeapon(new Blaze());
    }

    /**
     * method to set the Charmeleon's intrinsic attack
     * @return the Charmeleon's intrinsic weapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "scratch");
    }


    /**
     * Method to toggle a weapon from the pokemon's respective backupweapon attribute to its item inventory
     * @param pokemon pokemon actor calling for the toggleweapon method
     * @param map map of the world in which the pokemon is in
     */
    @Override
    public void toggleWeapon(Pokemon pokemon, GameMap map) {
        boolean containsSpecial = this.getInventory().contains(this.currentWeapon);
        if (containsSpecial) {
            this.removeItemFromInventory(this.currentWeapon);
        }
        if (ElementsHelper.hasAnySimilarElements(this, map.locationOf(this).getGround().findCapabilitiesByType(Element.class))){
            int randomWeaponIndex = randomGenerator.nextInt(this.pokemonBackupWeapons.getBackupWeapon().size());
            this.currentWeapon = this.pokemonBackupWeapons.getBackupWeapon().get(randomWeaponIndex);
            this.addItemToInventory(this.currentWeapon);
        }
    }

    /**
     * method to return charmeleon's evolved version
     * @return charizard pokemon
     */
    @Override
    public Pokemon getEvolvedPokemon() {
        if (super.evolvedPokemon == null) {
            super.evolvedPokemon = new Charizard();
        }
        return super.evolvedPokemon;
    }
}
