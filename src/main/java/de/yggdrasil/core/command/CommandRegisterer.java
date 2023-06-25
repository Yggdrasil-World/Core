package de.yggdrasil.core.command;

import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.command.builder.Command;
import org.reflections.Reflections;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This is a util class which interacts with the {@link RegisterCommand} Annotation
 */
public class CommandRegisterer {

    /**
     * Finds all classes annotated with {@link RegisterCommand} which are a SubType of {@link Command} and are Generically constructable.
     * @return a set of {@link Command} classes
     */
    public static Set<Class<Command>> findCommands() {
        Reflections reflections = new Reflections("de.yggdrasil");
        return reflections.getTypesAnnotatedWith(RegisterCommand.class).stream()
                .filter(Command.class::isAssignableFrom)
                .filter(aClass -> Arrays.stream(aClass.getConstructors()).anyMatch(constructor -> constructor.getParameterCount() == 0))
                .map(aClass -> (Class<Command>) aClass)
                .collect(Collectors.toUnmodifiableSet());
    }

    /**
     * This function registers all given commands to the Server
     * @param commands All commands which should be registered to the server
     */
    public static void registerCommands(Set<Command> commands) {
        CommandManager commandManager = MinecraftServer.getCommandManager();
        commands.forEach(commandManager::register);
    }
}
