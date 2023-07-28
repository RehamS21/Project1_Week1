import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class App {
    public static String [][] game = new String[3][3];
    public static boolean flag_check = false;
    public static ArrayList<String> user_index = new ArrayList<>();
    public static ArrayList<String> computer_index = new ArrayList<>();
    public static int count_full = 0;

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; j++) {
                game[i][j] =" ";
            }
        }
        Board_form(game);

        do{


            System.out.println("Where would you like to play ? (1-9)");
            int index = input.nextInt();

            while(user_index.contains(String.valueOf(index)) || computer_index.contains(String.valueOf(index)))
            {
                System.out.println("This place alreay taken");
                System.out.println("Where would you like to play ? (1-9)");
                index = input.nextInt();
            }

            board_move(index,"X","user");
            Board_form(game);

            int rand = random.nextInt(9 - 1 + 1) + 1;
            while(user_index.contains(String.valueOf(rand)) || computer_index.contains(String.valueOf(rand)))
            {
                rand = random.nextInt(9 - 1 + 1) + 1;

            }
            board_move(rand, "O","computer");
            System.out.println("Computer Choose : "+ rand);
            Board_form(game);
        }while(Iswinner());
    }

    public static void Board_form(String [][] game){
        System.out.println(game[0][0]+"|"+game[0][1]+"|"+game[0][2]);
        System.out.println("-+-+-");
        System.out.println(game[1][0]+"|"+game[1][1]+"|"+game[1][2]);
        System.out.println("-+-+-");
        System.out.println(game[2][0]+"|"+game[2][1]+"|"+game[2][2]);
    }


    public static void board_move(int move, String x_or_o,String identity ){
        if(identity.equals("user")){
            user_index.add(String.valueOf(move));
        }else{
            computer_index.add(String.valueOf(move));
        }

        if(move >= 1 && move <= 9){ // set the range of the move
                switch(move){
                    case 1:
                        game[0][0] = x_or_o;
                    break;
                    case 2:
                        game[0][1] = x_or_o;
                    break;
                    case 3:
                        game[0][2] = x_or_o;
                    break;
                    case 4:
                        game[1][0] = x_or_o;
                    break;
                    case 5:
                        game[1][1] = x_or_o;
                    break;
                    case 6:
                        game[1][2] = x_or_o;
                    break;
                    case 7:
                        game[2][0] = x_or_o;
                    break;
                    case 8:
                        game[2][1] = x_or_o;
                    break;
                    case 9:
                        game[2][2] = x_or_o;
                    break;

            }
            count_full++;
        }else{
            System.out.println("The number out of the range");
        }
    }


    public static boolean Iswinner(){
        String win_user ="";
        String win_computer = "";
        boolean flag_1 = true;
        boolean flag_2 = false;

        // check by rows 
        for(int i = 0 ; i < game.length ; i++){
            for (int j = 0; j < game.length; j++) {
                if(game[i][j].equalsIgnoreCase("X")){
                    win_user += "X";
                }
                if(game[i][j].equalsIgnoreCase("O")){
                    win_computer +="O";
                }
            }
            if(win_user.equalsIgnoreCase("XXX")){
                System.out.println("You Win");
                flag_1 = false;
                break;
            }else if(win_computer.equalsIgnoreCase("OOO")){
                System.out.println("Computer Win");
                flag_1 = false;
                break;
            }else{
                win_user = "";
                win_computer ="";
            }


            flag_2 = true;
        }



        // check by columns
        if(flag_2 == true){
        for (int i = 0; i < game.length; i++) {
            if((!game[0][i].equals(" ")) && (game[0][i].equalsIgnoreCase(game[1][i])) && (game[1][i].equalsIgnoreCase(game[2][i]))){
                if(game[0][i].equals("X")){
                    System.out.println("You Win !");
                }else System.out.println("Computer Win !");

                flag_1 = false;
                break;
            }
                }
        }
        // check the matrix 
        if((!game[0][0].equals(" ")) && (game[0][0].equalsIgnoreCase(game[1][1])) && (game[1][1].equalsIgnoreCase(game[2][2]))){
            if(game[0][0].equals("X")){
                System.out.println("You Win !");
            }else System.out.println("Computer Win !");

            flag_1 = false;
        }else if((!game[0][2].equals(" ")) && (game[0][2].equalsIgnoreCase(game[1][1])) && (game[1][1].equalsIgnoreCase(game[2][0]))){
                if(game[0][2].equals("X")){
                    System.out.println("You Win !");
                }else System.out.println("Computer Win !");
            
            flag_1 = false;
        }

        return flag_1;
    }

}
