package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.grounds.*;
import game.items.Candy;
import game.nurse.NurseJoy;
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

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(),
                new Floor(), new Tree(),
                new Lava(), new Puddle(), new Crater(), new Waterfall(), new Hay());

        List<String> map = Arrays.asList(
                ".............................................^^^^^^^^^^^^^^",
                "...........,T,................................,T,..^^^^O^^^",
                ".....................................................^^^^^^",
                "........................................................^^^",
                "..........................#######...........,,...........^^",
                "..........................#_____#...........,T............^",
                "....................,T....#_____#..........................",
                "..,T,......~..............###_###..........................",
                "...~~~~~~~~................................................",
                "....~~~~~..................................................",
                "~~W~~~~~.............................,,,...................",
                "~~~~~~.,T,...........................,T,...................",
                "~~~~~~~~~..................................................");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        //Add player - Ash
        Player ash = new Player("Ash", '@', 100);
        world.addPlayer(ash, gameMap.at(32, 10));


        // Register ash as the trainer in the game
        AffectionManager.getInstance().registerTrainer(ash);

        // Add Nurse Joy
        NurseJoy nurseJoy = new NurseJoy();
        gameMap.at(31, 5).addActor(nurseJoy);

        world.run();

    }
}
