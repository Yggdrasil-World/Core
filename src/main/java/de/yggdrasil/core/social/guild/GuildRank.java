package de.yggdrasil.core.social.guild;


import net.minestom.server.permission.Permission;

import java.util.Set;

/**
 * This is a GuildRank. It is a template with which players can make there own ranks and give them permissions inside their Guild.
 */
public interface GuildRank {
    Set<Permission> permissions();

    static GuildRank Empty() {
        return Set::of;
    }
}
