package de.yggdrasil.core.events.event.social.guild;

import de.yggdrasil.core.social.guild.Guild;
import net.minestom.server.event.Event;

public class GuildEvent implements Event {

    protected Guild guild;

    public GuildEvent(Guild guild) {
        this.guild = guild;
    }

    public Guild getGuild() {
        return guild;
    }
}
