package de.yggdrasil.core.exceptions;

import de.yggdrasil.core.strings.ExceptionStrings;

public class IdentifierAlreadyExistsException extends Exception{
    public IdentifierAlreadyExistsException(String identifier) {
        super(ExceptionStrings.IDENTIFIER_ALREADY_EXISTS.formatted(identifier));
    }
}
