package de.yggdrasil.core.dal.data;

@DALDatasource
public interface DataSource {

    DALWriteScope[] getSupportedWriteScopes();

    byte[] getBytes(String identifier);

    void writeBytes(String key, byte[] value);

}
