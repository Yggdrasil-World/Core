package de.yggdrasil.core.dal.data.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DALDefaultEventBus implements DALEventbus{

    private final HashMap<Class<? extends DataSourceDataEvent>, List<DataSourceDataListener>> eventListeners = new HashMap<>();

    @Override
    public boolean triggerEvent(DataSourceDataEvent event) {
        for (DataSourceDataListener listener:
                this.eventListeners.get(event.getClass())) {
                listener.handleEvent(event);
        }
        return true;
    }

    @Override
    public void registerListener(DataSourceDataListener listener) {
        if (!this.eventListeners.containsKey(listener.getSubscribedEvent())){
            List<DataSourceDataListener> listeners = new ArrayList<>();
            listeners.add(listener);
            this.eventListeners.put(listener.getSubscribedEvent(), listeners);
        } else {
            this.eventListeners.get(listener.getSubscribedEvent()).add(listener);
        }
    }
}
