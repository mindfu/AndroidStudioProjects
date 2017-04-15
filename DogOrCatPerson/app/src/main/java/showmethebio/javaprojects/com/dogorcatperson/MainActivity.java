package showmethebio.javaprojects.com.dogorcatperson;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private RadioGroup canineRadioGroup;
    private RadioButton canineRadioButton;
    private SeekBar seekBar;
    private TextView seekBarTextView;
    private CheckBox cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot;
    private RadioGroup droolRadioGroup;
    private RadioButton droolRadioButton;
    private Button showResultsButton;
    private int dogCounter;
    private int catCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call Setup
        setUp();

        //Seekbar
        seekBar = (SeekBar)findViewById(R.id.seekBarFeline);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarTextView.setText("Comfortableness: " + progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setUp(){

        dogCounter = 0;
        catCounter = 0;

        canineRadioGroup = (RadioGroup)findViewById(R.id.radioGroupCanine);
        droolRadioGroup = (RadioGroup)findViewById(R.id.radioGroupDrool);
        seekBarTextView = (TextView) findViewById(R.id.seekBarProgressTextView);

        //Checkboxes
        cutestCheckBoxDog = (CheckBox)findViewById(R.id.cutestDogCheckBox);
        cutestCheckBoxCat = (CheckBox)findViewById(R.id.cutestCatCheckBox);
        cutestCheckBoxParrot = (CheckBox)findViewById(R.id.cutestParrotCheckBox);

        //Process Methods
        processCutest(cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot);
        processDrool(droolRadioGroup);
        processCanines(canineRadioGroup);

        showResultsButton = (Button)findViewById(R.id.showResults);
        showResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Toast.makeText(getApplicationContext(), catCounter + " " + dogCounter, Toast.LENGTH_LONG).show();

                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("catCounter", catCounter);
                i.putExtra("dogCounter", dogCounter);
                startActivity(i);

            }
        });

    }

    public void processCutest(CheckBox dog, CheckBox cat, CheckBox parrot){
        if (dog.isChecked() && !cat.isChecked() && !parrot.isChecked()){
            dogCounter += 5;
        } else if (cat.isChecked() && !dog.isChecked() && !parrot.isChecked()) {
            catCounter += 5;
        }
    }

    public void processDrool ( final RadioGroup radioGroup ){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                int radioId = radioGroup.getCheckedRadioButtonId();

                droolRadioButton = (RadioButton)findViewById(radioId);
                if(droolRadioButton.getText().equals("Yes")){
                    dogCounter += 5;
                }
            }
        });
    }

    public void processCanines ( final RadioGroup radioGroup ){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                canineRadioButton = (RadioButton)findViewById(radioId);
                if(canineRadioButton .getText().equals("Yes")){
                    dogCounter += 5;
                }
            }
        });
    }

}
