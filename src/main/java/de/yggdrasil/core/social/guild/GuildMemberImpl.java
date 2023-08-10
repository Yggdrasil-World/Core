package de.yggdrasil.core.social.guild;

import de.yggdrasil.core.player.character.Character;

public record GuildMemberImpl(Character character, GuildRank rank) implements GuildMember{
}
