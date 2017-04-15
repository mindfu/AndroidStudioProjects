package uiviewsxml.javaprojects.com.myactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private TextView myTextView;
    private Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myTextView = (TextView)findViewById(R.id.textView);
        goBackButton = (Button)findViewById(R.id.button2);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            String myString = extras.getString("activityOne");
            myTextView.setText(myString);
        }

        goBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData","From SecondActivity");
                returnIntent.putExtra("somthingElse","This is something else");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}
