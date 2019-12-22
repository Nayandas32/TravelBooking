package com.example.nayan.travelbooking;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class booking extends AppCompatActivity implements View.OnClickListener {
    DatabaseHelper dataBaseHelper;

    private EditText Email,Phn,Place,Live,Pick,money;
    private Button Confirm,Cencle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        dataBaseHelper =new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase=dataBaseHelper.getWritableDatabase();

        Email=(EditText) findViewById(R.id.email);
        Phn=(EditText) findViewById(R.id.phn);
        Place=(EditText) findViewById(R.id.place);
        Live=(EditText) findViewById(R.id.live);
        Pick=(EditText) findViewById(R.id.pick);
        money=(EditText) findViewById(R.id.Money);


        Confirm=(Button) findViewById(R.id.confirm);
        Cencle=(Button) findViewById(R.id.cancle);

        Confirm.setOnClickListener(this);
        Cencle.setOnClickListener(this);



        Email.addTextChangedListener(regTextwatcher);
        Phn.addTextChangedListener(regTextwatcher);
        Place.addTextChangedListener(regTextwatcher);
        Live.addTextChangedListener(regTextwatcher);
        Pick.addTextChangedListener(regTextwatcher);
        money.addTextChangedListener(regTextwatcher);


    }

    private TextWatcher regTextwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String cemail = Email.getText().toString().trim();
            String cphn = Phn.getText().toString().trim();
            String cplace = Place.getText().toString().trim();
            String clive = Live.getText().toString().trim();
            String cpic = Pick.getText().toString().trim();
            String cmoney = money.getText().toString().trim();


            Confirm.setEnabled(!cemail.isEmpty() && !cphn.isEmpty() && !cplace.isEmpty() && !clive.isEmpty() && !cpic.isEmpty() && !cmoney.isEmpty());



        }

        @Override
        public void afterTextChanged(Editable s) {


        }
    };



































    @Override
    public void onClick(View v) {
        String Emailadd = Email.getText().toString();
        String Phonenumber = Phn.getText().toString();
        String placego = Place.getText().toString();
        String placelive = Live.getText().toString();
        String pickup = Pick.getText().toString();
        String pay = money.getText().toString();



        if (v.getId()==R.id.confirm)
        {
            long rowid1= dataBaseHelper.insertdata1(Emailadd,Phonenumber,placego,placelive,pickup,pay);

            if (rowid1==-1)
            {
                Toast.makeText(getApplicationContext(),"unSuccessfully  : ",Toast.LENGTH_LONG).show();
            }
            else {

                Toast.makeText(getApplicationContext(),"Row "+rowid1+"Successfully inserted : ",Toast.LENGTH_LONG).show();

            }

        }

        if (v.getId()==R.id.cancle)
        {
            Cursor resultset=dataBaseHelper.displayalldata();
            if (resultset.getCount()==0)
            {
                showData("Error" ,"no data found");

            }
            StringBuffer stringBuffer = new StringBuffer();

            while (resultset.moveToNext())

            {
                stringBuffer.append("Email: "+resultset.getString(0)+"\n");
                stringBuffer.append("Phone: "+resultset.getString(1)+"\n");
                stringBuffer.append("Place where you want to go: "+resultset.getString(2)+"\n");
                stringBuffer.append("Place where you live: "+resultset.getString(3)+"\n");
                stringBuffer.append("Pick up point: "+resultset.getString(4)+"\n");
                stringBuffer.append("payment: "+resultset.getString(5)+"\n");



            }
            showData("Booking List",stringBuffer.toString());

        }




    }
    public void showData(String title,String data)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(data);
        builder.setCancelable(true);
        builder.show();

    }

}
