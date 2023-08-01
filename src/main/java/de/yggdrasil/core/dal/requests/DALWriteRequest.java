package de.yggdrasil.core.dal.requests;

import de.yggdrasil.core.dal.data.DALWriteScope;
import de.yggdrasil.core.dal.data.DataSource;

public interface DALWriteRequest<T extends DataSource,V> extends DALRequest{

    DALWriteScope getScope();

    T getDataSource();

    String getKey();

    V getData();

}
