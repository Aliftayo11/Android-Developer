package id.ac.poliban.e020320046.counterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mShowCount;
    private EditText mEditText;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mShowCount = (TextView) findViewById(R.id.showcount);
        mEditText = findViewById(R.id.editText);

        if (savedInstanceState != null) {
            mEditText.setText(savedInstanceState.getString("edit_text"));
        }
    }

    public void btcount(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("edit_text", mEditText.getText().toString());
    }
}