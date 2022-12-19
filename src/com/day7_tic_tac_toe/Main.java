package com.day7_tic_tac_toe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        TicTacToe obj = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        obj.welcome();
        obj.uc1_CreatingGame();
        obj.uc2_chooseXO();
        System.out.println("Find the below options\n" +
                "1. ShowBoard 2. check free space 3. MakeAMove 4. Toss");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                obj.uc3_showBoard();
                break;
            case 2:
                obj.uc5_checkFreeSpace();
                break;
            case 3:
                obj.uc4_makeAMove();
                break;
            case 4:
                obj.uc6_toss();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
        obj.uc7_turn();
    }
}
