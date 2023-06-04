package de.yggdrasil.core.events.listener;

import de.yggdrasil.core.util.EnhancedPlayerManager;
import net.minestom.server.event.player.PlayerLoginEvent;

import java.util.function.Consumer;

public class PlayerJoinListener implements Consumer<PlayerLoginEvent> {
    @Override
    public void accept(PlayerLoginEvent playerLoginEvent) {
        EnhancedPlayerManager.getInstance().addPlayer(playerLoginEvent.getPlayer());
    }
}
