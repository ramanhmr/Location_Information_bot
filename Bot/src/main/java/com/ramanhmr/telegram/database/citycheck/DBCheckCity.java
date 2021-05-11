package com.ramanhmr.telegram.database.citycheck;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCheckCity {
    private Connection connection;

    public DBCheckCity(Connection connection) {
        this.connection = connection;
    }

    public boolean hasCity(String city) throws SQLException, NoCityException {
        Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT id FROM city_info WHERE name='" + city + "'");
        if (!resultSet.next()) throw new NoCityException();
        return resultSet.next();
    }
}
