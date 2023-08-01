package de.yggdrasil.core.dal.data.event;

public interface DALEventbus {

    boolean triggerEvent(DataSourceDataEvent event);

    void registerListener(DataSourceDataListener listener);

}
