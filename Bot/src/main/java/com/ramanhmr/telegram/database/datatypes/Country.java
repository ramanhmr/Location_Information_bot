package com.ramanhmr.telegram.database.datatypes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Country implements DataTypes {
    private String countryName;

    private TypesOfData dataType = TypesOfData.COUNTRY;
    private String dbCall = dataType.getDbCall();

    public Country(Connection connection, String city) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT " + dbCall + " FROM city_info WHERE name='" + city + "'");
        resultSet.next();
        countryName = resultSet.getString(1);
    }

    @Override
    public String toString() {
        return "Страна: " + countryName;
    }
}
