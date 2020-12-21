package com.example.moviecatalog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends MainActivity{

    public static final String EXTRA_DETAIL = "extra_detail";
    public static final String EXTRA_TTL = "extra_ttl";
    public static final String EXTRA_TINGGI = "extra_tinggi";
    public static final String EXTRA_PASANGAN = "extra_pasangan";
    TextView tvDataReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDataReceived = findViewById(R.id.detail);

        String detail = getIntent().getStringExtra(EXTRA_DETAIL);
        String ttl = getIntent().getStringExtra(EXTRA_TTL);
        String tinggi = getIntent().getStringExtra(EXTRA_TINGGI);
        String pasangan = getIntent().getStringExtra(EXTRA_PASANGAN);

        String text = detail;
        tvDataReceived.setText(text);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Aqua Man");
        }
    }
}
