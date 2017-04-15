package showmethebio.javaprojects.com.myradiobuttons;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioChoiceButton;
    private TextView showChoiceTextView;
    private Button showButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup textview
        showChoiceTextView = (TextView)findViewById(R.id.showTextView);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroupId);

        showButton = (Button)findViewById(R.id.showChoiceBtn);
        showButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int selectedOption = radioGroup.getCheckedRadioButtonId();
                radioChoiceButton = (RadioButton)findViewById(selectedOption);
                showChoiceTextView.setText(radioChoiceButton.getText());

            }
        });

    }
}
