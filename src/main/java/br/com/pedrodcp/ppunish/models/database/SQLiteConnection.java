package br.com.pedrodcp.ppunish.models.database;

import br.com.pedrodcp.ppunish.pPunish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection implements ConnectionModel {

    @Override
    public Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:" + pPunish.getInstance().database);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
