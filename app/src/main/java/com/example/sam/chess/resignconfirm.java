package com.example.sam.chess;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.content.Intent;


/**
 * @author Le Tao, Rui Kuang
 */

public class resignconfirm extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.resign);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.7),(int)(height*.7));

    }

    public void Yes(View v){
        Intent i = new Intent();
        i.putExtra("message",1);
        setResult(RESULT_OK,i);
        finish();

    }

    public void No(View v){
        Intent i = new Intent();

        i.putExtra("message",0);
        setResult(RESULT_CANCELED,i);
        finish();
    }
}