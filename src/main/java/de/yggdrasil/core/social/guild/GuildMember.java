package de.yggdrasil.core.social.guild;

import de.yggdrasil.core.player.character.Character;

public interface GuildMember {
    Character character();
    GuildRank rank();

    // TODO: new admin member
    static GuildMember NewMember(Character character, GuildRank rank) {
        return new GuildMemberImpl(character, rank);
    }
}
