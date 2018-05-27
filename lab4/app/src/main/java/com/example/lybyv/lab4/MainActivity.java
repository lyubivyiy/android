package com.example.lybyv.lab4;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    VideoView videoPlayer;
    Button startButton2, pauseButton2, stopButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoPlayer =  (VideoView)findViewById(R.id.videoPlayer);
        Uri myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.thisisamerica1);
        videoPlayer.setVideoURI(myVideoUri);
        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);
        mPlayer=MediaPlayer.create(this, R.raw.roots);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });
        startButton2 = (Button) findViewById(R.id.startButton2);
        pauseButton2 = (Button) findViewById(R.id.pauseButton2);
        stopButton2 = (Button) findViewById(R.id.stopButton2);

        pauseButton2.setEnabled(false);
        stopButton2.setEnabled(false);
    }

    public void play(View view){
        videoPlayer.start();
    }
    public void pause(View view){
        videoPlayer.pause();
    }
    public void stop(View view){
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }
    private void stopPlay(){
        mPlayer.stop();
        pauseButton2.setEnabled(false);
        stopButton2.setEnabled(false);
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
            startButton2.setEnabled(true);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void play2(View view){

        mPlayer.start();
        startButton2.setEnabled(false);
        pauseButton2.setEnabled(true);
        stopButton2.setEnabled(true);
    }
    public void pause2(View view){

        mPlayer.pause();
        startButton2.setEnabled(true);
        pauseButton2.setEnabled(false);
        stopButton2.setEnabled(true);
    }
    public void stop2(View view){
        stopPlay();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
    }
}