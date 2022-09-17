package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.elements.Element;
import game.nusre.Tradeable;

/**
 * A class that represents Pokefruit item.
 */
public class Pokefruit extends Item implements Tradeable {
    /**
     * The element of the Pokefruit.
     */
    private Element pokefruitElement;

    /**
     * Pokefruit Constructor.
     * @param pokefruitElement element of the Pokefruit.
     */
    public Pokefruit(Element pokefruitElement) {
        super(pokefruitElement + " Pokefruit", 'f', true);
        this.pokefruitElement = pokefruitElement;
        this.addCapability(pokefruitElement);

    }

    /**
     * To identify if this Tradeable is a Pokemon.
     * @return boolean false.
     */
    @Override
    public boolean isPokemon() {
        return false;
    }
}
