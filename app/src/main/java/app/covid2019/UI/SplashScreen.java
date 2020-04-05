package app.covid2019.UI;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import app.covid2019.R;


public class SplashScreen extends AppCompatActivity {
    private ImageView logo;
    private Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                    Intent i = new Intent(SplashScreen.this, Home.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {
                }
            }
        };
        timerThread.start();
        logo=(ImageView)findViewById(R.id.imgLogo);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        logo.startAnimation(myanim);
    }

    public void setLocale(String lang){

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf,dm);
    }

}
