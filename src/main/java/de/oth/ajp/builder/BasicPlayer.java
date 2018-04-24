package de.oth.ajp.builder;

/**
 * Basic implementation of Player interface
 *
 * @author Lukas Cerny
 * @version 1.0
 * @since 1.8
 * @see Player
 */
public class BasicPlayer implements Player {

    private String name = "unknown";

    private boolean master;

    private int level;

    private int age;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
