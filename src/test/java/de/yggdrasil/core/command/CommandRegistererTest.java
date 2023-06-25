package de.yggdrasil.core.command;

import de.yggdrasil.core.Main;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.builder.Command;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class CommandRegistererTest {

    @Test
    void findCommands() {
        Assertions.assertEquals(CommandRegisterer.findCommands().size(), 1, "Wrong amount of classes found");
    }

    @Test
    void registerCommands() {
        Main.main(null);
        TestCommand command = new TestCommand();
        CommandRegisterer.registerCommands(Stream.of(command).collect(Collectors.toUnmodifiableSet()));
        Assertions.assertTrue(MinecraftServer.getCommandManager().getCommands().stream().anyMatch(command1 -> command1.equals(command)), "Command not registered!");
    }
}