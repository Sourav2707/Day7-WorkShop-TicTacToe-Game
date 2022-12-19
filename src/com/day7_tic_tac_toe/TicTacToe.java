package com.day7_tic_tac_toe;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    Scanner sc = new Scanner(System.in);
    char userInput = ' ';
    char comInput = ' ';
    char[] board = new char[10]; //size 10 char[] with empty spaces
    int playerToss;
    String line1 = null;
    String line2 = null;
    int win = 0;
    int comMove;
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
        int move = sc.nextInt();
        board[move] = userInput;
        System.out.println("Player move");
        uc3_showBoard();
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
    public void uc7_turn() {
        for (int a = 0; a < 8; a++) {

            switch (a) {
                case 0:
                    line1 = ""+board[0] + board[1] + board[2];
                    line2 = ""+board[0] + board[1] + board[2];
                    break;
                case 1:
                    line1 = ""+board[3] + board[4] + board[5];
                    line2 = ""+board[3] + board[4] + board[5];
                    break;
                case 2:
                    line1 = ""+board[6] + board[7] + board[8];
                    line2 = ""+board[6] + board[7] + board[8];
                    break;
                case 3:
                    line1 = ""+board[0] + board[3] + board[6];
                    line2 = ""+board[0] + board[3] + board[6];
                    break;
                case 4:
                    line1 = ""+board[1] + board[4] + board[7];
                    line2 = ""+board[1] + board[4] + board[7];
                    break;
                case 5:
                    line1 = ""+board[2] + board[5] + board[8];
                    line2 = ""+board[2] + board[5] + board[8];
                    break;
                case 6:
                    line1 = ""+board[0] + board[4] + board[8];
                    line2 = ""+board[0] + board[4] + board[8];
                    break;
                case 7:
                    line1 = ""+board[2] + board[4] + board[6];
                    line2 = ""+board[2] + board[4] + board[6];
                    break;
            }
        }
        if(line1 == ""+userInput+userInput+userInput)
            System.out.println("Player is the winner");
        else if(line2 == ""+comInput+comInput+comInput)
            System.out.println("Computer is the winner");
        else if((line1 != ""+userInput+userInput+userInput) && (line2 != ""+comInput+comInput+comInput) && board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' ' && board[5] != ' ' && board[6] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ' )
            System.out.println("Game tie");
    }
    public void uc8_compTurn() {
        Random rnd = new Random();
        comMove = rnd.nextInt(1, 10);
        if(board[comMove] == ' ') {
            for(int i = 1; i < board.length; i++)
            {
                if(board[i] == comInput)  //checking the board for cominput
                {
                    if(i == 1) {
                        if((board[2] == ' ' && board[3] == ' ') ||
                                (board[4] == ' ' && board[7] == ' ') ||
                                (board[5] == ' ' && board[9] == ' '))
                        {
                            board[comMove] = comInput;
                            System.out.println("Computer move");
                            uc3_showBoard();
                        }
                    }
                    else if(i == 2) {
                        if((board[1] == ' ' && board[3] == ' ') ||
                                (board[5] == ' ' && board[8] == ' '))
                        {
                            board[comMove] = comInput;
                            System.out.println("Computer move");
                            uc3_showBoard();
                        }
                    }
                    else if(i == 3) {
                        if((board[1] == ' ' && board[2] == ' ') ||
                                (board[6] == ' ' && board[9] == ' ') ||
                                (board[5] == ' ' && board[7] == ' '))
                        {
                            board[comMove] = comInput;
                            System.out.println("Computer move");
                            uc3_showBoard();
                        }
                    }
                    else if(i == 4) {
                        if((board[1] == ' ' && board[7] == ' ') ||
                                (board[5] == ' ' && board[6] == ' '))
                        {
                            board[comMove] = comInput;
                            System.out.println("Computer move");
                            uc3_showBoard();
                        }
                    }
                    else if(i == 5) {
                        if((board[2] == ' ' && board[8] == ' ') ||
                                (board[4] == ' ' && board[6] == ' ') ||
                                (board[7] == ' ' && board[3] == ' '))
                        {
                            board[comMove] = comInput;
                            System.out.println("Computer move");
                            uc3_showBoard();
                        }
                    }
                    else if(i == 6) {
                        if((board[3] == ' ' && board[9] == ' ') ||
                                (board[4] == ' ' && board[5] == ' '))
                        {
                            board[comMove] = comInput;
                            System.out.println("Computer move");
                            uc3_showBoard();
                        }
                    }
                    else if(i == 7) {
                        if((board[1] == ' ' && board[4] == ' ') ||
                                (board[8] == ' ' && board[9] == ' ') || (board[5] == ' ' && board[3] == ' '))
                        {
                            board[comMove] = comInput;
                            System.out.println("Computer move");
                            uc3_showBoard();
                        }
                    }
                    else if(i == 8) {
                        if((board[2] == ' ' && board[5] == ' ') ||
                                (board[7] == ' ' && board[9] == ' '))
                        {
                            board[comMove] = comInput;
                            System.out.println("Computer move");
                            uc3_showBoard();
                        }
                    }
                    else if(i == 9) {
                        if((board[3] == ' ' && board[6] == ' ') ||
                                (board[7] == ' ' && board[8] == ' ') || (board[1] == ' ' && board[5] == ' '))
                        {
                            board[comMove] = comInput;
                            System.out.println("Computer move");
                            uc3_showBoard();
                        }
                    }
                    else
                        uc9_comBlock();
                }
            }
        }
        else
            uc8_compTurn();
    }
    public void uc9_comBlock() {
        if(board[1] == userInput) {
            if((board[2] == ' ' && board[3] == ' ') || (board[4] == ' ' && board[7] == ' ') || (board[5] == ' ' && board[9] == ' ')) {
                board[comMove] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
            }
        }
        else if(board[2] == userInput) {
            if((board[1] == ' ' && board[3] == ' ') || (board[5] == ' ' && board[8] == ' ')) {
                board[comMove] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
            }
        }
        else if(board[3] == userInput) {
            if((board[6] == ' ' && board[9] == ' ') || (board[1] == ' ' && board[2] == ' ') || (board[5] == ' ' && board[7] == ' ')) {
                board[comMove] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
            }
        }
        else if(board[4] == userInput) {
            if((board[5] == ' ' && board[6] == ' ') || (board[1] == ' ' && board[7] == ' ')) {
                board[comMove] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
            }
        }
        else if(board[5] == userInput) {
            if((board[2] == ' ' && board[8] == ' ') || (board[4] == ' ' && board[6] == ' ') || (board[3] == ' ' && board[7] == ' ')) {
                board[comMove] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
            }
        }
        else if(board[6] == userInput) {
            if((board[4] == ' ' && board[5] == ' ') || (board[3] == ' ' && board[9] == ' ')) {
                board[comMove] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
            }
        }
        else if(board[7] == userInput) {
            if((board[1] == ' ' && board[4] == ' ') || (board[8] == ' ' && board[9] == ' ') || (board[5] == ' ' && board[3] == ' ')) {
                board[comMove] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
            }
        }
        else if(board[8] == userInput) {
            if((board[2] == ' ' && board[5] == ' ') || (board[7] == ' ' && board[9] == ' ')) {
                board[comMove] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
            }
        }
        else if(board[9] == userInput) {
            if((board[3] == ' ' && board[6] == ' ') || (board[7] == ' ' && board[8] == ' ') || (board[1] == ' ' && board[5] == ' ')) {
                board[comMove] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
            }
        }
        else
            uc10_neitherWin();
    }
    public void uc10_neitherWin() {
        if((line1 != ""+userInput+userInput+userInput) && (line2 != ""+comInput+comInput+comInput)) {
            if(board[1] == ' ' || board[3] == ' ' || board[7] == ' ' || board[9] == ' ') {
                board[comMove] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
            }
        }
    }
}
