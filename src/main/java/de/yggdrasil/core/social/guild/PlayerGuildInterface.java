package de.yggdrasil.core.social.guild;

// TODO: Change to a more fitting name
/**
 * An instance of this should be present in every Player instance it acts as a communication layer between a guild and the player.
 * It also should make information of the players ranks and permissions usw available in a player instance
 */
public interface PlayerGuildInterface {
    GuildRank rank();
}
