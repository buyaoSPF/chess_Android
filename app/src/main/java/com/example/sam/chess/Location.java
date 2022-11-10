package com.example.sam.chess;


/**
 * @author Le Tao, Rui Kuang
 */




public class Location {

    int x;

    int y;

    boolean blackspot = false;

    Piece piece = null;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        if(x%2!=0 && y%2==0  ) {
            this.blackspot = true;
        }
        if(x%2==0 && y%2!=0) {
            this.blackspot = true;
        }
    }


    public Location(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        if(x%2!=0 && y%2==0  ) {
            this.blackspot = true;
        }
        if(x%2==0 && y%2!=0) {
            this.blackspot = true;
        }
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public String getName() {
        return piece.name;
    }

}

