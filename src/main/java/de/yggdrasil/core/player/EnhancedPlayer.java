package de.yggdrasil.core.player;

import de.yggdrasil.core.player.character.jobclass.JobClassTree;
import de.yggdrasil.core.player.character.raceclass.RaceClassTree;
import net.minestom.server.entity.Player;

public class EnhancedPlayer extends Player {


    private Character character;
    private JobClassTree jobClassTree;
    private RaceClassTree raceClassTree;

    public EnhancedPlayer(Player player) {
        super(player.getUuid(), player.getUsername(), player.getPlayerConnection());
    }

}
