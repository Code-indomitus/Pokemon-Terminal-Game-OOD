package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.elements.Element;

public class Pokefruit extends Item {
    private Element pokefruitElement;

    public Pokefruit(Element pokefruitElement) {
        super(pokefruitElement + " Pokefruit", 'f', true);
        this.pokefruitElement = pokefruitElement;
        this.addCapability(pokefruitElement);

    }
}
