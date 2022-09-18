package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.items.Pokeball;
import game.pokemons.Pokemon;

public class SummonPokemonAction extends Action {
    Pokeball summonFromPokeball;
    public SummonPokemonAction(Pokeball summonFromPokeball) {
        this.summonFromPokeball = summonFromPokeball;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        Pokemon pokemonToBeSummoned = summonFromPokeball.getCaughtPokemon();
        for(Exit exit : location.getExits()) {
            if (!exit.getDestination().containsAnActor() && exit.getDestination().getGround().canActorEnter(pokemonToBeSummoned)) {
                exit.getDestination().addActor(pokemonToBeSummoned);
                actor.removeItemFromInventory(this.summonFromPokeball);
                return "I choose you " + pokemonToBeSummoned + ".";
            }
        }
        return pokemonToBeSummoned + " could not be summoned.";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Summon " + this.summonFromPokeball.getCaughtPokemon() + ".";
    }
}