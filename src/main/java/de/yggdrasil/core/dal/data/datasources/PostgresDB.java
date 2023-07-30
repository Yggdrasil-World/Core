package de.yggdrasil.core.dal.data.datasources;

import de.yggdrasil.core.dal.data.DALWriteScope;
import de.yggdrasil.core.dal.data.DataSource;

public class PostgresDB implements DataSource {
    @Override
    public DALWriteScope[] getSupportedWriteScopes() {
        return new DALWriteScope[0];
    }

    @Override
    public byte[] getBytes(String identifier) {
        return new byte[0];
    }
}
