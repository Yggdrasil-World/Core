package de.yggdrasil.core.common.adapters;

import de.yggdrasil.core.dal.adapter.Adapter;
import de.yggdrasil.core.dal.adapter.DALAdapter;
import net.minestom.server.entity.Player;

@DALAdapter(adapterForClass = Player.class)
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
