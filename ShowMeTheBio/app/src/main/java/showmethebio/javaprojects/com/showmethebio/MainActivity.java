package showmethebio.javaprojects.com.showmethebio;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{

    private ImageView bachImage;
    private ImageView mozartImage;
    private String bachBio = "Born on March 31, 1685 (N.S.), in Eisenach, Thuringia, Germany, Johann Sebastian Bach had a prestigious musical lineage and took on various organist positions during the early 18th century, creating famous compositions like \"Toccata and Fugue in D minor.\" Some of his best-known compositions are the \"Mass in B Minor,\" the \"Brandenburg Concertos\" and \"The Well-Tempered Clavier.\" Bach died in Leipzig, Germany, on July 28, 1750. Today, he is considered one of the greatest Western composers of all time.";
    private String mozartBio = "Born on January 27, 1756, in Salzburg, Austria, Wolfgang Amadeus Mozart was a musician capable of playing multiple instruments who started playing in public at the age of 6. Over the years, Mozart aligned himself with a variety of European venues and patrons, composing hundreds of works that included sonatas, symphonies, masses, chamber music, concertos and operas, marked by vivid emotion and sophisticated textures.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bachImage = (ImageView)findViewById(R.id.bach_image);
        mozartImage = (ImageView)findViewById(R.id.mozart_image);

        bachImage.setOnClickListener(this);
        mozartImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bach_image:
                Intent bachIntent = new Intent(MainActivity.this, DetailsActivity.class);
                bachIntent.putExtra("bach", bachBio);
                bachIntent.putExtra("name", "bach");
                startActivity(bachIntent);
                break;
            case R.id.mozart_image:
                Intent mozartIntent = new Intent(MainActivity.this, DetailsActivity.class);
                mozartIntent.putExtra("mozart", mozartBio);
                mozartIntent.putExtra("name", "mozart");
                startActivity(mozartIntent);
                break;
        }
    }
}
