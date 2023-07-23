package de.yggdrasil.core;

import de.yggdrasil.core.social.guild.GuildManager;

/**
 * This class provides a centralized point were you can put classes which are needed all over the project
 */
public final class Overcraft {
    private static final Overcraft overcraft = new Overcraft();

    private final GuildManager guildManager;

    private Overcraft() {
        guildManager = new GuildManager();
    }

    public GuildManager getGuildManager() {
        return guildManager;
    }

    public static Overcraft get() {
        return overcraft;
    }

}
