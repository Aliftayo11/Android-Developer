package com.example.hellotoasthomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";

    public static final int TEXT_REQUEST = 1;

    private int mCount = 0 ;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_couint);
    }

    public void showToast(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity2.class);
        String count = mShowCount.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, count);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}
