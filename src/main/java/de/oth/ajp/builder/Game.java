package de.oth.ajp.builder;

import java.util.List;

/**
 * Interface represents a game. Here are necessary options which a game has to have.
 *
 * @author Lukas Cerny
 * @version 1.0
 * @since 1.8
 */

public interface Game {

    /**
     * Factory method creates builder for new game.
     * Method creates builder with basic game.
     * @return implementation of {@link GameBuilder}
     */
    static GameBuilder create() {
        return GameBuilder.newInstance(new BasicGame());
    }

    /**
     * @return adversary game {@link Game}
     */
    Game getAdversary();

    /**
     * @return returns list of players which play in game.
     */
    List<Player> getPlayers();

    /**
     * @return <code>true</code> or <code>false</code> if the players are set in space
     */
    boolean isInSpace();

    /**
     * @return <code>true</code> or <code>false</code> if the players are set on earth
     */
    boolean isOnEarth();

    /**
     * @return <code>true</code> or <code>false</code> if the players are set in underwater
     */
    boolean isUnderwater();

}