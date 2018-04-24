package de.oth.ajp.builder;

/**
 * Interface represents a player. Here are necessary options which a player has to have.
 *
 * @author Lukas Cerny
 * @version 1.0
 * @since 1.8
 * @see Game
 */
public interface Player {

    /**
     * @return name of player.
     */
    String getName();

    /**
     * @return <code>true</code> or <code>false</code> if the player is master.
     */
    boolean isMaster();

    /**
     * @return integer number represents his level.
     */
    int getLevel();

    /**
     * @return integer number represents age of player.
     */
    int getAge();
}
