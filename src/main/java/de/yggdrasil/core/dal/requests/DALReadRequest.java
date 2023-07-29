package de.yggdrasil.core.dal.requests;

import de.yggdrasil.core.dal.data.DataSource;

public interface DALReadRequest extends DALRequest{

    Class<? extends DataSource> getDatasource();

    String getIdentifier();

    Class getTargetType();

}
