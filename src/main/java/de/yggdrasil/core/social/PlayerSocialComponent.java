package de.yggdrasil.core.social;

import de.yggdrasil.core.social.friend.PlayerFriendComponent;
import de.yggdrasil.core.social.guild.PlayerGuildComponent;

public interface PlayerSocialComponent {
    PlayerFriendComponent getFriendComponent();
    PlayerGuildComponent getGuildComponent();
}
