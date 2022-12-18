package com.day7_tic_tac_toe;
import java.util.Scanner;

public class TicTacToe {
    Scanner sc = new Scanner(System.in);
    char userInput = ' ';
    char comInput = ' ';
    char[] board = new char[10]; //size 10 char[] with empty spaces
    public void welcome() {
        System.out.println("Welcome to day 7 workshop program - TicTacToe game");
    }
    public void uc1_CreatingGame() {
        //ignoring 0th index
        board[1] = ' '; //ignoring 0th index
        board[2] = ' ';
        board[3] = ' ';
        board[4] = ' ';
        board[5] = ' ';
        board[6] = ' ';
        board[7] = ' ';
        board[8] = ' ';
        board[9] = ' ';
        System.out.println("Fresh board: ");
        System.out.println(board[1]+" | "+board[2]+" | "+board[3]);
        System.out.println(board[4]+" | "+board[4]+" | "+board[6]);
        System.out.println(board[7]+" | "+board[8]+" | "+board[9]);
    }
    public void uc2_chooseXO() {
        System.out.println("Select letter X or O as your option: ");
        userInput = sc.next().charAt(0);
        if (userInput == 'X' || userInput == 'x') {
            comInput = 'O';
            System.out.println("Player option is X");
            System.out.println("Computer option is O");
        } else if (userInput == 'O' || userInput == 'o') {
            comInput = 'X';
            System.out.println("Player option is O");
            System.out.println("Computer option is X");
        } else
            System.out.println("Invalid input only X or O is allowed");
    }
    public void uc3_showBoard() {
        System.out.println(board[1]+" | "+board[2]+" | "+board[3]);
        System.out.println(board[4]+" | "+board[4]+" | "+board[6]);
        System.out.println(board[7]+" | "+board[8]+" | "+board[9]);
    }
    public void uc4_makeAMove() {
        for(int i = 1; i < board.length; i++) {
            if(board[i] == ' ')
                System.out.print(i+" ");
        }
        System.out.println("Positions are not occupied");
        System.out.println("Enter the position number: ");
        int move = sc.nextInt();
        board[move] = userInput;
        uc3_showBoard();
    }
}
