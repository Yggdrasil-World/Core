package de.yggdrasil.core.dal.data;

import de.yggdrasil.core.dal.data.event.DALEventbus;
import de.yggdrasil.core.dal.data.event.DataSourceDataListener;

public interface EventDataSource extends DataSource{

    void registerEventListener(DataSourceDataListener listener);

    DALEventbus getEventBus();

}
