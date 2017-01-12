package com.zeotap.ads.adtypesapp;

/**
 * Created by aastha on 29/10/15.
 */
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ImageViewHandler {
    static void handleImageView(ImageView imgView, int img, final Activity activity, final String url, final boolean killCurrent){
        imgView.setImageResource(img);
        imgView.setAdjustViewBounds(true);

        imgView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent adResult = new Intent(activity, LandingPage.class);
                adResult.putExtra("url", url);
                /*adResult.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                adResult.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                adResult.addFlags(Intent.FLAG_FROM_BACKGROUND);*/
                activity.startActivity(adResult);
                if(killCurrent)
                    activity.finish();
                return true;
            }
        });
    }
}
