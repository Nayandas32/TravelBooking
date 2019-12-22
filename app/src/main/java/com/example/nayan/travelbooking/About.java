package com.example.nayan.travelbooking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Element adsElement = new Element();


        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.d)
                .setDescription("Hi, Its me Nayan. A beginner level android developer. This is my first project")
                .addItem(new Element().setTitle("Version 1.0"))
                .addItem(adsElement)
                .addGroup("Contect with me")
                .addEmail("nayandas1932@gmail.com")
                .addFacebook("nayan.das.0")

                .addItem(creatCopyright())
                .create();

        setContentView(aboutPage);
    }

    private Element creatCopyright() {
        Element copyright = new Element();

        final String copyrightString =String.format("Copyright %d Nayan",Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        copyright.setGravity(Gravity.CENTER);

        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;

    }
}
