package de.yggdrasil.core.social.guild;

import de.yggdrasil.core.character.Character;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GuildManager {

    private Map<UUID, Guild> map;

    public GuildManager() {
        this.map = new HashMap<>();
    }

    public Guild getGuild(UUID uuid) {
        return this.map.get(uuid);
    }

    public boolean guildNameExists(String name) {
        for (Map.Entry<UUID, Guild> entry : map.entrySet()) {
            if(entry.getValue().getName().equals(name))
                return true;
        }
        return false;
    }

    public Guild createGuild(String name, Character creator) {
        // Has enough money
        return new Guild(name, creator);
    }

}
