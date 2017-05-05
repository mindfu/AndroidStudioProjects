package mindfu.javaprojects.com.mywishlist2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;

import data.DatabaseHandler;

public class WishDetailActivity extends AppCompatActivity {

    private TextView title, date, content;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_detail);

        title = (TextView)findViewById(R.id.detailsTitle);
        date = (TextView)findViewById(R.id.detailsDateText);
        content = (TextView)findViewById(R.id.detailsTextView);
        deleteButton = (Button)findViewById(R.id.deleteButton);

        Bundle extras = getIntent().getExtras();

        if (extras != null){
            title.setText(extras.getString("title"));
            date.setText("Created: " + extras.getString("date"));
            content.setText(" \" " + extras.getString("content") + " \" ");
            final int id = extras.getInt("id");
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseHandler dba = new DatabaseHandler(getApplicationContext());
                    dba.deleteWish(id);
                    Toast.makeText(getApplicationContext(), "Wish Deleted", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(WishDetailActivity.this, DisplayWishesActivity.class));
                }
            });
        }
    }
}
