package de.yggdrasil.core.dal.requests;

import de.yggdrasil.core.dal.data.DataSource;

public class DALConfigRequest implements DALReadRequest{

    private final String configKey;

    public DALConfigRequest(String configKey){
        this.configKey = configKey;
    }

    @Override
    public DALRequestType getRequestType() {
        return DALRequestType.CONFIG;
    }

    @Override
    public DataSource getDatasource() {
        //TODO
        return null;
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
