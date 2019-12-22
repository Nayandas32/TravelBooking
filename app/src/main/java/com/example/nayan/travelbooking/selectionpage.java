package com.example.nayan.travelbooking;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class selectionpage extends AppCompatActivity {

    private int INTERNET_PERMISSION_CODE=1;


    Button sbtn1;
    Button sbtn2;
    Button sbtn3;
    Button sbtn4;
    Button sbtn5;
    Button sbtn6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectionpage);

        sbtn1=(Button) findViewById(R.id.sbtn1);
        sbtn2=(Button) findViewById(R.id.sbtn2);
        sbtn3=(Button) findViewById(R.id.sbtn3);
        sbtn4=(Button) findViewById(R.id.sbtn4);
        sbtn5=(Button) findViewById(R.id.sbtn5);
        sbtn6=(Button) findViewById(R.id.sbtn6);



        sbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                opentemp1();
                if (ContextCompat.checkSelfPermission(selectionpage.this,Manifest.permission.INTERNET)== PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(selectionpage.this,"You have already Granted permission",Toast.LENGTH_SHORT).show();
                }
                else{
                    requestinternetpermission();
                }
            }
        });



        sbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentemp2();
            }
        });


        sbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentemp3();
            }
        });


        sbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentemp4();
            }
        });


        sbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentemp5();
            }
        });



        sbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentemp6();
            }
        });

    }

    public void opentemp1(){
        Intent intent = new Intent(this,sajek.class);
        startActivity(intent);
    }

    public void opentemp2(){
        Intent intent = new Intent(this,saint.class);
        startActivity(intent);
    }

    public void opentemp3(){
        Intent intent = new Intent(this,debotakhum.class);
        startActivity(intent);
    }

    public void opentemp4(){
        Intent intent = new Intent(this,tanguar.class);
        startActivity(intent);
    }

    public void opentemp5(){
        Intent intent = new Intent(this,moinotghat.class);
        startActivity(intent);
    }

    public void opentemp6(){
        Intent intent = new Intent(this,shundarban.class);
        startActivity(intent);
    }

    private void requestinternetpermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.INTERNET)){

            new AlertDialog.Builder(this)
                    .setTitle("Permission needed").setMessage("This permission is needed because of Internet Connection")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            ActivityCompat.requestPermissions(selectionpage.this,new String[] {Manifest.permission.INTERNET},INTERNET_PERMISSION_CODE);

                        }
                    })
                    .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.INTERNET},INTERNET_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == INTERNET_PERMISSION_CODE){
            if (grantResults.length >0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){

                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();

            }
        }
    }
}
