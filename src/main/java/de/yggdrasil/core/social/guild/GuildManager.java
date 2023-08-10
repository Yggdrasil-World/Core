package de.yggdrasil.core.social.guild;

import de.yggdrasil.core.exceptions.StringRegexException;
import de.yggdrasil.core.exceptions.guild.NameNotAvailableException;
import de.yggdrasil.core.player.character.Character;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface GuildManager {

    Guild getGuild(UUID uuid);
    boolean guildNameExists(String name);
    /**
     * @param name The name of the Guild
     * @param creator The character who is trying to invoke a guild creation
     * @return Null if guild name already exists, else returns the created Guild
     */
    default @Nullable Guild createGuild(String name, Character creator) throws StringRegexException, NameNotAvailableException {
        return createGuild(name, GuildMember.NewMember(creator));
    }

    /**
     * @param name The name of the Guild
     * @param creator The character who is trying to invoke a guild creation
     * @return Null if guild name already exists, else returns the created Guild
     */
    @Nullable Guild createGuild(String name, GuildMember creator) throws StringRegexException, NameNotAvailableException;
}
