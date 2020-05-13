package com.example.mymusicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kotlin.jvm.internal.Ref;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int currentPauseposition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = (Button)findViewById(R.id.btPlay);
        pause = (Button)findViewById(R.id.btPause);
        stop = (Button)findViewById(R.id.btStop);



        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btPlay :
                if (mediaPlayer ==null)
                {
                   mediaPlayer =MediaPlayer.create(getApplicationContext(),R.raw.music);
                   mediaPlayer.start();
                }
                else if (!mediaPlayer.isPlaying())
                {
                    mediaPlayer.seekTo(currentPauseposition);
                    mediaPlayer.start();
                }


                break;
            case R.id.btPause :
                if (mediaPlayer!=null)
                {
                    mediaPlayer.pause();
                    currentPauseposition = mediaPlayer.getCurrentPosition();
                }

                break;
            case R.id.btStop :
                if (mediaPlayer!=null)
                {
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }

                break;





        }
    }
}
