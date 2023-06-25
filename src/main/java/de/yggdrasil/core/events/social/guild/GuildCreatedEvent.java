package de.yggdrasil.core.events.social.guild;

import de.yggdrasil.core.social.guild.Guild;
import de.yggdrasil.core.social.guild.GuildRank;

import java.util.Date;

public class GuildCreatedEvent extends GuildEvent {
    private Date timestamp;

    public GuildCreatedEvent(Guild guild) {
        super(guild);
        this.timestamp = new Date();
    }

    /**
     * @return the guild which got created
     */
    @Override
    public Guild getGuild() {
        return guild;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
