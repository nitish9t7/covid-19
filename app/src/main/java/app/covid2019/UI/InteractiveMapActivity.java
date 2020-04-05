package app.covid2019.UI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import app.covid2019.R;

public class InteractiveMapActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactive_map);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Interactive Map");
        WebView wv = findViewById(R.id.root_web_view);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("file:///android_asset/index2.html");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
