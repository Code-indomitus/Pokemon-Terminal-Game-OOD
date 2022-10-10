package game.pokemons;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.elements.Element;

public class Charmeleon extends EvolvingPokemon{
    /**
     * Charmeleon constructor
     */
    public Charmeleon() {
        super("Charmeleon", 'C', 150);
        this.addCapability(Element.FIRE);
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
    }

    /**
     * method to return charmeleon's evolved version
     * @return charizard pokemon
     */
    @Override
    public Pokemon getEvolvedPokemon() {
        return new Charizard();
    }
}
