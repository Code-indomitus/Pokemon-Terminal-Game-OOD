package game.pokemons;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.elements.Element;

public class Charizard extends Pokemon{
    /**
     * constructor
     */
    public Charizard() {
        super("Charizard", 'Z', 250);
        this.addCapability(Element.FIRE);
        this.addCapability(Element.DRAGON);
    }

    /**
     * method to set the Charizard's intrinsic attack
     * @return the Charizard's intrinsic weapon
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
    }

}
