package de.yggdrasil.core.social.guild;

import de.yggdrasil.core.exceptions.StringRegexException;
import de.yggdrasil.core.exceptions.guild.NameNotAvailableException;
import de.yggdrasil.logger.file.console.DefaultLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GuildManagerImpl implements GuildManager {
    private static final Logger Logger = LogManager.getLogger(DefaultLogger.class);
    private static final Marker Marker = MarkerManager.getMarker("GUILD");
    private final Map<UUID, Guild> map;

    public GuildManagerImpl() {
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
        boolean existence = false;
        // Check every guild if it matches the given string
        for (Map.Entry<UUID, Guild> entry : map.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                existence = true;
                break;
            }
        }
        Logger.trace(Marker, String.format("Requested existence for guild name(Name: %s), returned %b", name, existence));
        // TODO: Check in Database
        return existence;
    }

    public @Nullable Guild createGuild(String name, GuildMember creator) throws StringRegexException, NameNotAvailableException {
        Logger.trace(Marker, String.format("Character(Name: %s) trying to create guild with name(Name: %s)", "NONE", name));
        if(!name.matches(Guild.GUILD_NAME_RESTRICTION_REGEX)) {
            throw new StringRegexException(Guild.GUILD_NAME_RESTRICTION_REGEX, name);
        }
        if(guildNameExists(name)) {
            throw new NameNotAvailableException("Guild name is already taken", name);
        }
        // Has enough money
        Logger.info(Marker, String.format("Character(Name: %s) created new guild(Name: %s)", "NONE", name));
        Guild guild = new GuildImpl(name, creator);
        return map.put(guild.getUuid(), guild);
    }

}
