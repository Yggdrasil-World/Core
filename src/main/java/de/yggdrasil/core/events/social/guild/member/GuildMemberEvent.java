package de.yggdrasil.core.events.social.guild.member;

import de.yggdrasil.core.events.social.guild.GuildEvent;
import de.yggdrasil.core.social.guild.Guild;
import de.yggdrasil.core.social.guild.GuildMember;

public class GuildMemberEvent extends GuildEvent {

    protected GuildMember member;

    public GuildMemberEvent(Guild guild, GuildMember member) {
        super(guild);
        this.member = member;
    }
    public GuildMember getMember() {
        return member;
    }
}
