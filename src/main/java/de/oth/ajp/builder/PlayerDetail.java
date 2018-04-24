package de.oth.ajp.builder;

/**
 * Detail information about player.
 * @author Lukas Cerny
 * @version since 1.8
 */
public class PlayerDetail<A> {

    enum Type {NAME, AGE, LEVEL}

    private A value;

    private Type valueType;

    private PlayerDetail(A value, Type valueType) {
        this.value = value;
        this.valueType = valueType;
    }

    public A getValue() {
        return value;
    }

    public Type getValueType() {
        return valueType;
    }

    static PlayerDetail name(String name) {
        return new PlayerDetail(name, Type.NAME);
    }

    static PlayerDetail age(int age) {
        return new PlayerDetail(age, Type.AGE);
    }

    static PlayerDetail level(int level) {
        return new PlayerDetail(level, Type.LEVEL);
    }
}