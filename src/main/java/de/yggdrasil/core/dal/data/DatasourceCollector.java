package de.yggdrasil.core.dal.data;

import java.util.Set;

public interface DatasourceCollector {

    public Set<Class<? extends DataSource>> collectDatasources();

}
