package com.day7_tic_tac_toe;
import java.util.Scanner;

public class TicTacToe {
    static final char a = 0; // inorder to ignore 0th index

    public static void main(String[] args) {
        System.out.println("Welcome to day 7 workshop program - TicTacToe game");
        TicTacToe.uc1_CreatingGame();
        TicTacToe.uc2_chooseXO();
    }
    public static void uc1_CreatingGame() {
        char[] board = {a, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}; //size 10 char[] with empty spaces
        System.out.println("Fresh board: ");
        System.out.println(board[1]+" | "+board[2]+" | "+board[3]);
        System.out.println(board[4]+" | "+board[4]+" | "+board[6]);
        System.out.println(board[7]+" | "+board[9]+" | "+board[9]);
    }
    public static void uc2_chooseXO() {
        System.out.println("Select letter X or O as your option: ");
        Scanner sc = new Scanner(System.in);
        char userInput = sc.next().charAt(0);
        if(userInput == 'X' || userInput == 'x') {
            System.out.println("Player option is X");
            System.out.println("Computer option is O");
        }
        else if(userInput == 'O' || userInput == 'o'){
            System.out.println("Player option is O");
            System.out.println("Computer option is X");
        }
        else
            System.out.println("Invalid input only X or O is allowed");
    }
}
