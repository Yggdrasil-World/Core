package de.yggdrasil.core;

import de.yggdrasil.core.command.CommandRegisterer;
import de.yggdrasil.core.events.listener.PlayerLoginListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.block.Block;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Dotenv.configure().systemProperties().load();
        MinecraftServer minecraftServer = MinecraftServer.init();
        InstanceManager instanceManager = MinecraftServer.getInstanceManager();
        // Create the instance
        InstanceContainer instanceContainer = instanceManager.createInstanceContainer();
        // Set the ChunkGenerator
        instanceContainer.setGenerator(unit ->
                unit.modifier().fillHeight(0, 40, Block.GRASS_BLOCK));
        // Add an event callback to specify the spawning instance (and the spawn position)
        registerListeners(instanceContainer);
        // Start the server on port 25565
        minecraftServer.start("0.0.0.0", 25565);
        registerCommands();
    }

    private static void registerCommands() {
        CommandRegisterer.registerCommands(CommandRegisterer.findCommands().stream().map(commandClass -> {
            try {
                return commandClass.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toUnmodifiableSet()));
    }

    private static void registerListeners(InstanceContainer instanceContainer){
        GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();
        globalEventHandler.addListener(new PlayerLoginListener(instanceContainer));
    }

}
