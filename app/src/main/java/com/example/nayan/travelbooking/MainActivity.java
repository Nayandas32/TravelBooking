package com.example.nayan.travelbooking;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseHelper dataBaseHelper;
    TextView user, password;
    Button login, reg, About;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getWritableDatabase();

        user = (TextView) findViewById(R.id.usname);
        password = (TextView) findViewById(R.id.pass);

        login = (Button) findViewById(R.id.login);
        reg = (Button) findViewById(R.id.reg);
        About = (Button) findViewById(R.id.about);


        login.setOnClickListener(this);
        reg.setOnClickListener(this);


        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentemp1();
            }
        });


    }

    @Override
    public void onClick(View v) {
        String userers = user.getText().toString();
        String passs = password.getText().toString();
        try {

            if (v.getId() == R.id.login) {
                Boolean result = dataBaseHelper.findpassword(userers, passs);
                if (result == true) {
                    Intent intent = new Intent(MainActivity.this, Splash.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Username and password didnt match", Toast.LENGTH_LONG).show();
                }
            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), " Database problem occour  ", Toast.LENGTH_LONG).show();

        }


        if (v.getId() == R.id.reg) {
            Intent intent = new Intent(this, Reg.class);
            startActivity(intent);

        }
    }


    public void opentemp1() {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}




