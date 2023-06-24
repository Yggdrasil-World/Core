package de.yggdrasil.core.social.guild;


import net.minestom.server.entity.Player;

import java.util.UUID;

// TODO: Outsource into an interface
/**
 * This is the Guild class with all members and data about it
 */
public class Guild {
    private UUID owner; // TODO: Change to player interface
    private UUID[] members; // TODO: Change to player interface
    private GuildRank[] guildRanks;

    public Guild(Player creator) {
        this.owner = creator.getUuid();
    }

}
