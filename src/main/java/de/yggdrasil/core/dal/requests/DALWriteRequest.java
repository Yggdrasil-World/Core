package de.yggdrasil.core.dal.requests;

import de.yggdrasil.core.dal.data.DALWriteScope;
import de.yggdrasil.core.dal.data.DataSource;

public interface DALWriteRequest<T> extends DALRequest{

    DALWriteScope getScope();

    DataSource getDataSource();

    String getKey();

    T getData();

}
