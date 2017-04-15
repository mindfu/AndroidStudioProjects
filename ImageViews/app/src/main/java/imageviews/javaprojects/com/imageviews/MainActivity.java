package imageviews.javaprojects.com.imageviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView appleImage;
    private TextView showTextView;

    private static final String TAG = "Main Activity";
    private static final String TAG = "Another Hello!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appleImage = (ImageView)findViewById(R.id.imageView);
        showTextView = (TextView)findViewById(R.id.textView);

        appleImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showTextView.setText("Apple is shit!");

                Log.d(TAG, "Hello from Here!");
            }
        });
    }
}
