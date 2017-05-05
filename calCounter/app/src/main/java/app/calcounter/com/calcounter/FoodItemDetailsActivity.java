package app.calcounter.com.calcounter;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import data.DatabaseHandler;
import model.Food;

public class FoodItemDetailsActivity extends AppCompatActivity {

    private TextView foodName, calories, dateTaken;
    private Button shareButton;
    private int foodId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_details);

        foodName = (TextView)findViewById(R.id.detsFoodName);
        calories = (TextView)findViewById(R.id.detsCaloriesValue);
        dateTaken = (TextView)findViewById(R.id.detsDateText);
        shareButton = (Button)findViewById(R.id.detsShareButton);

        Food food = (Food)getIntent().getSerializableExtra("userObj");
        foodName.setText(food.getFoodName());
        calories.setText(String.valueOf(food.getCalories()));
        dateTaken.setText(food.getRecordDate());
        foodId = food.getFoodId();

        calories.setTextSize(34.9f);
        calories.setTextColor(Color.RED);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareCals();
            }
        });


    }

    public void shareCals(){
        StringBuilder dataString = new StringBuilder();
        String name = foodName.getText().toString();
        String cals = calories.getText().toString();
        String date = dateTaken.getText().toString();

        dataString.append("Food: " + name + "\n");
        dataString.append("Calories: " + cals + "\n");
        dataString.append("Date eaten: " + date);

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_SUBJECT, "My Caloric Intake");
        i.putExtra(Intent.EXTRA_EMAIL, "chris@mindfu.com");
        i.putExtra(Intent.EXTRA_TEXT, dataString.toString());

        try{
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Please install email client", Toast.LENGTH_LONG).show();
        }

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_food_item_details, menu);
        return true;
    }

    public void onGroupItemClick(MenuItem item) {
        // One of the group items (using the onClick attribute) was clicked
        // The item parameter passed here indicates which item it is
        // All other menu item clicks are handled by onOptionsItemSelected()
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.deleteItem){
            AlertDialog.Builder alert = new AlertDialog.Builder(FoodItemDetailsActivity.this);
            alert.setTitle("Delete?");
            alert.setMessage("Are you sure you want to delete this item?");
            alert.setNegativeButton("No", null);
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    DatabaseHandler dba = new DatabaseHandler(getApplicationContext());
                    dba.deleteFood(foodId);
                    Toast.makeText(getApplicationContext(), "Food item deleted", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(FoodItemDetailsActivity.this, DisplayFoodsActivity.class));

                    //Remove this activity from activity stack
                    FoodItemDetailsActivity.this.finish();
                }
            });
            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }



}
