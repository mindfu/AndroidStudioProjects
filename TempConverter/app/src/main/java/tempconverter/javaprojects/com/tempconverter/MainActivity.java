package tempconverter.javaprojects.com.tempconverter;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText tempEditText;
    private Button cButton;
    private Button fButton;
    private TextView showTempTextView;

    DecimalFormat round = new DecimalFormat("0.0");

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = (EditText)findViewById(R.id.editTextId);
        cButton = (Button)findViewById(R.id.cButtonId);
        fButton = (Button)findViewById(R.id.fButtonId);
        showTempTextView = (TextView)findViewById(R.id.showResultTextView);

        // event listeners
        cButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //call convertToCelsius
                String editTextVal = tempEditText.getText().toString();

                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                } else {

                    // is good
                    double doubleEditText = Double.parseDouble(editTextVal);
                    double convertedVal = convertToCelsius(doubleEditText);
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult+" C ");


                }
            }
        });

        fButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //call convertToFahrenheit
                String editTextVal = tempEditText.getText().toString();

                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                } else {

                    // is good
                    double doubleEditText = Double.parseDouble(editTextVal);
                    double convertedVal = convertToFahrenheit(doubleEditText);
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult +" F ");
                }
            }
        });


    }

    public double convertToCelsius(double farVal){
        double resultCel;
        resultCel = (farVal - 32)*5/9;
        return resultCel;
    }

    public double convertToFahrenheit(double celVal){
        double resultFar;
        resultFar = (celVal * 5/9)+ 32;
        return resultFar;
    }

}
