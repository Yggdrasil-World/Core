package de.yggdrasil.core.exceptions;

import de.yggdrasil.core.strings.ExceptionMessages;

public class StringRegexException extends Exception{
    protected String regex;
    protected String string;

    public StringRegexException(String regex, String string) {
        super(ExceptionMessages.STRING_REGEX_EXCEPTION.formatted(string, regex));
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
