package com.zeotap.ads.adtypesapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Interstitial extends Activity {
    private ImageButton closeButton;
    private Context interContext;

    private void closeButtonActivities(){
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent detailsPage = new Intent(interContext, FullText.class);
                Interstitial.this.startActivity(detailsPage);
                Interstitial.this.finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        interContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);
        ImageView interView = (ImageView) findViewById(R.id.interView);
        int imageId = MainActivity.interstitialImage;
        ImageViewHandler.handleImageView(interView, imageId, this, MainActivity.interstitialUrl, true);
        closeButton = (ImageButton) findViewById(R.id.close);
        closeButtonActivities();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_interstitial, menu);
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

    @Override
    public void onBackPressed(){
        Intent fullText = new Intent(this, MainActivity.class);
        startActivity(fullText);
        finish();
    }
}
