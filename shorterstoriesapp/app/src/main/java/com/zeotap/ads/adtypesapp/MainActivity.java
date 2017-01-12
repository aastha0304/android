package com.zeotap.ads.adtypesapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.ImageView;
import android.graphics.Point;
import android.view.Display;

public class MainActivity extends Activity {
    static boolean personalOn;
    static String bannerUrl;
    static String interstitialUrl;
    static String landingBannerUrl;
    static int bannerImage;
    static int interstitialImage;
    static int landingBannerImage;

    static String fullText = AppData.fullText;
    static String titleText = AppData.title;
    static String synopsysText = AppData.synopsis;

    private static RadioButton targettingStatus;
    private TextView title;
    private TextView synopsys;
    private TextView subtext;
    private static ImageView bannerView;

    private static Activity thisActivity;
    private static Context mainContext;
    private void updateAdSetting(){
        if(personalOn){
            targettingStatus.setChecked(true);
            targettingStatus.setText("Targetting:On");

            bannerUrl=AppData.personalBannerUrl;
            interstitialUrl=AppData.personalInterstitialUrl;
            landingBannerUrl=AppData.personalBannerPage2Url;
            landingBannerImage=AppData.personalPage2BannerImage;
            bannerImage=AppData.personalBannerImage;
            interstitialImage=AppData.personalInterstitialImage;
        }else{
            targettingStatus.setChecked(false);
            targettingStatus.setText("Targetting:Off");

            bannerUrl=AppData.organicBannerUrl;
            interstitialUrl=AppData.organicInterstitialUrl;
            landingBannerUrl=AppData.organicBannerPage2Url;
            bannerImage=AppData.organicBannerImage;
            interstitialImage=AppData.organicInterstitialImage;
            landingBannerImage=AppData.organicPage2BannerImage;
        }
    }

    public void onTargettingChecked(View view){
        boolean checked = targettingStatus.isChecked();
        if(checked) {
            personalOn = !personalOn;
            updateAdSetting();
            MainActivity.this.finish();
            startActivity(getIntent());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mainContext = this;
        thisActivity = this;

        targettingStatus = (RadioButton) findViewById(R.id.targetting);
        updateAdSetting();

        title = (TextView) findViewById(R.id.title);
        synopsys = (TextView) findViewById(R.id.synopsis);
        subtext = (TextView) findViewById(R.id.subtext);
        bannerView = (ImageView) findViewById(R.id.bannerAd);
        title.setText(titleText);
        synopsys.setText(synopsysText);
        ImageViewHandler.handleImageView(bannerView, bannerImage, thisActivity, bannerUrl, false);
        synopsys.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent interstitial = new Intent(mainContext, Interstitial.class);
                mainContext.startActivity(interstitial);
                return true;
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
