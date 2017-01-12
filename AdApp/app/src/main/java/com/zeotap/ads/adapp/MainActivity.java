package com.zeotap.ads.adapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.util.DisplayMetrics;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private Button buttonBanner;
    private Button buttonInterstitial;

    //banner
    //interstitial
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        Log.e("width", "w"+width);
        Log.e("height", "h"+height);
        System.out.println(width);
        System.out.println(height);
        buttonBanner = (Button) findViewById(R.id.buttonBanner);
        buttonBanner.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, WebViewActivity.class);
                String html = "<div style=\"text-align:center; width:100%; height:100%\" scroll=no> <iframe src=\"http://ec2-54-255-233-250.ap-southeast-1.compute.amazonaws.com/banner_300x250.html\" style=\"border: 0; width: 310px; height: 260px\" frameboreder=\"0\" scroll=no ></iframe>  </div>";
                intent.putExtra("iframeContent", html);
                startActivity(intent);
            }

        });
        buttonInterstitial = (Button) findViewById(R.id.buttonInterstitial);
        buttonInterstitial.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, WebViewActivity.class);
                //http://lh4.ggpht.com/1Rw1DEbRB87sJ3sdx1g8yMrmx-Lt-VgYqhYolXv_y0hAZxbqoA1HAw1qT-JLk68-dHEL-QHmAA=w300

                String html = "<div style=\"text-align:center; width:100%; height:100%\" scroll=no> <iframe src=\"http://lh4.ggpht.com/1Rw1DEbRB87sJ3sdx1g8yMrmx-Lt-VgYqhYolXv_y0hAZxbqoA1HAw1qT-JLk68-dHEL-QHmAA=w300\" style=\"border: 0; width: 303px; height: 100%; padding:0px; margin: 0px\" frameboreder=\"0\" scroll=no allowfullscreen=true autobuffer allowtransparency=\"true\"></iframe> </div>";
                intent.putExtra("iframeContent", html);
                startActivity(intent);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
