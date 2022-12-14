package com.example.sam.chess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Le Tao, Rui Kuang
 */


public class HomeScreen extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "gameTitle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        return;

    }

    public void startGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void watchGame(View view) {
        startActivityForResult(new Intent(getApplicationContext(), recordingPopup.class), 888);
        return;

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        //if we get a selected item back from recording popup
        if(requestCode == 888 && resultCode == RESULT_OK){
            String recordingTitle = data.getStringExtra("recording");
            System.out.println("printing");
            System.out.println(recordingTitle.toString());


            Intent intent = new Intent(this, watchRecording.class);
            intent.putExtra(EXTRA_MESSAGE, recordingTitle.toString());
            startActivity(intent);
        }

        //if user pressed cancel from recording popup
        if(requestCode == 888 && resultCode == RESULT_CANCELED){
            return;
        }

    }

}