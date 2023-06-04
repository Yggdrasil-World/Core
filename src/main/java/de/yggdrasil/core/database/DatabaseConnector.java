package de.yggdrasil.core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class DatabaseConnector {

    private static final DatabaseConnector instance = new DatabaseConnector();
    private Connection connection;
    private final HashMap<String, PreparedStatement> preparedStatements = new HashMap<>();

    private DatabaseConnector(){
        try {
            this.initConnection();
            this.prepareStatements();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void initConnection() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://url:port[/databasename]","username","pw");
    }

    private void prepareStatements() throws SQLException {
        this.preparedStatements.put("", this.connection.prepareStatement(""));
    }

    public static DatabaseConnector getInstance() {
        return instance;
    }

}
