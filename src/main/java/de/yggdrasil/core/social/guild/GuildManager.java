package de.yggdrasil.core.social.guild;

import de.yggdrasil.core.character.Character;
import de.yggdrasil.core.exceptions.StringRegexException;
import de.yggdrasil.core.exceptions.guild.NameNotAvailableException;
import org.jetbrains.annotations.Nullable;

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

    /**
     * @param name the name which wille be checked for existence
     * @return if the guild name already exists
     */
    public boolean guildNameExists(String name) {
        // Check ever guild if it matches the given string
        for (Map.Entry<UUID, Guild> entry : map.entrySet()) {
            if(entry.getValue().getName().equals(name))
                return true;
        }
        // TODO: Check in Database
        return false;
    }
    /**
     * @param name The name of the Guild
     * @param creator The character who is trying to invoke a guild creation
     * @return Null if guild name already exists, else returns the created Guild
     */
    public @Nullable Guild createGuild(String name, Character creator) throws StringRegexException, NameNotAvailableException {
        return createGuild(name, GuildMember.NewMember(creator, GuildRank.Empty()));
    }

    /**
     * @param name The name of the Guild
     * @param creator The character who is trying to invoke a guild creation
     * @return Null if guild name already exists, else returns the created Guild
     */
    public @Nullable Guild createGuild(String name, GuildMember creator) throws StringRegexException, NameNotAvailableException {
        if(!name.matches(Guild.GUILD_NAME_RESTRICTION_REGEX)) {
            throw new StringRegexException(Guild.GUILD_NAME_RESTRICTION_REGEX, name);
        }
        if(guildNameExists(name)) {
            throw new NameNotAvailableException("Guild name is already taken", name);
        }
        // Has enough money
        Guild guild = new Guild(name, creator);
        return map.put(guild.getUuid(), guild);
    }

}
