package mybuttons.javaprojects.com.mybuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button myButton;
    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button)findViewById(R.id.buttonId);
        myTextView = (TextView)findViewById(R.id.textViewId);

        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                myTextView.setText("Hello there!");
                //Toast.makeText(getApplicationContext(), "I was clicked!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
