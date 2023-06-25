package de.yggdrasil.core.social.guild;

import de.yggdrasil.core.character.Character;


public interface GuildMember {
    Character character();
    GuildRank rank();
}
