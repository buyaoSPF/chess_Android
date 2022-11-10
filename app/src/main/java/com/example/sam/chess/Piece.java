package com.example.sam.chess;

/**
 * @author Le Tao, Rui Kuang
 */

import java.util.ArrayList;
import java.util.List;


public class Piece {

    int x;

    int y;

    String name;

    Board currentBoard;

    boolean white = false;

    List<String> potentialMoves = new ArrayList<String>();

    public Piece(int x, int y, String name, Board currentBoard) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.currentBoard = currentBoard;
        if(name.charAt(0)=='w') {
            this.white = true;
        }
    }


    public int move(int oldX, int oldY, int newX, int newY, boolean color, char promo) {
        if ( currentBoard.board[oldX][oldY].piece.white != color) {
            System.out.println("Illegal move, try again");
            return -1;
        }

        currentBoard.board[newX][newY].piece = currentBoard.board[oldX][oldY].piece;
        currentBoard.board[oldX][oldY].piece = null;
        return 1;
    }


    public void printError() {
        System.out.println("Illegal move, try again");
    }

    public void getPotentialMoves(boolean color) {
    }




}
