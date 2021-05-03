package ui;

public class PrintGamePlan {
    private char[][] board = new char[3][3];;
    private char player; // 'X' or 'O'

    public PrintGamePlan() {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j <3; j++)
            {
                board[i][j] = ' ';
            }
        }

        player = 'X';

//        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
//        System.out.println("–––––––––––––");
//        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
//        System.out.println("–––––––––––––");
//        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println(".    .      .");
    }

    public static void main(String[] args) {
        // insert code to set up your tictactoe object  here
        PrintGamePlan ttt = new PrintGamePlan();
    }

}
