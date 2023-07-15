package de.yggdrasil.core.exceptions.guild;


public class NameNotAvailableException extends Exception{
    protected String name;
    public NameNotAvailableException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
