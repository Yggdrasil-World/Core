package de.yggdrasil.core.events.event.social.guild;

import de.yggdrasil.core.social.guild.Guild;
import de.yggdrasil.core.social.guild.GuildMember;

public class GuildOwnerChangedEvent extends GuildEvent {

    protected GuildMember oldOwner;

    protected GuildMember newOwner;
    public GuildOwnerChangedEvent(Guild guild, GuildMember oldOwner, GuildMember newOwner) {
        super(guild);
        this.newOwner = newOwner;
        this.oldOwner = oldOwner;
    }
}
