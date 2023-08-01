package de.yggdrasil.core.dal.data.event.listeners;

import de.yggdrasil.core.dal.data.event.DataSourceDataEvent;
import de.yggdrasil.core.dal.data.event.DataSourceDataListener;

public interface DataReceivedListener<T extends DataSourceDataEvent> extends DataSourceDataListener<T> {



}
