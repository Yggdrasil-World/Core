package de.yggdrasil.core.common.adapters;

import de.yggdrasil.core.dal.adapter.Adapter;
import de.yggdrasil.core.dal.adapter.DALAdapter;
import net.minestom.server.entity.Player;

@DALAdapter(version = 1, identifier = "player")
public class PlayerAdapter implements Adapter<Player> {

    @Override
    public <T> byte[] convertToData(T object) {
        return new byte[0];
    }

    @Override
    public <T> T createFromData(byte[] data) {
        return null;
    }

}
