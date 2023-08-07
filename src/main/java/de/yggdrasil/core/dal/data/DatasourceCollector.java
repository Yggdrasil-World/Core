package de.yggdrasil.core.dal.data;

import java.util.Set;

public interface DatasourceCollector {

    Set<Class<? extends DataSource>> collectDatasources();

}
