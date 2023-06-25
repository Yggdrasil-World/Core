package de.yggdrasil.core.social.guild;


import de.yggdrasil.core.character.Character;
import net.minestom.server.entity.Player;

import java.util.UUID;

// TODO: Outsource into an interface
/**
 * This is the Guild class with all members and data about it
 */
public class Guild {

    private UUID uuid;
    private String name;
    private Character owner; // TODO: Change to player interface
    private Character[] members; // TODO: Change to player interface
    private GuildRank[] guildRanks;

    public Guild(String name, Character creator) {
        this.owner = creator;
        this.name = name;
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Character getOwner() {
        return owner;
    }

    public Character[] getMembers() {
        return members;
    }

    public GuildRank[] getGuildRanks() {
        return guildRanks;
    }
}
