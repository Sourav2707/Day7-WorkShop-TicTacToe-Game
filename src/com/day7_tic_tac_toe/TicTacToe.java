package com.day7_tic_tac_toe;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    Scanner sc = new Scanner(System.in);
    char userInput = ' ';
    char comInput = ' ';
    char[] board = new char[10]; //size 10 char[] with empty spaces
    int playerToss;
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
        System.out.println("Enter the position number: ");
        int move = sc.nextInt();board[move] = userInput;
    }
    public void uc5_checkFreeSpace() {
        for(int i = 1; i < board.length; i++) {
            if(board[i] == ' ')
                System.out.print(i+" ");
        }
        System.out.println("Positions are free to occupy");
    }
    public void uc6_toss() {
        Random rnd = new Random();
        int toss = rnd.nextInt(0,2);
        System.out.println("Enter 1 for head and 0 for tail in order to check who plays first");
         playerToss = sc.nextInt();
         if(toss == playerToss && toss == 1) {
             System.out.println("Heads player won the toss");
             uc4_makeAMove();
         }
         else if(toss == playerToss && toss == 0) {
             System.out.println("Tails, player won the toss");
             uc4_makeAMove();
         }
    }
}
