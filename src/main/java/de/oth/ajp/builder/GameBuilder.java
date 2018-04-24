package de.oth.ajp.builder;

/**
 * Builder provides new game.
 * @author Lukas Cerny
 * @since 1.8
 * @version 1.0
 */

interface GameBuilder {

    static GameBuilder newInstance(BasicGame game) {
        return new GameBuilderImpl(game);
    }

    interface IntermediatePlayer extends LocationBuilder, TerminateBuilder, GameBuilder {}

    interface TerminateBuilder {

        /**
         * @return build method which creates new game. See {@link Game}.
         */
        Game get();

    }

    interface LocationBuilder {

        interface IntermediateGame extends TerminateBuilder, GameBuilder {}

        /**
         * Sets the players to space.
         * @return {@link IntermediateGame}
         * @exception IllegalArgumentException when players was already set to area
         */
        IntermediateGame setInSpace();

        /**
         * Sets the players on earth.
         * @return {@link IntermediateGame}
         * @exception IllegalArgumentException when players was already set to area
         */
        IntermediateGame setOnEarth();

        /**
         * Sets the players to underwater.
         * @return {@link IntermediateGame}
         * @exception IllegalArgumentException when players was already set to area
         */
        IntermediateGame setUnderwater();

        /**
         * Allows adding recursive game.
         * @return {@link IntermediateGame}
         * @exception IllegalArgumentException when players was already set to area
         */
        IntermediateGame adversary(Game game);

    }

    interface PlayerBuilder extends IntermediatePlayer {

        /**
         * Allows set the player as master in game.
         * @return the {@link IntermediatePlayer}
         */
        IntermediatePlayer asMaster();

    }

    /**
     * Allows adding some player's details like name, age, level.
     * @param playerDetails the {@link PlayerDetail}
     * @return player's builder which allows create new player
     */
    PlayerBuilder player(PlayerDetail... playerDetails);

}