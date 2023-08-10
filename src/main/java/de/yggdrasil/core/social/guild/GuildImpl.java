package de.yggdrasil.core.social.guild;

import de.yggdrasil.core.utils.NBTContainer;

import java.util.UUID;

public class GuildImpl implements Guild {

    /**
     * The unique id of a guild so it can be identified
     */
    private final UUID uuid;

    /**
     * The displayed name of the guild
     */
    private final String name;

    /**
     * The owner of the guild
     */
    private final GuildMember owner; // TODO: Change to player interface

    /**
     * All the guild members
     */
    private GuildMember[] members; // TODO: Change to player interface

    /**
     * Available ranks which can be allocated to guild members
     */
    private GuildRank[] guildRanks;

    protected GuildImpl(String name, GuildMember creator) {
        this.owner = creator;
        this.name = name;
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public GuildMember getOwner() {
        return this.owner;
    }

    public GuildMember[] getMembers() {
        return this.members;
    }

    public GuildRank[] getGuildRanks() {
        return this.guildRanks;
    }
}
