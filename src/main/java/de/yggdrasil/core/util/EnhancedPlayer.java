package de.yggdrasil.core.util;

import de.yggdrasil.core.character.jobclass.JobClassTree;
import de.yggdrasil.core.character.raceclass.RaceClassTree;
import net.minestom.server.entity.Player;

public class EnhancedPlayer extends Player {

    private int level;
    private int exp;
    private int money;
    private Character character;

    private JobClassTree jobClassTree;
    private RaceClassTree raceClassTree;

    public EnhancedPlayer(Player player) {
        super(player.getUuid(), player.getUsername(), player.getPlayerConnection());
        if (isInDatabase()) setup();
    }

    private boolean isInDatabase(){
        return true;
    }

    private void setup(){

    }

}
