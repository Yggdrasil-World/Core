package de.yggdrasil.core.dal.requests;

import de.yggdrasil.core.dal.data.DALWriteScope;
import de.yggdrasil.core.dal.data.DataSource;
import de.yggdrasil.core.dal.data.DatasourceLibrary;
import de.yggdrasil.core.dal.data.datasources.ConfigDB;

public class DALConfigWriteRequest implements DALWriteRequest<String>{

    private final String key;
    private final String value;

    public DALConfigWriteRequest(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public DALRequestType getRequestType() {
        return DALRequestType.CONFIG;
    }

    @Override
    public DALWriteScope getScope() {
        return DALWriteScope.PERSISTENT;
    }

    @Override
    public DataSource getDataSource() {
        return DatasourceLibrary.get().getDatasource(ConfigDB.class);
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getData() {
        return this.value;
    }
}
