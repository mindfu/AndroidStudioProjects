package showmethebio.javaprojects.com.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private TextView hideSeekTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideSeekTextView = (TextView)findViewById(R.id.resultTextView);
        toggleButton = (ToggleButton)findViewById(R.id.toggleButtonId);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if ( isChecked ) {
                    hideSeekTextView.setVisibility(View.VISIBLE);
                } else {
                    hideSeekTextView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
