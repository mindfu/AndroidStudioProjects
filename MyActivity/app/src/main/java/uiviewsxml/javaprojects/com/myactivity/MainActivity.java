package uiviewsxml.javaprojects.com.myactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    static final int REQUEST_CODE = 1;
    private Button myButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button)findViewById(R.id.button);

        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("activityOne","I am the first activity");

                startActivityForResult(intent, REQUEST_CODE);

//                startActivity(intent);
//                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String result = data.getStringExtra("returnData");
                Toast.makeText(this, result, Toast.LENGTH_LONG).show();
            }
        }
    }



    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(getApplication(), "OnStart Methods Call", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(getApplication(), "OnRestart Methods Call", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(getApplication(), "OnResume Methods Call", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(getApplication(), "OnPause Methods Call", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(getApplication(), "OnStop Methods Call", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(getApplication(), "OnDestroy Methods Call", Toast.LENGTH_LONG).show();
    }
}
