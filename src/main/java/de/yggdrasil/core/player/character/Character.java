package de.yggdrasil.core.player.character;

import de.yggdrasil.core.player.EnhancedPlayer;

import java.util.UUID;

public interface Character {
    EnhancedPlayer getPlayer();
    UUID getUuid();
    long getMoney();
    long getLevel();
}
