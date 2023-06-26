package de.yggdrasil.core.exceptions;

public class StringRegexException extends Exception{
    protected String regex;
    protected String string;

    public StringRegexException(String errorMessage, String regex, String string) {
        super(errorMessage);
        this.string = string;
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public String getString() {
        return string;
    }
}
