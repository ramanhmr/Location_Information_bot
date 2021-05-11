package com.ramanhmr.telegram.database.dataaccess;

import com.ramanhmr.telegram.database.citycheck.DBCheckCity;
import com.ramanhmr.telegram.database.citycheck.NoCityException;
import com.ramanhmr.telegram.database.datatypes.Country;
import com.ramanhmr.telegram.database.datatypes.Population;
import com.ramanhmr.telegram.database.datatypes.TypesOfData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataAccess {

    private DataAccess() {
    }

    public static String get(String cityName, TypesOfData dataType) throws SQLException, NoCityException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/location_info",
                "root",
                "12345root");
        new DBCheckCity(connection).hasCity(cityName);
        if (dataType == TypesOfData.COUNTRY) {
            return new Country(connection, cityName).toString();
        } else if (dataType == TypesOfData.POPULATION) {
            return new Population(connection, cityName).toString();
        } else {
            return "Упс, что-то пошло не так!";
        }
    }
}
