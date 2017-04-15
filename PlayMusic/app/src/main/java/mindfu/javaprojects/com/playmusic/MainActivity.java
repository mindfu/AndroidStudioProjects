package mindfu.javaprojects.com.playmusic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button playMusic;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.game_field);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                int duration = mp.getDuration()/1000;
                Toast.makeText(getApplicationContext(), "Duration: " + duration + " seconds for Genalyn", Toast.LENGTH_LONG).show();
            }
        });

        playMusic = (Button)findViewById(R.id.playButton);
        playMusic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mediaPlayer.isPlaying()){
                    //Stop and give option to start again
                    pauseMusic();
                } else {
                    startMusic();
                }
            }
        });


    }

    public void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            playMusic.setText("Play");

        }
    }

    public void startMusic(){
        if (mediaPlayer != null) {
            mediaPlayer.start();
            playMusic.setText("Pause");
        }
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();
    }
}
