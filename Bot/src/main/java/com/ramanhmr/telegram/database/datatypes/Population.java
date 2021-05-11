package com.ramanhmr.telegram.database.datatypes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;

public class Population implements DataTypes {
    private long numberPopulation;

    private TypesOfData dataType = TypesOfData.POPULATION;
    private String dbCall = dataType.getDbCall();

    NumberFormat format = NumberFormat.getInstance(new Locale("fr", "FR"));

    public Population(Connection connection, String city) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT " + dbCall + " FROM city_info WHERE name='" + city + "'");
        resultSet.next();
        numberPopulation = resultSet.getLong(1);
    }


    @Override
    public String toString() {
        return "Численность населения: " + format.format(numberPopulation) + " чел.";
    }
}
