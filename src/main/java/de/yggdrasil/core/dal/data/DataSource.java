package de.yggdrasil.core.dal.data;

public interface DataSource {

    DALWriteScope[] getSupportedWriteScopes();

    byte[] getBytes(String identifier);

    //TODO define methods in issue 49

}
