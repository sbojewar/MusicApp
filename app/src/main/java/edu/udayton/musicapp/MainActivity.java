package edu.udayton.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button, button1, button2;
    int playing;

    private MediaPlayer mpLinkin, mpDown, mpPark;

    private static final int NOT_PLAYING=0, PLAYING=1;
    private static final String SONGPLAYING="pause song";
    private static final String SONGPAUSED="play song";
    private static final String SONG2PLAYING="pause song";
    private static final String SONG2PAUSED="play song";
    private static final String SONG3PLAYING="pause song";
    private static final String SONG3PAUSED="play song";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =(Button)findViewById(R.id.button);
        button1 =(Button)findViewById(R.id.button1);
        button2 =(Button)findViewById(R.id.button2);

        button.setOnClickListener(buttonListner);
        button1.setOnClickListener(button1Listner);
        button2.setOnClickListener(button2Listner);

        mpLinkin = new MediaPlayer();
        mpLinkin = MediaPlayer.create(this, R.raw.burnitdown);

        mpDown = new MediaPlayer();
        mpDown = MediaPlayer.create(this, R.raw.aerials);

        mpPark = new MediaPlayer();
        mpPark = MediaPlayer.create(this, R.raw.skin);

        playing = NOT_PLAYING;
    } // end oncreate method
     Button.OnClickListener buttonListner= new Button.OnClickListener(){

        @Override
        public void onClick(View v) {


            switch (playing){
                case NOT_PLAYING:
                    mpLinkin.start();
                    playing=PLAYING;
                    button.setText(SONGPLAYING);
                    button1.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case PLAYING:
                    mpLinkin.pause();
                    playing=NOT_PLAYING;

                    button.setText(SONGPAUSED);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);

                    break;
            }

        } //end onclick handler
    };
    Button.OnClickListener button1Listner= new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (playing){
                case NOT_PLAYING:
                    mpDown.start();
                    playing=PLAYING;
                    button1.setText(SONG2PLAYING);
                    button.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case PLAYING:
                    mpDown.pause();
                    playing=NOT_PLAYING;
                    button1.setText(SONG2PAUSED);
                    button.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };
    Button.OnClickListener button2Listner= new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (playing){
                case NOT_PLAYING:
                    mpPark.start();
                    playing=PLAYING;
                    button2.setText(SONG3PLAYING);
                    button.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case PLAYING:
                    mpPark.pause();
                    playing=NOT_PLAYING;
                    button2.setText(SONG3PAUSED);
                    button.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };

}
