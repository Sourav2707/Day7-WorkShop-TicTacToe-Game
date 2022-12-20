package com.day7_tic_tac_toe;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    Scanner sc = new Scanner(System.in);
    char userInput = ' ';
    char comInput = ' ';
    char[] board = new char[10]; //size 10 char[] with empty spaces
    int playerToss;
    int tie;
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
    public void uc7_turn() //this method is to find whether player or computer is win or tie
    {
        // the below condition is the winning combinations 123, 456, 789, 157, 357, 147, 258, 369
        if((board[1] == comInput && board[2] == comInput && board[3] == comInput) ||
                (board[1] == comInput && board[4] == comInput && board[7] == comInput)||
                (board[1] == comInput && board[5] == comInput && board[9] == comInput)||
                (board[2] == comInput && board[5] == comInput && board[8] == comInput)||
                (board[3] == comInput && board[6] == comInput && board[9] == comInput)||
                (board[3] == comInput && board[5] == comInput && board[7] == comInput)||
                (board[4] == comInput && board[5] == comInput && board[6] == comInput)||
                (board[7] == comInput && board[8] == comInput && board[9] == comInput)) {
            System.out.println("Computer win!");
            win = 1;
        }
        else if((board[1] == userInput && board[2] == userInput && board[3] == userInput) ||
                (board[1] == userInput && board[4] == userInput && board[7] == userInput)||
                (board[1] == userInput && board[5] == userInput && board[9] == userInput)||
                (board[2] == userInput && board[5] == userInput && board[8] == userInput)||
                (board[3] == userInput && board[6] == userInput && board[9] == userInput)||
                (board[3] == userInput && board[5] == userInput && board[7] == userInput)||
                (board[4] == userInput && board[5] == userInput && board[6] == userInput)||
                (board[7] == userInput && board[8] == userInput && board[9] == userInput)) {
            System.out.println("Player win!");
            win = 1;
        }
        else if ((win == 1) || (board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' ' && board[5] != ' ' && board[6] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ')) {
            System.out.println("Game tie");
        }
    }

    public void uc8_compTurn() {
        if(board[1] == ' ' && board[2] == ' ' && board[3] == ' ' && board[4] == ' ' && board[5] == ' ' &&
                board[6] == ' ' && board[7] == ' ' && board[8] == ' ' && board[9] == ' ') //this is for initial move of the fresh board
        {
            Random rnd = new Random();
            comMove = rnd.nextInt(1,10);
            board[comMove] = comInput;
            System.out.println("Computer move");
            uc3_showBoard();
            uc7_turn();
        }
        //if the board is not fresh
        else {
            //the below conditions are for winning combination moves
            if ((board[1] == comInput && board[5] == ' ' && board[9] == ' ') ||
                    (board[1] == comInput && board[5] == ' ' && board[9] == comInput) ||
                    (board[2] == comInput && board[5] == ' ' && board[8] == ' ') ||
                    (board[2] == comInput && board[5] == ' ' && board[8] == comInput) ||
                    (board[3] == comInput && board[5] == ' ' && board[7] == ' ') ||
                    (board[3] == comInput && board[5] == ' ' && board[7] == comInput) ||
                    (board[4] == comInput && board[5] == ' ' && board[6] == ' ') ||
                    (board[4] == comInput && board[5] == ' ' && board[6] == comInput) ||
                    (board[6] == comInput && board[4] == comInput && board[5] == ' ') ||
                    (board[7] == comInput && board[5] == ' ' && board[3] == ' ') ||
                    (board[7] == comInput && board[5] == ' ' && board[3] == comInput) ||
                    (board[8] == comInput && board[2] == comInput && board[5] == ' ') ||
                    (board[9] == comInput && board[1] == comInput && board[5] == ' ')) {
                board[5] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
                uc7_turn();
            }
            else if ((board[2] == comInput && board[1] == ' ' && board[3] ==' ') ||
                    (board[2] == comInput && board[1] == ' ' && board[3] == comInput) ||
                    (board[3] == comInput && board[2] == comInput && board[1] == ' ') ||
                    (board[4] == comInput && board[1] == ' ' && board[7] == ' ') ||
                    (board[4] == comInput && board[1] == ' ' && board[7] == comInput) ||
                    (board[5] == comInput && board[1] == ' ' && board[9] == ' ') ||
                    (board[5] == comInput && board[1] == ' ' && board[9] == comInput) ||
                    (board[7] == comInput && board[1] == ' ' && board[4] == ' ') ||
                    (board[7] == comInput && board[1] == ' ' && board[4] == comInput) ||
                    (board[9] == comInput && board[1] == ' ' && board[5] == ' ') ||
                    (board[9] == comInput && board[1] == ' ' && board[5] == comInput)) {
                board[1] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
                uc7_turn();
            }
            else if ((board[1] == comInput && board[2] == comInput && board[3] == ' ') ||
                    (board[2] == comInput && board[1] == comInput && board[3] == ' ') ||
                    (board[5] == comInput && board[3] == ' ' && board[7] == comInput) ||
                    (board[6] == comInput && board[3] == ' ' && board[9] ==' ') ||
                    (board[6] == comInput && board[3] == ' ' && board[9] ==comInput) ||
                    (board[7] == comInput && board[5] == comInput && board[3] == ' ') ||
                    (board[9] == comInput && board[3] == ' ' && board[6] == ' ') ||
                    (board[9] == comInput && board[3] == ' ' && board[6] == comInput)) {
                board[3] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
                uc7_turn();
            }
            else if ((board[1] == comInput && board[4] == comInput && board[7] == ' ') ||
                    (board[3] == comInput && board[5] == comInput && board[7] == ' ') ||
                    (board[4] == comInput && board[1] == comInput && board[7] == ' ') ||
                    (board[5] == comInput && board[3] == comInput && board[7] == ' ') ||
                    (board[8] == comInput && board[7] == ' ' && board[9] == ' ') ||
                    (board[8] == comInput && board[7] == ' ' && board[9] == comInput) ||
                    (board[9] == comInput && board[7] == ' ' && board[8] == ' ') ||
                    (board[9] == comInput && board[7] == ' ' && board[8] == comInput)) {
                board[7] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
                uc7_turn();
            }
            else if ((board[1] == comInput && board[5] == comInput && board[9] == ' ') ||
                    (board[3] == comInput && board[6] == comInput && board[9] == ' ') ||
                    (board[5] == comInput && board[1] == comInput && board[9] == ' ') ||
                    (board[6] == comInput && board[3] == comInput && board[9] ==' ') ||
                    (board[7] == comInput && board[8] == comInput && board[9] == ' ') ||
                    (board[8] == comInput && board[7] == comInput && board[9] == ' ')) {
                board[9] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
                uc7_turn();
            }
            else if((board[1] == comInput && board[2] == ' ' && board[3] == ' ') ||
                    (board[1] == comInput && board[2] == ' ' && board[3] == comInput) ||
                    (board[3] == comInput && board[2] == ' ' && board[1] == ' ') ||
                    (board[3] == comInput && board[2] == ' ' && board[1] == comInput) ||
                    (board[5] == comInput && board[2] == ' ' && board[8] == ' ') ||
                    (board[5] == comInput && board[2] == ' ' && board[8] == comInput) ||
                    (board[8] == comInput && board[2] == ' ' && board[5] == ' ') ||
                    (board[8] == comInput && board[2] == ' ' && board[5] == comInput)) {
                board[2] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
                uc7_turn();
            }
            else if ((board[1] == comInput && board[4] == ' ' && board[7] == ' ') ||
                    (board[1] == comInput && board[4] == ' ' && board[7] == comInput) ||
                    (board[5] == comInput && board[4] == ' ' && board[6] == ' ') ||
                    (board[5] == comInput && board[4] == ' ' && board[6] == comInput) ||
                    (board[6] == comInput && board[4] == ' ' && board[5] == ' ') ||
                    (board[6] == comInput && board[4] == ' ' && board[5] == comInput) ||
                    (board[7] == comInput && board[1] == comInput && board[4] == ' ')) {
                board[4] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
                uc7_turn();
            }
            else if ((board[3] == comInput && board[6] == ' ' && board[9] == ' ') ||
                    (board[3] == comInput && board[6] == ' ' && board[9] == comInput) ||
                    (board[4] == comInput && board[5] == comInput && board[6] == ' ') ||
                    (board[5] == comInput && board[4] == comInput && board[6] == ' ') ||
                    (board[9] == comInput && board[3] == comInput && board[6] == ' ')) {
                board[6] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
                uc7_turn();
            }
            else if ((board[2] == comInput && board[5] == comInput && board[8] == ' ') ||
                    (board[5] == comInput && board[2] == comInput && board[8] == ' ') ||
                    (board[7] == comInput && board[8] == ' ' && board[9] == ' ') ||
                    (board[7] == comInput && board[8] == ' ' && board[9] == comInput) ||
                    (board[9] == comInput && board[7] == comInput && board[8] == ' ')) {
                board[8] = comInput;
                System.out.println("Computer move");
                uc3_showBoard();
                uc7_turn();
            }
            //if winning combinations doesn't workout calling the block method
            else {
                uc9_comBlock();
            }
        }
        //as the computer move is done calling the player move
        uc4_makeAMove();
    }
    public void uc9_comBlock() //this is blocking method used the same winning combination from uc8, if the player has any winning combination com will place its move
    {
        if ((board[1] == userInput && board[5] == ' ' && board[9] == ' ') ||
                (board[1] == userInput && board[5] == ' ' && board[9] == userInput) ||
                (board[2] == userInput && board[5] == ' ' && board[8] == ' ') ||
                (board[2] == userInput && board[5] == ' ' && board[8] == userInput) ||
                (board[3] == userInput && board[5] == ' ' && board[7] == ' ') ||
                (board[3] == userInput && board[5] == ' ' && board[7] == userInput) ||
                (board[4] == userInput && board[5] == ' ' && board[6] == ' ') ||
                (board[4] == userInput && board[5] == ' ' && board[6] == userInput) ||
                (board[6] == userInput && board[4] == userInput && board[5] == ' ') ||
                (board[7] == userInput && board[5] == ' ' && board[3] == ' ') ||
                (board[7] == userInput && board[5] == ' ' && board[3] == userInput) ||
                (board[8] == userInput && board[2] == userInput && board[5] == ' ') ||
                (board[9] == userInput && board[1] == userInput && board[5] == ' ')) {
            board[5] = comInput;
            System.out.println("Computer move");
            uc3_showBoard();
            uc7_turn();
        }
        else if ((board[2] == userInput && board[1] == ' ' && board[3] ==' ') ||
                (board[2] == userInput && board[1] == ' ' && board[3] == userInput) ||
                (board[3] == userInput && board[2] == userInput && board[1] == ' ') ||
                (board[4] == userInput && board[1] == ' ' && board[7] == ' ') ||
                (board[4] == userInput && board[1] == ' ' && board[7] == userInput) ||
                (board[5] == userInput && board[1] == ' ' && board[9] == ' ') ||
                (board[5] == userInput && board[1] == ' ' && board[9] == userInput) ||
                (board[7] == userInput && board[1] == ' ' && board[4] == ' ') ||
                (board[7] == userInput && board[1] == ' ' && board[4] == userInput) ||
                (board[9] == userInput && board[1] == ' ' && board[5] == ' ') ||
                (board[9] == userInput && board[1] == ' ' && board[5] == userInput)) {
            board[1] = comInput;
            System.out.println("Computer move");
            uc3_showBoard();
            uc7_turn();
        }
        else if ((board[1] == userInput && board[2] == userInput && board[3] == ' ') ||
                (board[2] == userInput && board[1] == userInput && board[3] == ' ') ||
                (board[5] == userInput && board[3] == ' ' && board[7] == userInput) ||
                (board[6] == userInput && board[3] == ' ' && board[9] ==' ') ||
                (board[6] == userInput && board[3] == ' ' && board[9] ==userInput) ||
                (board[7] == userInput && board[5] == userInput && board[3] == ' ') ||
                (board[9] == userInput && board[3] == ' ' && board[6] == ' ') ||
                (board[9] == userInput && board[3] == ' ' && board[6] == userInput)) {
            board[3] = comInput;
            System.out.println("Computer move");
            uc3_showBoard();
            uc7_turn();
        }
        else if ((board[1] == userInput && board[4] == userInput && board[7] == ' ') ||
                (board[3] == userInput && board[5] == userInput && board[7] == ' ') ||
                (board[4] == userInput && board[1] == userInput && board[7] == ' ') ||
                (board[5] == userInput && board[3] == userInput && board[7] == ' ') ||
                (board[8] == userInput && board[7] == ' ' && board[9] == ' ') ||
                (board[8] == userInput && board[7] == ' ' && board[9] == userInput) ||
                (board[9] == userInput && board[7] == ' ' && board[8] == ' ') ||
                (board[9] == userInput && board[7] == ' ' && board[8] == userInput)) {
            board[7] = comInput;
            System.out.println("Computer move");
            uc3_showBoard();
            uc7_turn();
        }
        else if ((board[1] == userInput && board[5] == userInput && board[9] == ' ') ||
                (board[3] == userInput && board[6] == userInput && board[9] == ' ') ||
                (board[5] == userInput && board[1] == userInput && board[9] == ' ') ||
                (board[6] == userInput && board[3] == userInput && board[9] ==' ') ||
                (board[7] == userInput && board[8] == userInput && board[9] == ' ') ||
                (board[8] == userInput && board[7] == userInput && board[9] == ' ')) {
            board[9] = comInput;
            System.out.println("Computer move");
            uc3_showBoard();
            uc7_turn();
        }
        else if((board[1] == userInput && board[2] == ' ' && board[3] == ' ') ||
                (board[1] == userInput && board[2] == ' ' && board[3] == userInput) ||
                (board[3] == userInput && board[2] == ' ' && board[1] == ' ') ||
                (board[3] == userInput && board[2] == ' ' && board[1] == userInput) ||
                (board[5] == userInput && board[2] == ' ' && board[8] == ' ') ||
                (board[5] == userInput && board[2] == ' ' && board[8] == userInput) ||
                (board[8] == userInput && board[2] == ' ' && board[5] == ' ') ||
                (board[8] == userInput && board[2] == ' ' && board[5] == userInput)) {
            board[2] = comInput;
            System.out.println("Computer move");
            uc3_showBoard();
            uc7_turn();
        }
        else if ((board[1] == userInput && board[4] == ' ' && board[7] == ' ') ||
                (board[1] == userInput && board[4] == ' ' && board[7] == userInput) ||
                (board[5] == userInput && board[4] == ' ' && board[6] == ' ') ||
                (board[5] == userInput && board[4] == ' ' && board[6] == userInput) ||
                (board[6] == userInput && board[4] == ' ' && board[5] == ' ') ||
                (board[6] == userInput && board[4] == ' ' && board[5] == userInput) ||
                (board[7] == userInput && board[1] == userInput && board[4] == ' ')) {
            board[4] = comInput;
            System.out.println("Computer move");
            uc3_showBoard();
            uc7_turn();
        }
        else if ((board[3] == userInput && board[6] == ' ' && board[9] == ' ') ||
                (board[3] == userInput && board[6] == ' ' && board[9] == userInput) ||
                (board[4] == userInput && board[5] == userInput && board[6] == ' ') ||
                (board[5] == userInput && board[4] == userInput && board[6] == ' ') ||
                (board[9] == userInput && board[3] == userInput && board[6] == ' ')) {
            board[6] = comInput;
            System.out.println("Computer move");
            uc3_showBoard();
            uc7_turn();
        }
        else if ((board[2] == userInput && board[5] == userInput && board[8] == ' ') ||
                (board[5] == userInput && board[2] == userInput && board[8] == ' ') ||
                (board[7] == userInput && board[8] == ' ' && board[9] == ' ') ||
                (board[7] == userInput && board[8] == ' ' && board[9] == userInput) ||
                (board[9] == userInput && board[7] == userInput && board[8] == ' ')) {
            board[8] = comInput;
            System.out.println("Computer move");
            uc3_showBoard();
            uc7_turn();
        }
    }
}
