package com.example.valerie.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class tictactoe extends AppCompatActivity {

    private boolean[][] p1board = new boolean[3][3];
    private boolean[][] p2board = new boolean[3][3];
    private boolean[][] board = new boolean[3][3];
    private int player = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);
    }

    public void userClick(View view) {
        if(player % 2 == 1) turnOne(view);
        else turnTwo(view);
        player++;
    }

    private boolean isCatGame(boolean[][] board){
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                if(!board[r][c]) return false;
            }
        }
        return true;
    }

    private void turnOne(View view){
        int id = view.getId();
        ImageButton clicked = (ImageButton) findViewById(id);
        clicked.setImageResource(R.drawable.red);
        clicked.setClickable(false);
        int r = 0;
        int c = 0;
        switch(id) {
            case R.id.topMid:
                r = 0;
                c = 1;
                break;
            case R.id.topRight:
                r = 0;
                c = 2;
                break;
            case R.id.midLeft:
                r = 1;
                c = 0;
                break;
            case R.id.midMid:
                r = 1;
                c = 1;
                break;
            case R.id.midRight:
                r = 1;
                c = 2;
                break;
            case R.id.botLeft:
                r = 2;
                c = 0;
                break;
            case R.id.botMid:
                r = 2;
                c = 1;
                break;
            case R.id.botRight:
                r = 2;
                c = 2;
                break;
            default:
                break;
        }
        board[r][c] = true;
        p1board[r][c] = true;
        if(isWin(p1board, r, c)){
            Toast.makeText(this, "Red Won!", Toast.LENGTH_LONG).show();
            resetBoard(view);
        }else if(isCatGame(board)){
            Toast.makeText(this, "It's a cat's game!", Toast.LENGTH_LONG).show();
            resetBoard(view);
        }else{
            Toast.makeText(this, "Black's turn!", Toast.LENGTH_SHORT).show();
        }
    }

    private void turnTwo(View view){
        int id = view.getId();
        ImageButton clicked = (ImageButton) findViewById(id);
        clicked.setImageResource(R.drawable.black);
        clicked.setClickable(false);
        int r = 0;
        int c = 0;
        switch(id) {
            case R.id.topMid:
                r = 0;
                c = 1;
                break;
            case R.id.topRight:
                r = 0;
                c = 2;
                break;
            case R.id.midLeft:
                r = 1;
                c = 0;
                break;
            case R.id.midMid:
                r = 1;
                c = 1;
                break;
            case R.id.midRight:
                r = 1;
                c = 2;
                break;
            case R.id.botLeft:
                r = 2;
                c = 0;
                break;
            case R.id.botMid:
                r = 2;
                c = 1;
                break;
            case R.id.botRight:
                r = 2;
                c = 2;
                break;
            default:
                break;
        }
        board[r][c] = true;
        p2board[r][c] = true;
        if(isWin(p2board, r, c)){
            Toast.makeText(this, "Black Won!", Toast.LENGTH_LONG).show();
            resetBoard(view);
        }else if(isCatGame(board)){
            Toast.makeText(this, "It's a cat's game!", Toast.LENGTH_LONG).show();
            resetBoard(view);
        }else{
            Toast.makeText(this, "Red's turn!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isWin(boolean[][] board, int r, int c){
        return ((board[r][0] && board[r][1] && board[r][2]) //three in a row
                || (board[0][c] && board[1][c] && board[2][c]) //three in a col
                || (board[0][0] && board[1][1] && board[2][2]) //main diagonal
                || (board[0][2] && board[1][1] && board[2][0])); //opposite diagonal
    }

    public void resetBoard(View view){
        board = new boolean[3][3];
        p1board = board;
        p2board = board;
        ImageButton here = (ImageButton) findViewById(R.id.topLeft);
        here.setImageResource(R.drawable.empty);
        here.setClickable(true);
        here = (ImageButton) findViewById(R.id.topMid);
        here.setImageResource(R.drawable.empty);
        here.setClickable(true);
        here = (ImageButton) findViewById(R.id.topRight);
        here.setImageResource(R.drawable.empty);
        here.setClickable(true);
        here = (ImageButton) findViewById(R.id.midLeft);
        here.setImageResource(R.drawable.empty);
        here.setClickable(true);
        here = (ImageButton) findViewById(R.id.midMid);
        here.setImageResource(R.drawable.empty);
        here.setClickable(true);
        here = (ImageButton) findViewById(R.id.midRight);
        here.setImageResource(R.drawable.empty);
        here.setClickable(true);
        here = (ImageButton) findViewById(R.id.botLeft);
        here.setImageResource(R.drawable.empty);
        here.setClickable(true);
        here = (ImageButton) findViewById(R.id.botMid);
        here.setImageResource(R.drawable.empty);
        here.setClickable(true);
        here = (ImageButton) findViewById(R.id.botRight);
        here.setImageResource(R.drawable.empty);
        here.setClickable(true);
    }

}
