package de.oth.ajp.builder;


import java.util.ArrayList;
import java.util.List;

/**
 * Basic implementation of Game interface
 *
 * @author Lukas Cerny
 * @version 1.0
 * @since 1.8
 * @see Game
 */

public class BasicGame implements Game {

    private List<Player> players = new ArrayList<>();

    private Game adversary;

    private boolean inSpace, onEarth, underwater;

    protected BasicGame() {}

    public void addAdversary(Game game) {
        this.adversary = game;
    }

    @Override
    public Game getAdversary() {
        return adversary;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    @Override
    public boolean isInSpace() {
        return inSpace;
    }

    public void setInSpace(boolean inSpace) {
        setLocation(() -> this.inSpace = inSpace);
    }

    @Override
    public boolean isOnEarth() {
        return onEarth;
    }

    public void setOnEarth(boolean onEarth) {
        setLocation(() -> this.onEarth = onEarth);

    }

    @Override
    public boolean isUnderwater() {
        return underwater;
    }

    public void setUnderwater(boolean underwater) {
        setLocation(() -> this.underwater = underwater);
    }

    private void setLocation(Runnable location) {
        if (inSpace || onEarth || underwater) {
            throw new IllegalArgumentException("The location was already set.");
        }
        location.run();
    }

    @Override
    public String toString() {
        return "BasicGame{" +
                "players=" + players +
                ", adversary=" + adversary +
                ", inSpace=" + inSpace +
                ", onEarth=" + onEarth +
                ", underwater=" + underwater +
                '}';
    }
}