package com.example.pkelly.travelapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends AppCompatActivity {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    private TextView txtUsername;
    private TextView txtPassword;
    Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener ((View.OnClickListener) Login.this);
    }

    public void onClick(View v) {
        checkAccount();
    }

    public void checkAccount() {
        //insert sign in Function
        String sql = "select * from user where username=? and password=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(txtUsername.getText()));
            pst.setString(2, String.valueOf(txtPassword.getText()));
            rs = pst.executeQuery();
            if (rs.next()) {
                rs.close();
                pst.close();

                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);

            } else {
                Toast.makeText(this, "Incorrect Username and Password", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e1) {
            Log.v(null, e1.getMessage());
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e1) {
                Log.v(null, e1.getMessage());
            }
        }
    }
}
