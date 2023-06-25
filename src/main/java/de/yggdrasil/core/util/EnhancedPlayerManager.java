package de.yggdrasil.core.util;

import de.yggdrasil.core.player.EnhancedPlayer;
import net.minestom.server.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public final class EnhancedPlayerManager {

    private final HashMap<EnhancedPlayer, Boolean> playerMap = new HashMap<>();
    private final HashMap<UUID, EnhancedPlayer> playerUUIDMap = new HashMap<>();

    private final static EnhancedPlayerManager instance = new EnhancedPlayerManager();

    private EnhancedPlayerManager(){

    }

    public void addPlayer(Player player){
        EnhancedPlayer enhancedPlayer = new EnhancedPlayer(player);
        this.playerMap.put(enhancedPlayer, true);
        this.playerUUIDMap.put(player.getUuid(), enhancedPlayer);
    }

    public boolean containsPlayerByUUID(UUID uuid){
        return this.playerUUIDMap.containsKey(uuid);
    }

    public boolean playerIsOnlineByUUID(UUID playerUuid){
        if (!this.playerUUIDMap.containsKey(playerUuid)){
            return false;
        }
        return playerMap.get(playerUUIDMap.get(playerUuid));
    }

    public static EnhancedPlayerManager getInstance() {
        return instance;
    }

}
