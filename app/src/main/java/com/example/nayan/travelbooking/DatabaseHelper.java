package com.example.nayan.travelbooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static  final String DATABASE_NAME="travel.db";
    private static  final String TABLE_NAME_1="Reg";
    private static  final String TABLE_NAME_2="booking";

    //Reg
    private static  final String ID="_id";
    private static  final String FNAME="First";
    private static  final String LNAME="Last";
    private static  final String EMAIL="Email";
    private static  final String GENDER="Gender";
    private static  final String PHONE="Phone";
    private static  final String BDATE="BDate";
    private static  final String PASSWORD="Password";

    //booking

    private static  final String Bemail="bemail";
    private static  final String Bphn="bphn";
    private static  final String Bplace="bplce";
    private static  final String Blive="blive";
    private static  final String Bpick="bpick";
    private static  final String BPAY="Pay";





    private static  final int VERSION_NUMBER =10;

    private static  final String CREATE_TABLE_1 = "CREATE TABLE "+TABLE_NAME_1+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+FNAME+" VARCHAR(200),"+LNAME+" INTEGER,"+EMAIL+" VARCHAR(200),"+PHONE+" VARCHAR(200),"+GENDER+" VARCHAR(200),"+BDATE+" VARCHAR(200),"+PASSWORD+" VARCHAR(200) ) ;";

    private static  final String CREATE_TABLE_2 = "CREATE TABLE "+TABLE_NAME_2+"("+Bemail+" VARCHAR(200),"+Bphn+" VARCHAR(200),"+Bplace+" INTEGER,"+Blive+" VARCHAR(200),"+Bpick+" VARCHAR(200),"+BPAY+" VARCHAR(200));";
    private static final String DROP_TABLE_1="DROP TABLE IF EXISTS "+TABLE_NAME_1;
    private static final String DROP_TABLE_2="DROP TABLE IF EXISTS "+TABLE_NAME_2;
    private static final String SELECT_ALL="SELECT * FROM "+TABLE_NAME_1;
    private static final String SELECT_ALL_1="SELECT * FROM "+TABLE_NAME_2;

    private Context context;

    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            Toast.makeText(context,"onCreate : ",Toast.LENGTH_LONG).show();

            db.execSQL(CREATE_TABLE_2);
            db.execSQL(CREATE_TABLE_1);


        }
        catch (Exception e) {
            Toast.makeText(context, "Exception : " + e, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            db.execSQL(DROP_TABLE_1);
            onCreate(db);
            db.execSQL(DROP_TABLE_2);
            onCreate(db);
            Toast.makeText(context,"onupgrade : ",Toast.LENGTH_LONG).show();

        }
        catch (Exception e)
        {
            Toast.makeText(context, "Exception : " + e, Toast.LENGTH_LONG).show();

        }

    }

    //reg


    public long insertdata(String firstname,String lastname,String emailad,String phonenumber,String gender,String bdate,String password)
{
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FNAME,firstname);
        contentValues.put(LNAME,lastname);
        contentValues.put(EMAIL,emailad);
        contentValues.put(PHONE,phonenumber);
        contentValues.put(GENDER,gender);
        contentValues.put(BDATE,bdate);
        contentValues.put(PASSWORD,password);

        long rowid= sqLiteDatabase.insert(TABLE_NAME_1,null,contentValues);
        return rowid;


    }

    //booking

    public long insertdata1(String Emailadd,String Phonenumber,String placego,String placelive,String pickup,String pay)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Bemail,Emailadd);
        contentValues.put(Bphn,Phonenumber);
        contentValues.put(Bplace,placego);
        contentValues.put(Blive,placelive);
        contentValues.put(Bpick,pickup);
        contentValues.put(BPAY,pay);


        long rowid1= sqLiteDatabase.insert(TABLE_NAME_2,null,contentValues);
        return rowid1;

    }

    //login

    public boolean findpassword(String users, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
       // Cursor cr = db.rawQuery("SELECT * FROM " + TABLE_NAME_1 + " ", null);
        Cursor cr = db.rawQuery("SELECT * FROM "+TABLE_NAME_1+ " ",null);
        boolean result = false;
        if (cr.getCount() <1) {
            Toast.makeText(context, "No data", Toast.LENGTH_LONG).show();
        } else {
            while (cr.moveToNext()) {
                String EMAIL = cr.getString(3);
                String password = cr.getString(7);

                if (EMAIL.equals(users) && password.equals(pass)) {
                    result = true;
                    break;
                }
            }
        }
        return result;


    }

    //bookingdisplay

    public Cursor displayalldata()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_1,null);
        return cursor;
    }
}
