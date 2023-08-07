package de.yggdrasil.core.dal.data.datasources;

import de.yggdrasil.core.Main;
import de.yggdrasil.core.dal.data.DALWriteScope;
import de.yggdrasil.core.dal.data.DataSource;
import de.yggdrasil.core.strings.DatabaseStrings;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.HashMap;

public class ConfigDB implements DataSource {


    private final Connection connection;
    private final HashMap<String, PreparedStatement> preparedStatements = new HashMap<>();

    public ConfigDB() {
        try {
            connection = setupConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.initialSetup();
    }

    private Connection setupConnection() throws SQLException {
        var DB_SERVER = System.getProperty(DatabaseStrings.DatabaseEnv.ConfigDB.DB_SERVER);
        var DB_PORT = System.getProperty(DatabaseStrings.DatabaseEnv.ConfigDB.DB_PORT);
        var DB_USER = System.getProperty(DatabaseStrings.DatabaseEnv.ConfigDB.DB_USER);
        var DB_PASSWORD = System.getProperty(DatabaseStrings.DatabaseEnv.ConfigDB.DB_PASSWORD);
        return DriverManager.getConnection(DatabaseStrings.CONNECTION_STRING
                .formatted(DatabaseStrings.Databases.POSTGRES, DB_SERVER, DB_PORT), DB_USER, DB_PASSWORD);
    }

    private void initialSetup() {
        try {
            this.createStatements();
            this.createTables();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createStatements() throws SQLException {
        this.preparedStatements.put(StatementQuerries.CREATE_SCHEMA,
                this.connection.prepareStatement(StatementQuerries.CREATE_SCHEMA));
        this.preparedStatements.put(StatementQuerries.CREATE_TABLE,
                this.connection.prepareStatement(StatementQuerries.CREATE_TABLE));
        this.preparedStatements.put(StatementQuerries.SELECT_VALUE,
                this.connection.prepareStatement(StatementQuerries.SELECT_VALUE));
        this.preparedStatements.put(StatementQuerries.INSERT_VALUE,
                this.connection.prepareStatement(StatementQuerries.INSERT_VALUE));
    }

    private void createTables() throws SQLException {
        this.preparedStatements.get(StatementQuerries.CREATE_SCHEMA).execute();
        this.preparedStatements.get(StatementQuerries.CREATE_TABLE).execute();
    }

    @Override
    public DALWriteScope[] getSupportedWriteScopes() {
        return new DALWriteScope[]{DALWriteScope.PERSISTENT};
    }

    @Override
    public byte[] getBytes(String identifier) {
        try {
            this.preparedStatements.get(StatementQuerries.SELECT_VALUE).setString(1, identifier);
            ResultSet resultSet = this.preparedStatements.get(StatementQuerries.SELECT_VALUE).executeQuery();
            resultSet.next();
            String result = resultSet.getString("value");
            return result.getBytes(StandardCharsets.UTF_8);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public void writeBytes(String key, byte[] value) {
        try {
            PreparedStatement statement = this.preparedStatements.get(StatementQuerries.INSERT_VALUE);
            statement.setString(1, key);
            statement.setString(2, new String(value, StandardCharsets.UTF_8));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private interface StatementQuerries {

        String schema = System.getProperty(DatabaseStrings.DatabaseEnv.ConfigDB.DB_SCHEMA);
        String CREATE_SCHEMA = "CREATE SCHEMA IF NOT EXISTS %s".formatted(schema);
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS %s.config_values (key TEXT PRIMARY KEY, value TEXT)".formatted(schema);
        String SELECT_VALUE = "SELECT value FROM %s.config_values WHERE key = ?".formatted(schema);
        String INSERT_VALUE = "INSERT INTO %s.config_values (key, value) VALUES (?,?)".formatted(schema);
    }

}
