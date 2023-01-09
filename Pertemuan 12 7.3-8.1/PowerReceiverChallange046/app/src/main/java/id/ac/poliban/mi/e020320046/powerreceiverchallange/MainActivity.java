package id.ac.poliban.mi.e020320046.powerreceiverchallange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private final CustomReceiver customReceiver = new CustomReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar()!=null)getSupportActionBar().setTitle("HeadsetReceiver046");

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_HEADSET_PLUG);
        this.registerReceiver(customReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(customReceiver);
        super.onDestroy();
    }
}