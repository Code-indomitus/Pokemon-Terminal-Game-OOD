package game;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 */
public enum Status {
    IMMUNE, // an enum to identify that an object is immune to any attack.
    HOSTILE, // use this status to be considered hostile towards enemy (e.g., to be attacked by enemy)
    CATCHABLE, // use this status to check if a Pokemon is catchable
    TRADEABLE_CANDY, // used to indicate whether an item in the player's inventory is a candy or not
    CANNOT_ENTER_FLOOR, // used to make sure that actor with this status cannot enter a floor
    CANNOT_BE_EXPANDED, // to identify if the ground can be expanded.
    FEEDABLE, // used to identify if an item is feedable
    INCUBATE // used to identify a ground is capable of incubating Pokemon eggs.

}
