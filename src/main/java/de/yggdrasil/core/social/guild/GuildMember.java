package de.yggdrasil.core.social.guild;

import de.yggdrasil.core.player.character.Character;

public interface GuildMember {
    Character character();

    // TODO: new admin member
    static GuildMember NewMember(Character character) {
        return new GuildMemberImpl(character);
    }
}
