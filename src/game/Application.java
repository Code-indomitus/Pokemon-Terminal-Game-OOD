package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.grounds.*;
import game.items.Candy;
import game.nurse.NurseJoy;
import game.pokemoncenter.Door;
import game.pokemoncenter.EnterPalletTownAction;
import game.pokemoncenter.EnterPokemonCenterAction;
import game.pokemons.AffectionManager;

/**
 * The main class to start the game.
 * Created by:Riordan D. Alfredo
 * @author Riordan D. Alfredo
 * Modified by: Shyam Kamalesh Borkar
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory palletTownGroundFactory = new FancyGroundFactory(new Dirt(), new Wall(),
                new Floor(), new Tree(),
                new Lava(), new Puddle(), new Crater(), new Waterfall(), new Hay());

        FancyGroundFactory pokemonCenterGroundFactory = new FancyGroundFactory(new Dirt(), new Wall(),
                new Floor(), new Incubator());

        List<String> palletTownStrings = Arrays.asList(
                ".............................................^^^^^^^^^^^^^^",
                "...........,T,................................,T,..^^^^O^^^",
                ".....................................................^^^^^^",
                "........................................................^^^",
                "............................................,,...........^^",
                "............................###.............,T............^",
                "....................,T......#_#............................",
                "..,T,......~...............................................",
                "...~~~~~~~~................................................",
                "....~~~~~..................................................",
                "~~W~~~~~.............................,,,...................",
                "~~~~~~.,T,...........................,T,...................",
                "~~~~~~~~~..................................................");

        List<String> pokemonCenterStrings = Arrays.asList(
                "##################",
                "#________________#",
                "#______X...X_____#",
                "#________________#",
                "#________________#",
                "########___#######");

        GameMap palletTown = new GameMap(palletTownGroundFactory, palletTownStrings);
        world.addGameMap(palletTown);

        GameMap pokemonCenter = new GameMap(pokemonCenterGroundFactory, pokemonCenterStrings);
        world.addGameMap(pokemonCenter);

        //Add player - Ash
        Player ash = new Player("Ash", '@', 100);
        world.addPlayer(ash, palletTown.at(32, 10));

        for (int i = 0; i < 7; i++) {
            ash.addItemToInventory(new Candy());
        }

        // Register ash as the trainer in the game
        AffectionManager.getInstance().registerTrainer(ash);

        // Add Nurse Joy in the pokemon center
        NurseJoy nurseJoy = new NurseJoy();
        pokemonCenter.at(9, 2).addActor(nurseJoy);

        // Action to enter pokemon center
        EnterPokemonCenterAction enterCenter = new EnterPokemonCenterAction(pokemonCenter, pokemonCenter.at(9, 5));
        // Door that opens to Pokemon Center
        Door doorToCenter = new Door(enterCenter);
        // Place the door in Pallet Town
        palletTown.at(29, 6).setGround(doorToCenter);

        // Action to enter pallet town
        EnterPalletTownAction enterTown = new EnterPalletTownAction(palletTown, palletTown.at(29, 6));
        // Door that opens to Pallet Town
        Door doorToPallet = new Door(enterTown);
        // Place the door in Pokemon Center
        pokemonCenter.at(9, 5).setGround(doorToPallet);

        //running the game
        world.run();

    }
}
