package showmethebio.javaprojects.com.mycustomlistview;

import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListViewAdapter customListViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] bookTitles = new String[]{
                "The Alchemist",
                "The Giver",
                "How to Kill a Mockingbird",
                "Lost in Paradise",
                "The Complete Android and Java Developer",
                "Titanic",
                "The Kite Runner",
                "Lord of the Rings",
                "The Hobbit",
                "Java in a Nutshell",
                "The Social Network"
        };

        final String[] bookPages = new String[]{
                "300 pages",
                "299 pages",
                "250 pages",
                "199 pages",
                "214 pages",
                "288 pages",
                "1987 pages",
                "250 pages",
                "199 pages",
                "214 pages",
                "288 pages"
        };

        final String[] authors = new String[]{
                "Chris Scrivo",
                "Pezcado Nice",
                "Rano Pescado",
                "Abajian Bramir",
                "T. Dood",
                "HHR",
                "David King",
                "El Leno",
                "Frankenstein",
                "J.R.R. Tolkien",
                "David Guttenburg"
        };


        ArrayList<HashMap<String, String>> authorList = new ArrayList<>();

        for (int i = 0; i < 11; i++){
            HashMap<String, String> data = new HashMap<>();
            data.put("title", bookTitles[i]);
            data.put("pages", bookPages[i]);
            data.put("author", authors[i]);

            authorList.add(data);
        }

        listView = (ListView)findViewById(R.id.list);

        //setup Adapter
        customListViewAdapter = new CustomListViewAdapter(getApplicationContext(), authorList);
        listView.setAdapter(customListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                int myPosition = position;
                String itemClickedId = listView.getItemAtPosition(myPosition).toString();
                Toast.makeText(getApplicationContext(), "ID Clicked: " + itemClickedId, Toast.LENGTH_LONG).show();
            }

        });




    }
}
