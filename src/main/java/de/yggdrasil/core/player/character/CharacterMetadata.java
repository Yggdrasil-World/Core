package de.yggdrasil.core.player.character;

public interface CharacterMetadata {
    int getLevel();
    long getExp();
    long getMoney();
    long addExp();
    long addMoney();

}
