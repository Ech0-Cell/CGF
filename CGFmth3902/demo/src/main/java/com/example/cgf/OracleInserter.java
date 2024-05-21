package com.example.cgf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class OracleInserter {
    private Connection connection;

    public OracleInserter(String dbUrl, String dbUser, String dbPassword) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public void insertUsageRecord(String record) throws SQLException {
        String procedureCall = "{call INSERT_USAGE_RECORD(?)}";
        try (CallableStatement stmt = connection.prepareCall(procedureCall)) {
            stmt.setString(1, record);
            stmt.execute();
        }
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
