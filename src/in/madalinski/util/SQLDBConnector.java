/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.madalinski.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mike
 */
public class SQLDBConnector {

    public void connect() throws ClassNotFoundException, SQLException {
        final String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);

        final String dbPath = "jdbc:mysql://localhost:3306/world";
        Connection conn = DriverManager.getConnection(dbPath, "root", "password");

        Statement statement = conn.createStatement();
        final String sqlQuery = "SELECT Name, Population FROM city";
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        String cityName = null;
        int cityPopulation = 0;
        while (resultSet.next()) {
            cityName = resultSet.getString("Name");
            cityPopulation = resultSet.getInt("Population");
            System.out.println(cityName + " " + cityPopulation);
        }

        if (statement != null) {
            statement.close();
        }

        if (resultSet != null) {
            resultSet.close();
        }

        if (conn != null) {
            conn.close();
        }
    }

}
