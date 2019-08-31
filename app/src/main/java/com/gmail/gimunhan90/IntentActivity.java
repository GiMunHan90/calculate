package com.gmail.gimunhan90;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Log.d("test",getIntent().getStringExtra("name"));
    }
}
