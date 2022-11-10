package com.example.sam.chess;

import android.content.Intent;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import android.graphics.drawable.Drawable;
import java.io.File;
import java.util.Scanner;

/**
 * @author Le Tao, Rui Kuang
 */

public class watchRecording extends AppCompatActivity {
    File recordingFile;
    ArrayList<String> listOfMoves = new ArrayList<>();
    int turnNumber = 1;

    TextView title;
    TextView state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watchrecording);
        Intent intent = getIntent();
        String passedMessage = intent.getStringExtra(HomeScreen.EXTRA_MESSAGE.toString()).toString();

        System.out.println("In Replay Mode");
        System.out.println(passedMessage.toString());

        title = (TextView)findViewById(R.id.gameTitle);
        state= (TextView)findViewById(R.id.gameState);

        title.setText(passedMessage.toString());

        state.setText("white's turn");

        Context context = getApplicationContext();
        File directory = context.getFilesDir();
        File[] listofFiles = directory.listFiles();
        for (int j =0; j < listofFiles.length; j++){
            if (listofFiles[j].getName().toString().compareTo(passedMessage) == 0){
                recordingFile = listofFiles[j];
                break;
            }
        }
        try {
            Scanner scanner = new Scanner(recordingFile);
            while (scanner.hasNextLine()) {
                listOfMoves.add(scanner.nextLine());
                System.out.println(listOfMoves.get(listOfMoves.size()-1));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }






    public void nextmove(View view) {


        if(turnNumber  > listOfMoves.size()){


            state.setText("black's Turn");

            return;
        }
        String currentMove = listOfMoves.get(turnNumber-1);
        System.out.println(currentMove);

        if (Character.isUpperCase(currentMove.charAt(0))){
            System.out.println(currentMove);
            state.setText(currentMove);
            return;
        }


        String fromtile = "" + currentMove.charAt(0) + currentMove.charAt(1);
        int id = getResources().getIdentifier(fromtile, "id", getPackageName());
        ImageView fromTileiv = (ImageView) findViewById(id);
        Drawable temp = fromTileiv.getDrawable();
        fromTileiv.setImageDrawable(null);
        String totile = "" + currentMove.charAt(2) + currentMove.charAt(3);
        id = getResources().getIdentifier(totile, "id", getPackageName());
        ImageView toTileiv = (ImageView) findViewById(id);

        if(currentMove.charAt(5)=='0' && currentMove.charAt(6)=='0') {
            if(currentMove.charAt(4)=='x') {
                toTileiv.setImageDrawable(temp);
            }
            else if(turnNumber%2==1) {
                if (currentMove.charAt(4) == 'Q') {
                    toTileiv.setImageDrawable(getResources().getDrawable(R.drawable.wqueen));
                } else if (currentMove.charAt(4) == 'N') {
                    toTileiv.setImageDrawable(getResources().getDrawable(R.drawable.wknight));
                } else if (currentMove.charAt(4) == 'B') {
                    toTileiv.setImageDrawable(getResources().getDrawable(R.drawable.wbishop));
                } else if (currentMove.charAt(4) == 'R') {
                    toTileiv.setImageDrawable(getResources().getDrawable(R.drawable.wrook));
                }
            }
            else if(turnNumber%2==0){
                if (currentMove.charAt(4) == 'Q') {
                    toTileiv.setImageDrawable(getResources().getDrawable(R.drawable.bqueen));
                } else if (currentMove.charAt(4) == 'N') {
                    toTileiv.setImageDrawable(getResources().getDrawable(R.drawable.bknight));
                } else if (currentMove.charAt(4) == 'B') {
                    toTileiv.setImageDrawable(getResources().getDrawable(R.drawable.bbishop));
                } else if (currentMove.charAt(4) == 'R') {
                    toTileiv.setImageDrawable(getResources().getDrawable(R.drawable.brook));
                }
            }

        }
        else if(currentMove.charAt(5)=='1'){
            if(currentMove.charAt(1)=='1') {
                if (currentMove.charAt(2) == 'g') {
                    id = getResources().getIdentifier("h1", "id", getPackageName());
                    ImageView RooktileIv = (ImageView) findViewById(id);
                    RooktileIv.setImageDrawable(null);
                    id = getResources().getIdentifier("f1", "id", getPackageName());
                    RooktileIv = (ImageView) findViewById(id);
                    RooktileIv.setImageDrawable(getResources().getDrawable(R.drawable.wrook));
                }
                else if(currentMove.charAt(2) == 'c'){
                    id = getResources().getIdentifier("a1", "id", getPackageName());
                    ImageView RooktileIv = (ImageView) findViewById(id);
                    RooktileIv.setImageDrawable(null);
                    id = getResources().getIdentifier("d1", "id", getPackageName());
                    RooktileIv = (ImageView) findViewById(id);
                    RooktileIv.setImageDrawable(getResources().getDrawable(R.drawable.wrook));
                }
            }
            else if(currentMove.charAt(1)=='8'){
                if (currentMove.charAt(2) == 'g') {
                    id = getResources().getIdentifier("h8", "id", getPackageName());
                    ImageView RooktileIv = (ImageView) findViewById(id);
                    RooktileIv.setImageDrawable(null);
                    id = getResources().getIdentifier("f8", "id", getPackageName());
                    RooktileIv = (ImageView) findViewById(id);
                    RooktileIv.setImageDrawable(getResources().getDrawable(R.drawable.brook));
                }
                else if(currentMove.charAt(2) == 'c'){
                    id = getResources().getIdentifier("a8", "id", getPackageName());
                    ImageView RooktileIv = (ImageView) findViewById(id);
                    RooktileIv.setImageDrawable(null);
                    id = getResources().getIdentifier("d8", "id", getPackageName());
                    RooktileIv = (ImageView) findViewById(id);
                    RooktileIv.setImageDrawable(getResources().getDrawable(R.drawable.brook));
                }
            }
            toTileiv.setImageDrawable(temp);
        }
        else if(currentMove.charAt(6)=='1'){
            if(currentMove.charAt(3)=='6'){
                String idEdit = ""+currentMove.charAt(2) + "5";
                id = getResources().getIdentifier(idEdit, "id", getPackageName());
                ImageView deadPawn = (ImageView) findViewById(id);
                deadPawn.setImageDrawable(null);
            }
            else if(currentMove.charAt(3)=='3'){
                String idEdit = ""+currentMove.charAt(2) + "4";
                id = getResources().getIdentifier(idEdit, "id", getPackageName());
                ImageView deadPawn = (ImageView) findViewById(id);
                deadPawn.setImageDrawable(null);
            }
            toTileiv.setImageDrawable(temp);
        }


        turnNumber ++;
        if(turnNumber%2 == 1) {
            state.setText("white's Turn");
        }
        else{
            state.setText("black's Turn");
        }

    }
}
