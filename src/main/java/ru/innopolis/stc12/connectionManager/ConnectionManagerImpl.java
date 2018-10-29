package ru.innopolis.stc12.connectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerImpl implements ConnectionManager {
    private static ConnectionManager connectionManager;

    public ConnectionManagerImpl() {
    }

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerImpl();
        }
        return connectionManager;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://pathToBase",
                    "dbLogin",
                    "dbPassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
