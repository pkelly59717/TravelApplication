package com.example.pkelly.travelapplication;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by paolo on 06-Mar-18.
 */

public class DBConnect {

    public static Connection conn = null;

    public static Connection ConnectDB () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydayplanner", "root", "");
            return conn;
        }catch(Exception e) {
            Log.v("unable to connect", e.getMessage());
            

        }
        return null;
    }
}
