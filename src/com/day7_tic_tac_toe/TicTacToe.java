package com.day7_tic_tac_toe;
import java.util.Arrays;
import java.util.Scanner;
public class TicTacToe {
    static final char a = 0; // inorder to ignore 0th index

    public static void main(String[] args) {
        System.out.println("Welcome to day 7 workshop program - TicTacToe game");
        TicTacToe.uc1_CreatingGame();
    }
    public static void uc1_CreatingGame() {
        char[] board = {a, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}; //size 10 char[] with empty spaces
        System.out.println("Fresh board: "+ Arrays.toString(board));
    }
}
