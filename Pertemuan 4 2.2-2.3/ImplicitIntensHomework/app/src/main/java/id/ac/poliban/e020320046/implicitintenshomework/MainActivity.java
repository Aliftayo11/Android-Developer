package id.ac.poliban.e020320046.implicitintenshomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;
    private static final int CAMERA_REQUEST = 1888;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);

        setContentView(R.layout.activity_main);

        imageView = (ImageView) this.findViewById(R.id.image);

        Button photoButton = (Button) this.findViewById(R.id.button_picture);

        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cameraIntent, CAMERA_REQUEST);

            }

        });

    }




    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();

        Uri adressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, adressUri);

        if (intent.resolveActivity(getPackageManager()) != null ) {
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.edittext_share)
                .setText(txt)
                .startChooser();
    }

    public void handleImplicitIntent(View view) {
    }
}

