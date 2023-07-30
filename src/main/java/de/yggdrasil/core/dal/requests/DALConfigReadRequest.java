package de.yggdrasil.core.dal.requests;

import de.yggdrasil.core.dal.data.DataSource;
import de.yggdrasil.core.dal.data.datasources.ConfigDB;

public class DALConfigReadRequest implements DALReadRequest{

    private final String configKey;

    public DALConfigReadRequest(String configKey){
        this.configKey = configKey;
    }

    @Override
    public DALRequestType getRequestType() {
        return DALRequestType.CONFIG;
    }

    @Override
    public Class<? extends DataSource> getDatasource() {
        return ConfigDB.class;
    }

    @Override
    public String getIdentifier() {
        return this.configKey;
    }

    @Override
    public Class getTargetType() {
        return String.class;
    }
}
