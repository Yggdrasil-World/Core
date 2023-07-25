package de.yggdrasil.core.common.adapters;

import de.yggdrasil.core.dal.adapter.Adapter;
import de.yggdrasil.core.dal.adapter.DALAdapter;
import net.minestom.server.entity.Player;

@DALAdapter(version = 1, identifier = "player")
public class PlayerAdapter implements Adapter<Player> {


    /**
     * @param object
     * @return
     */
    @Override
    public byte[] convertToData(Player object) {
        return new byte[0];
    }

    /**
     * @param data
     * @return
     */
    @Override
    public Player createFromData(byte[] data) {
        return null;
    }
}
