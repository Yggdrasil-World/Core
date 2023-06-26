package de.yggdrasil.core;

/**
 * This class provides a centralized point were you can put classes which are needed all over the project
 */
public class Overcraft {
    private static final Overcraft overcraft = new Overcraft();

    private Overcraft() {

    }

    public static Overcraft get() {
        return overcraft;
    }

}
