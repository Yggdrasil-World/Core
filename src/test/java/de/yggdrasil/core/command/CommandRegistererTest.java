package de.yggdrasil.core.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CommandRegistererTest {

    @Test
    void findCommands() {
        Assertions.assertEquals(CommandRegisterer.findCommands().size(), 1, "Wrong amount of classes found");
    }
}