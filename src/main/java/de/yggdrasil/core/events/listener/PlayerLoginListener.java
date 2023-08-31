package de.yggdrasil.core.events.listener;

import de.yggdrasil.core.dal.DAL;
import de.yggdrasil.core.dal.requests.DALConfigReadRequest;
import de.yggdrasil.core.strings.ConfigKeys;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.event.EventListener;
import net.minestom.server.event.player.PlayerLoginEvent;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.resourcepack.ResourcePack;
import org.jetbrains.annotations.NotNull;

public class PlayerLoginListener implements EventListener<PlayerLoginEvent> {

    private final InstanceContainer instanceContainer;

    public PlayerLoginListener(InstanceContainer instanceContainer){
        this.instanceContainer = instanceContainer;
    }

    @Override
    public @NotNull Class eventType() {
        return PlayerLoginEvent.class;
    }

    @Override
    public @NotNull Result run(@NotNull PlayerLoginEvent event) {

        event.setSpawningInstance(this.instanceContainer);
        event.getPlayer().setRespawnPoint(new Pos(0, 42, 0));

        ResourcePack resourcePack = ResourcePack.forced(
                (String) DAL.get().read(new DALConfigReadRequest(ConfigKeys.RESOURCE_PACK_URL)).getData(), //URL
                (String) DAL.get().read(new DALConfigReadRequest(ConfigKeys.RESOURCE_PACK_HASH)).getData()); //Hash
        event.getPlayer().setResourcePack(resourcePack);
        return Result.SUCCESS;
    }

}
