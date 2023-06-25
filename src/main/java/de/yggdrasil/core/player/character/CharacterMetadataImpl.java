package de.yggdrasil.core.player.character;

public class CharacterMetadataImpl implements CharacterMetadata {

    private int level;
    private long exp;
    private long money;

    /**
     * @return the character level
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * @return the total amount of exp obtained with this character
     */
    @Override
    public long getExp() {
        return exp;
    }

    /**
     * @return the total amount of money currently in the possession of the character
     */
    @Override
    public long getMoney() {
        return money;
    }

    /**
     * @return
     */
    @Override
    public long addExp() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public long addMoney() {
        return 0;
    }
}
