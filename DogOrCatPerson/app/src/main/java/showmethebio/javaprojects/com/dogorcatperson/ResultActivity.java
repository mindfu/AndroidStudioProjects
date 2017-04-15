package showmethebio.javaprojects.com.dogorcatperson;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView result;
    private ImageView imagesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = (TextView) findViewById(R.id.resultTextView);
        imagesView = (ImageView) findViewById(R.id.petImageView);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            int catResult = extras.getInt("catCounter");
            int dogResult = extras.getInt("dogCounter");

            if (catResult > dogResult) {
                result.setText("Cat Person!");
                imagesView.setImageDrawable(getResources().getDrawable(R.drawable.icon_lg_cat));
            } else if (dogResult > catResult) {
                result.setText("Dog Person!");
                imagesView.setImageDrawable(getResources().getDrawable(R.drawable.icon_lg_dog));
            } else {
                result.setText("Neither!");
            }

        }
    }
}