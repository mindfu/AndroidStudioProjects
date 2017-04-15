package myedittexthighestmountain.javaprojects.com.myedittext;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText myEditText;
    private TextView showMyNameTextView;
    private Button showButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditText = (EditText)findViewById(R.id.editTextId);
        showMyNameTextView = (TextView)findViewById(R.id.textViewId);
        showButton = (Button)findViewById(R.id.buttonId);

        showButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String myName = null;
                myName = myEditText.getText().toString();
                showMyNameTextView.setText(myName);
            }
        });
    }
}
