package com.example.sam.chess;

/**
 * @author Le Tao, Rui Kuang
 */


public class Queen extends Piece {

    public Queen(int x, int y, String name, Board currentBoard) {
        super(x, y, name, currentBoard);
    }



    @Override
    public void getPotentialMoves(boolean color) {
        potentialMoves.clear();

        if ( currentBoard.board[x][y].piece.white != color) {
            return;
        }
        for (int col = y+1; col <8; col++) {
            if (currentBoard.board[x][col].piece == null) {
                if(currentBoard.testMove(this, currentBoard, x, y, x, col) != 1) {
                    potentialMoves.add(x+","+col);
                }			}
            else if(currentBoard.board[x][col].piece.white != white) {
                if(currentBoard.testMove(this, currentBoard, x, y, x, col) != 1) {
                    potentialMoves.add(x+","+col);
                }
                break;
            }
            else {
                break;
            }
        }
        for (int col = y- 1; col >=0; col--) {
            if (currentBoard.board[x][col].piece == null) {
                if(currentBoard.testMove(this, currentBoard, x, y, x, col) != 1) {
                    potentialMoves.add(x+","+col);
                }			}
            else if(currentBoard.board[x][col].piece.white != white) {
                if(currentBoard.testMove(this, currentBoard, x, y, x, col) != 1) {
                    potentialMoves.add(x+","+col);
                }
                break;
            }
            else {
                break;
            }
        }
        for (int row = x+ 1; row <8; row++) {
            if (currentBoard.board[row][y].piece == null) {
                if(currentBoard.testMove(this, currentBoard, x, y, row, y) != 1) {
                    potentialMoves.add(row+","+y);
                }			}
            else if(currentBoard.board[row][y].piece.white != white) {
                if(currentBoard.testMove(this, currentBoard, x, y, row, y) != 1) {
                    potentialMoves.add(row+","+y);
                }
                break;
            }
            else {
                break;
            }
        }
        for (int row = x-  1; row >=0; row--) {
            if (currentBoard.board[row][y].piece == null) {
                if(currentBoard.testMove(this, currentBoard, x, y, row, y) != 1) {
                    potentialMoves.add(row+","+y);
                }			}
            else if(currentBoard.board[row][y].piece.white != white) {
                if(currentBoard.testMove(this, currentBoard, x, y, row, y) != 1) {
                    potentialMoves.add(row+","+y);
                }
                break;
            }
            else {
                break;
            }
        }


        for (int row = x-1, col = y-1;Math.min(row,col)>=0;row--,col-- ) {
            if (currentBoard.board[row][col].piece == null) {
                if(currentBoard.testMove(this, currentBoard, x, y, row, col) != 1) {
                    potentialMoves.add(row+","+col);
                }			}
            else if(currentBoard.board[row][col].piece.white != white) {
                if(currentBoard.testMove(this, currentBoard, x, y, row, col) != 1) {
                    potentialMoves.add(row+","+col);
                }
                break;
            }
            else {
                break;
            }
        }
        for (int row = x+1, col = y+1;Math.max(row,col)<8;row++,col++ ) {
            if (currentBoard.board[row][col].piece == null) {
                if(currentBoard.testMove(this, currentBoard, x, y, row, col) != 1) {
                    potentialMoves.add(row+","+col);
                }			}
            else if(currentBoard.board[row][col].piece.white != white) {
                if(currentBoard.testMove(this, currentBoard, x, y, row, col) != 1) {
                    potentialMoves.add(row+","+col);
                }
                break;
            }
            else {
                break;
            }
        }
        for (int row = x+1, col = y-1;row <8 && col >=0;row++,col-- ) {
            if (currentBoard.board[row][col].piece == null) {
                if(currentBoard.testMove(this, currentBoard, x, y, row, col) != 1) {
                    potentialMoves.add(row+","+col);
                }			}
            else if(currentBoard.board[row][col].piece.white != white) {
                if(currentBoard.testMove(this, currentBoard, x, y, row, col) != 1) {
                    potentialMoves.add(row+","+col);
                }
                break;
            }
            else {
                break;
            }
        }
        for (int row = x-1, col = y+1;row >=0 && col <8;row--,col++) {
            if (currentBoard.board[row][col].piece == null) {
                if(currentBoard.testMove(this, currentBoard, x, y, row, col) != 1) {
                    potentialMoves.add(row+","+col);
                }			}
            else if(currentBoard.board[row][col].piece.white != white) {
                if(currentBoard.testMove(this, currentBoard, x, y, row, col) != 1) {
                    potentialMoves.add(row+","+col);
                }
                break;
            }
            else {
                break;
            }
        }


    }




    @Override
    public int move(int oldX, int oldY, int newX, int newY, boolean color, char promo) {
        String moveTo = newX+","+newY;
        if(potentialMoves.contains(moveTo)) {
            currentBoard.board[newX][newY].piece = currentBoard.board[oldX][oldY].piece;
            x = newX;
            y = newY;
            currentBoard.board[oldX][oldY].piece = null;
            return 1;
        }
        printError();
        return -1;
    }
}
