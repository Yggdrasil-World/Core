package de.yggdrasil.core.dal.data.event;

public interface DataSourceDataListener<T extends DataSourceDataEvent> {

    Class<T> getSubscribedEvent();

    void handleEvent(T event);

}
