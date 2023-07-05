package de.yggdrasil.core.player;

import net.minestom.server.entity.Player;
import net.minestom.server.network.PlayerProvider;
import net.minestom.server.network.player.PlayerConnection;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class EnhancedPlayerProvider implements PlayerProvider {
    @Override
    public @NotNull Player createPlayer(@NotNull UUID uuid, @NotNull String username, @NotNull PlayerConnection connection) {
        // Load Player Information
        return new EnhancedPlayer(uuid, username, connection);
    }
}
