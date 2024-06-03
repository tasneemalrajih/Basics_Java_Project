package org.example.HW4;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnPoolConfig {

    private static String url = "jdbc:sqlite:C:\\Users\\dev\\Desktop\\SDAIA-Java-Course\\JavaBasics\\HomeWork\\hr.db";

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl(url);
        ds = new HikariDataSource(config);
    }


    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


}
