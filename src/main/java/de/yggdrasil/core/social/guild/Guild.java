package de.yggdrasil.core.social.guild;


import java.util.UUID;

// TODO: Outsource into an interface
/**
 * This is the Guild class with all members and data about it
 */
public class Guild {

    /**
     * Guild name restriction so they can only contain valid characters
     */
    public static final String GUILD_NAME_RESTRICTION_REGEX = "^[A-Za-z._!()=/0-9-]+$";

    /**
     * The unique id of a guild so it can be identified
     */
    private UUID uuid;

    /**
     * The displayed name of the guild
     */
    private String name;

    /**
     * The owner of the guild
     */
    private GuildMember owner; // TODO: Change to player interface

    /**
     * All the guild members
     */
    private GuildMember[] members; // TODO: Change to player interface

    /**
     * Available ranks which can be allocated to guild members
     */
    private GuildRank[] guildRanks;


    protected Guild(String name, GuildMember creator) {
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
