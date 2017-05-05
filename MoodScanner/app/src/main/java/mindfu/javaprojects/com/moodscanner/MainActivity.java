package mindfu.javaprojects.com.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView thumbPrint;
    private TextView result;
    private AnimationDrawable thumbAnimation;
    private String[] moodResults;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodResults = new String[]{
                "Someone is hangry",
                "Sunshiney happy",
                "Ummmm..... no",
                "Happy go lucky",
                "Today is not your day",
                "Smile - it's contageous",
                "In the clouds",
                "Pensive",
                "Sad",
                "Excited!"
        };

        thumbPrint = (ImageView)findViewById(R.id.thumbPrint);
        thumbPrint.setBackgroundResource(R.drawable.thumb_animation);
        thumbAnimation = (AnimationDrawable)thumbPrint.getBackground();

        result = (TextView)findViewById(R.id.resultText);

        thumbPrint.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                thumbAnimation.start();
                //Toast.makeText(getApplicationContext(), "Hello there", Toast.LENGTH_LONG).show();
                showResult();
                return true;
            }
        });



    }

    public void showResult(){

        mRunnable = new Runnable() {
            @Override
            public void run() {
                int rand = (int)(Math.random() * moodResults.length);
                result.setText(moodResults[rand]);

                thumbAnimation.stop();
            }
        };

        Handler mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 1500); //1.5 seconds

    }

}
