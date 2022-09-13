package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.elements.Element;
import game.nusre.Tradeable;

public class Pokefruit extends Item implements Tradeable {
    private Element pokefruitElement;

    public Pokefruit(Element pokefruitElement) {
        super(pokefruitElement + " Pokefruit", 'f', true);
        this.pokefruitElement = pokefruitElement;
        this.addCapability(pokefruitElement);

    }
}
