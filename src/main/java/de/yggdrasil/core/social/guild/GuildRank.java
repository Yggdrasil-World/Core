package de.yggdrasil.core.social.guild;


import java.util.Set;

/**
 * This is a GuildRank. It is a template with which players can make there own ranks and give them permissions inside their Guild.
 */
public interface GuildRank {
    Set<GuildPermissions> permissions();

    static GuildRank Empty() {
        return new GuildRank() {
            @Override
            public Set<GuildPermissions> permissions() {
                return Set.of();
            }
        };
    }
}
