import java.util.Scanner;
public class TicTacToe{
    public static void main(String[] args){
        String[][] board = {{"1", "|","2", "|","3", "|"},{"-","-","-","-","-","-"},{"4", "|","5", "|","6", "|"},{"-","-","-","-","-","-"},{"7", "|","8", "|","9", "|"}};
        //set to true to play against computer
        boolean pc = true;
        game(board, pc);
        printBoard(board);
    }
    public static void game(String[][] board, boolean pc){
        Scanner sc = new Scanner(System.in);
        boolean player1 = true;
        boolean[] options = {false,true,true,true,true,true,true,true,true,true}; //used to prevent duplicate moves
                            //0    1    2    3    4    5    6   7     8    9
        int count = 0; //counts numbers of turn, if == 9 and game was not won, the game is a tie
        String sym; //placeholder for X or O
        int choice;
        System.out.println("make a move");
        printBoard(board);

        while(count < 9){
            //determines whose turn it is
            if(player1)
                sym = "O";
            else
                sym = "X";

            if(pc && !player1){
                choice = computer(options);
                options[choice] = false;
            }else{
                System.out.println("make a move");
                choice = sc.nextInt();
                options = validate(choice,options);
            }
                board = play(choice,board,sym,player1);

            player1 = !player1; //switches to other player
            count++;
        }
        System.out.println("Player 1 and Player 2 tied");
        sc.close();
    }
    public static int computer(boolean[] options){
        int[] choice = new int[options.length-2];
        int index = 0;
        for(int i = 0; i < options.length; i++){
            if(options[i])
            choice[index++] = i;
        }
        int r = (int)(Math.random()*(index));
        return choice[r];
    }
    public static boolean[] validate(int choice, boolean[] options){//prevents players from playing over eachother
            if(!options[choice]){
                System.out.println("invalid option");
                System.exit(0);
            }else{
                options[choice] = false;
            }
        return options;
    }
    public static String[][] play(int choice, String[][] board, String sym, boolean player1){
            //determines where to place symbol
            int row = (choice - 1) / 3 * 2; // *2 skips over the | and ------
            int col = (choice - 1) % 3 * 2;
            board[row][col] = sym;
            printBoard(board);
            if(gameCondition(board,sym)){
                if(player1)
                    System.out.println("Player 1 won!");
                else
                    System.out.println("Player 2 won!");
                System.exit(0);
            }
        return board;
    }
    public static boolean gameCondition(String[][] board, String sym){
        for(int i = 0; i < board.length; i++){
            if(i%2==1) //skips rows "-----"
                continue;
            int col = 0, row = 0; //declares and resets count
            for(int k = 0; k < board.length; k++){
                if(k%2 == 0 && (board[k][i]).equals(sym))
                    col++; //vertical
                if(k%2 == 0 && (board[i][k]).equals(sym))
                    row++; //horizontal
            }
            if(col == 3 || row == 3)//checks if theres are 3 consecutive and equal symboles
                return true;
        }
        String diag = board[0][0] + board[2][2] + board[4][4];
        String compare = sym+sym+sym; //returns true if diag win, false if not
        return (diag.equals(compare)); //can only be reached if all other conditions are false
    }
    public static void printBoard(String[][] board){
        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board.length; k++){
                System.out.print(board[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
