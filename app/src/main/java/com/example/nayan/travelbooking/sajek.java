package com.example.nayan.travelbooking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class sajek extends AppCompatActivity {

    Button btn;
    public  WebView wb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sajek);

        btn=(Button) findViewById(R.id.regs);
        wb = (WebView) findViewById(R.id.WB);

        String video_link="<iframe width=\"420\" height=\"159\" src=\"https://www.youtube.com/embed/qDzRdH4nEoQ\"" +
                " frameborder=\"0\" " +
                "allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";

        wb.setWebViewClient( new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;

            }
        });
        WebSettings ws = wb.getSettings() ;
        ws.setJavaScriptEnabled(true);
        wb.loadData(video_link , "text/html" , "utf-8");



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operreg();
            }
        });

    }
    public void operreg(){

        Intent intent = new Intent(this,booking.class);
        startActivity(intent);

    }


}
