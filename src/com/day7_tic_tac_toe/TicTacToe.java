package com.day7_tic_tac_toe;


public class TicTacToe {
    public void welcome() {
        System.out.println("Welcome to day 7 workshop program - TicTacToe game");
    }
    public void uc1_CreatingGame() {
        char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}; //size 10 char[] with empty spaces and ignoring 0th index
        System.out.println("Fresh board: ");
        System.out.println(board[1]+" | "+board[2]+" | "+board[3]);
        System.out.println(board[4]+" | "+board[4]+" | "+board[6]);
        System.out.println(board[7]+" | "+board[9]+" | "+board[9]);
    }
}
