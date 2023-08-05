package de.yggdrasil.core.strings;

public interface DatabaseStrings {

    String CONNECTION_STRING = "jdbc:%s://%s:%s/";

    interface Databases {
        String POSTGRES = "postgresql";
    }

    interface DatabaseEnv {

        interface ConfigDB {
            String DB_SERVER = "DB_SERVER_CONFIG";
            String DB_PORT = "DB_PORT_CONFIG";
            String DB_SCHEMA = "DB_SCHEMA_CONFIG";
            String DB_USER = "DB_USER_CONFIG";
            String DB_PASSWORD = "DB_PASSWORD_CONFIG";
        }

    }

}
