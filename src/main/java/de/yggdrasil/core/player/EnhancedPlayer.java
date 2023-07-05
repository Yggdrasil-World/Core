package de.yggdrasil.core.player;

import de.yggdrasil.core.player.character.Character;
import net.minestom.server.entity.Player;
import net.minestom.server.network.player.PlayerConnection;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class EnhancedPlayer extends Player {

    private Character character;

    public EnhancedPlayer(Player player) {
        super(player.getUuid(), player.getUsername(), player.getPlayerConnection());
    }

    public EnhancedPlayer(@NotNull UUID uuid, @NotNull String username, @NotNull PlayerConnection playerConnection) {
        super(uuid, username, playerConnection);
    }

    public Character getCharacter() {
        return character;
    }
}
