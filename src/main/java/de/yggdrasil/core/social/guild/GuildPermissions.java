package de.yggdrasil.core.social.guild;

import net.minestom.server.permission.Permission;


public interface GuildPermissions {
    /*
    § STC: should be loaded from data files including a description ( Possible to translate )
    § These should only act as examples
    */
    Permission GUILD_NAME_CHANGE = new Permission("guild.name.change");
    Permission GUILD_BANNER_CHANGE  = new Permission("guild.banner.change");
    Permission GUILD_MEMBER_INVITE = new Permission("guild.member.invite");
    Permission GUILD_MEMBER_KICK  = new Permission("guild.member.kick");
    Permission GUILD_MEMBER_BAN  = new Permission("guild.member.ban");
    Permission GUILD_CHAT_MEMBER_MUTE  = new Permission("guild.chat.member.mute");
    Permission GUILD_CHAT_MESSAGE_REMOVE  = new Permission("guild.chat.message.remove");


}
