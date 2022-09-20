package game.pokemons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
import game.elements.Element;
import game.time.TimePerception;
import game.time.TimePerceptionManager;
import game.weapons.Bubble;


public class Squirtle extends Pokemon implements TimePerception {

    private BackupWeapons pokemonBackupWeapons;

    public Squirtle() {
        super("Squirtle", 's');
        this.addCapability(Element.WATER);
        this.addCapability(Status.CATCHABLE);
        this.pokemonBackupWeapons = new BackupWeapons(new Bubble("Bubble",'|',25,"burbles", 80));
        registerInstance();
    }

    /**
     * By using behaviour loops, it will decide what will be the next action automatically.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!this.isConscious()){
            TimePerceptionManager.getInstance().cleanUp(this);
            AffectionManager.getInstance().cleanUp(this);
            map.removeActor(this);
        }
        this.toggleWeapon(this, map);
        return super.playTurn(actions, lastAction, map, display);
    }


    public void toggleWeapon(Pokemon pokemon, GameMap map) {
        boolean containsSpecial = this.getInventory().contains(this.pokemonBackupWeapons.getBackupWeapon());

        if (pokemon.hasCapability(Element.WATER) && map.locationOf(pokemon).getGround().hasCapability(Element.WATER)){
            //need to fix squirtle second condition
            if(!containsSpecial){
                this.addItemToInventory(this.pokemonBackupWeapons.getBackupWeapon());
            }
        }
        else{
            if (containsSpecial) {
                this.removeItemFromInventory(this.pokemonBackupWeapons.getBackupWeapon());
            }
        }
    }

    @Override
    public void dayEffect() {
        hurt(10);
    }

    @Override
    public void nightEffect() {
        heal(10);
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "tackle");
    }


}
