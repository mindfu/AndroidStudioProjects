package uiviewsxml.javaprojects.com.uiviewsxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Hello", Toast.LENGTH_LONG.show());

        Toast toast = new Toast(getApplicationContext());

        toast.setText("Hello There");

        toast.setDuration(Toast.LENGTH_LONG);

        toast.show();

        MyClass myClass = new MyClass();

        myClass.showToast();

    }

    class MyClass {
        public void showToast(){
            Toast.makeText(getApplicationContext(), "Hello from Class", Toast.LENGTH_LONG).show();

        }
    }
}


