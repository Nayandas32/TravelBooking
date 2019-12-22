package com.example.nayan.travelbooking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class shundarban extends AppCompatActivity {
    Button btn;
    private WebView wbsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shundarban);
        btn=(Button) findViewById(R.id.regs);

        btn=(Button) findViewById(R.id.regs);





        wbsu = (WebView) findViewById(R.id.WBSU);

        String video_link="<iframe width=\"420\" height=\"159\" src=\"https://www.youtube.com/embed/iTugvVqbo-o\"" +
                " frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\"" +
                " allowfullscreen></iframe>";

        wbsu.setWebViewClient( new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;

            }
        });
        WebSettings ws = wbsu.getSettings() ;
        ws.setJavaScriptEnabled(true);
        wbsu.loadData(video_link , "text/html" , "utf-8");

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
