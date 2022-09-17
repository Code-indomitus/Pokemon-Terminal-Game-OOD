package game.time;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Eng Lim Ooi
 * An interface for classes with time perception to implement.
 */
public interface TimePerception {
    /**
     * The dayEffect is implemented in the classes that use the TimePerception interface.
     */
    void dayEffect();

    /**
     * The nightEffect is implemented in the classes that use the TimePerception interface.
     */
    void nightEffect();

    /**
     * a default interface method that register current instance to the Singleton manager.
     * It allows corresponding class uses to be affected by global reset.
     */
    default void registerInstance(){
        TimePerceptionManager.getInstance().append(this);
    }
}
