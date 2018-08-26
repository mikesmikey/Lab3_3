import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.util.Scanner;

public class Game {

    private static OX table1;
    private static Scanner sc = new Scanner(System.in);
    private static int col, row;

    private static void Input() {
        System.out.println(table1.getCurrentPlayer()+" (Col): ");
        col = sc.nextInt();
        System.out.println(table1.getCurrentPlayer()+" (Row): ");
        row = sc.nextInt();
        System.out.println(table1.getCurrentPlayer()+"__________");
    }

    private static void PrintWinner() {
        System.out.println("X Win: "+ table1.getCountX());
        System.out.println("O Win: "+ table1.getCountO());
        System.out.println("Draw: "+ table1.getCountDraw());
    }

    public static void main (String[] args) {

        table1 = new OX();
        int turn=1;
        while (turn <=9) {
            System.out.println(table1.getTableString());
            Input();
            table1.put(col, row);

            if (table1.checkWin() || turn == 9) {
                if (!table1.checkWin()) {
                    table1.setCountDraw(1);
                }
                PrintWinner();
                break;
            }

            table1.switchPlayer();
            turn++;
        }
    }

}
