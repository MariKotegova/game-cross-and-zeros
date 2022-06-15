import java.util.Scanner;

public class Main {
    public static final char CROSS = 'X';
    public static final char ZERO = '0';
    public static final int SIZE = 3;
    public static final char EMPTI = '-';

    public static void main (String[] args){
        System.out.println("Начнем игру \n");
        char[][] pole = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                pole[i][j] = EMPTI;
                System.out.print(pole[i][j] + " ");
            }
            System.out.println();
        }
        boolean xod = true;
        while(true){

        System.out.println("Ходят " + (xod?"крестики"  : "нолики") + "");
        //System.out.println("Введите координаты хода через пробел: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] parts = input.split(" ");
        int x = Integer.parseInt(parts[0]) -1;
        int y = Integer.parseInt(parts[1]) -1;

        if (pole[x][y] != EMPTI){
            System.out.println("Сюда ходить нельзя попробуй заново!");
            continue;
        }
        pole[x][y] = (xod? CROSS : ZERO);
        print(pole);
        if (isWim(pole, xod ? CROSS : ZERO)     ){
            System.out.println("Победили " + (xod ? "крестики": "нолики"));
            System.out.println("Игра закончина!!! ");
            break;
        }

        xod = !xod;


        }
    }

    public static void print (char[][] pole){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                System.out.print(pole[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean isWim (char[][] pole, char player){

        for (int i = 0; i < SIZE; i++){
            int result = 0;
            for (int j = 0; j < SIZE; j++){
                if (pole[i][j] == player){
                 result ++;
                }
                if( result == SIZE){
                    return true;
                }
            }
        }

        for (int j = 0; j < SIZE; j++){
            int result = 0;
            for (int i = 0; i < SIZE; i++){
                if (pole[i][j] == player){
                    result ++;
                }
                if( result == SIZE){
                    return true;
                }
            }
        }

   //     if (SIZE %2 == 0){
   //         // если число четное то деагонали проверять не надо
   //         return false;
   //     }
        int result1 = 0;
        for (int i = 0; i < SIZE; i++){

            if (pole[i][i] == player){
                result1 ++;
            }
            if( result1 == SIZE){
                    return true;
            }
        }
        int result2 = 0;
        for (int i = 0; i < SIZE; i++){

            if (pole[SIZE -1 -i][i] == player){
                result2 ++;
            }
            if( result2 == SIZE){
                return true;
            }
        }




     return false;
    }
}
