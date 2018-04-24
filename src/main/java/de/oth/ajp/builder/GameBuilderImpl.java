package de.oth.ajp.builder;

/**
 * Implementation of {@link GameBuilder}.
 * @author Lukas Cerny
 * @version 1.0
 * @since 1.8
 * @see GameBuilder
 */

public class GameBuilderImpl implements GameBuilder, GameBuilder.PlayerBuilder, GameBuilder.LocationBuilder.IntermediateGame {

    private BasicGame game;

    private BasicPlayer player;

    protected GameBuilderImpl(BasicGame game) {
        this.game = game;
    }

    @Override
    public PlayerBuilder asMaster() {
        player.setMaster(true);
        return this;
    }

    @Override
    public IntermediateGame setInSpace() {
        game.setInSpace(true);
        return this;
    }

    @Override
    public IntermediateGame setOnEarth() {
        game.setOnEarth(true);
        return this;
    }

    @Override
    public IntermediateGame setUnderwater() {
        game.setUnderwater(true);
        return this;
    }

    @Override
    public IntermediateGame adversary(Game game) {
        this.game.addAdversary(game);
        return this;
    }

    @Override
    public PlayerBuilder player(PlayerDetail... playerDetails) {
        player = new BasicPlayer();
        game.addPlayer(player);
        for (PlayerDetail playerDetail : playerDetails) {
            switch (playerDetail.getValueType()) {
                case AGE:   player.setAge((Integer) playerDetail.getValue());   break;
                case NAME:  player.setName((String) playerDetail.getValue());   break;
                case LEVEL: player.setLevel((Integer) playerDetail.getValue()); break;
            }

        }
        return this;
    }

    @Override
    public Game get() {
        return game;
    }
}