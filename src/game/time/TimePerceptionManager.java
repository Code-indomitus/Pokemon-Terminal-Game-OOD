package game.time;

import game.pokemons.AffectionManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A global Singleton manager that gives time perception  on the affected instances.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Shyam Kamalesh Borkar and Eng Lim Ooi
 *
 */
public class TimePerceptionManager {
    /**
     * A list of polymorph instances (any classes that implements TimePerception,
     * such as, a Charmander implements TimePerception, it will be stored in here)
     */
    private final List<TimePerception> timePerceptionList;

    /**
     * The turn of the game.
     */
    private int turn;

    /**
     * The current time period of the game.
     */
    private TimePeriod shift; // DAY or NIGHT

    /**
     * A singleton instance
     */
    private static TimePerceptionManager instance;

    /**
     * Get the singleton instance of time perception manager
     * @return TimePerceptionManager singleton instance
     */
    public static TimePerceptionManager getInstance() {
        if (instance == null) {
            instance = new TimePerceptionManager();
        }
        return instance;
    }

    /**
     * Private TimePerceptionManager constructor
     */
    private TimePerceptionManager() {
        timePerceptionList = new ArrayList<>();
        turn = 0;
        shift = TimePeriod.DAY;
    }

    /**
     * Traversing through all instances in the list and execute the dayEffect and nightEffect method accordingly.
     * By doing this way, it will avoid using `instanceof` all over the place.
     */
    public void run() {

        if (shift == TimePeriod.DAY) {
            System.out.println("It is a Day-time (turn " + turn + ")");
        }
        else if (shift == TimePeriod.NIGHT) {
            System.out.println("It is a Night-time (turn " + turn + ")");
        }

        if ((this.turn + 1) % 5 == 0) {

            if (shift == TimePeriod.DAY) {
                shift = TimePeriod.NIGHT;
            }
            else if (shift == TimePeriod.NIGHT) {
                shift = TimePeriod.DAY;
            }
        }

        for (int i = 0; i < this.timePerceptionList.size(); i++) {
            if (shift == TimePeriod.DAY) {
                this.timePerceptionList.get(i).dayEffect();
            }
            else if (shift == TimePeriod.NIGHT) {
                this.timePerceptionList.get(i).nightEffect();
            }
        }
        this.turn += 1;
    }


    /**
     * Add the TimePerception instance to the list.
     * @param objInstance any instance that implements TimePerception.
     */
    public void append(TimePerception objInstance) {
        this.timePerceptionList.add(objInstance);
    }


    /**
     * Remove a TimePerception instance from the list.
     * @param objInstance object instance.
     */
    public void cleanUp(TimePerception objInstance) {
        timePerceptionList.remove(timePerceptionList.get(timePerceptionList.indexOf(objInstance)));
    }
}
