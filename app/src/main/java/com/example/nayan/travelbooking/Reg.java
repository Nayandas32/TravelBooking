package com.example.nayan.travelbooking;

import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Reg extends AppCompatActivity implements View.OnClickListener{
    DatabaseHelper dataBaseHelper;
    private TextView Bdate;
    private EditText Fname,Lname,Email,PHN,Pass,Gender;

   private Button btn,Submit,Back;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);





        dataBaseHelper =new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase=dataBaseHelper.getWritableDatabase();


        Bdate=(TextView) findViewById(R.id.tview);
        Fname=(EditText) findViewById(R.id.fname);
        Lname=(EditText) findViewById(R.id.lname);
        Email=(EditText) findViewById(R.id.email);
        PHN=(EditText) findViewById(R.id.phn);
        Pass=(EditText) findViewById(R.id.pass);
        Gender=(EditText) findViewById(R.id.gender);


        btn=(Button) findViewById(R.id.btn);
        Submit=(Button) findViewById(R.id.submit);




        Fname.addTextChangedListener(regTextwatcher);
        Lname.addTextChangedListener(regTextwatcher);
        Email.addTextChangedListener(regTextwatcher);
        PHN.addTextChangedListener(regTextwatcher);
        Pass.addTextChangedListener(regTextwatcher);
        Gender.addTextChangedListener(regTextwatcher);
        Bdate.addTextChangedListener(regTextwatcher);









        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int day=c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR); DatePickerDialog dpd = new DatePickerDialog(Reg.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Bdate.setText(dayOfMonth + "/" + (month +1) + "/" +year);    }
                },day,month,year);dpd.show();
            }
        });
        Submit.setOnClickListener(this);

    }

    private TextWatcher regTextwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String cname = Fname.getText().toString().trim();
            String claname = Lname.getText().toString().trim();
            String cemail = Email.getText().toString().trim();
            String cphn = PHN.getText().toString().trim();
            String cpass = Pass.getText().toString().trim();
            String cgender = Gender.getText().toString().trim();
            String cbdate = Bdate.getText().toString().trim();

            Submit.setEnabled(!cname.isEmpty() && !claname.isEmpty() && !cemail.isEmpty() && !cphn.isEmpty() && !cpass.isEmpty() && !cgender.isEmpty() && !cbdate.isEmpty());



        }

        @Override
        public void afterTextChanged(Editable s) {


        }
    };


    @Override
    public void onClick(View v) {

        String firstname = Fname.getText().toString();
        String lastname = Lname.getText().toString();
        String emailad = Email.getText().toString();
        String phonenumber = PHN.getText().toString();
        String password = Pass.getText().toString();
        String gender = Gender.getText().toString();
        String bdate = Bdate.getText().toString();


        if (v.getId()==R.id.submit)
        {
            long rowid= dataBaseHelper.insertdata(firstname,lastname,emailad,phonenumber,gender,bdate,password);

            if (rowid==-1)
            {
                Toast.makeText(getApplicationContext(),"unSuccessfully  : ",Toast.LENGTH_LONG).show();
            }
            else {

                Toast.makeText(getApplicationContext(),"Row "+rowid+"Successfully inserted : ",Toast.LENGTH_LONG).show();

            }

        }



    }
}
