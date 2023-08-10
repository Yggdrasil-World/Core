package de.yggdrasil.core.social.guild;

import java.util.UUID;

public interface Guild {

    /**
     * Guild name restriction so they can only contain valid characters
     */
    String GUILD_NAME_RESTRICTION_REGEX = "^[A-Za-z._!()=/0-9-]+$";

    UUID getUuid();

    String getName();

    GuildMember getOwner();

    GuildMember[] getMembers();

    GuildRank[] getGuildRanks();
}
