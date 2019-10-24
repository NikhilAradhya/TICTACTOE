import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainFinal {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Functions functions = new Functions();

        if (functions.player == functions.X) {
            System.out.println("Computer Plays First\nX=Row number   ;    Y=Column number");
        } else {
            System.out.println("You Play First\nX=Row number   ;    Y=Column number");
        }
        functions.disp();
        do {

            if (functions.player == -1) {
                System.out.println("Your turn O" +
                        " Put x and y values");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                functions.putSign(x - 1, y - 1);
                functions.disp();
            } else {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
                functions.plus2Finder();

                if (functions.plus2FinderBool == true) {
                    functions.disp();
                    functions.player = -1;
                    continue;
                }
                functions.minus2Finder();
                if (functions.minus2FinderBool == true) {
                    functions.disp();
                    functions.player = -1;
                    continue;
                }

                functions.jackpotForO();
                if (functions.jackpotForOBool==true){
                    functions.disp();
                    functions.player = -1;
                    continue;
                }

                functions.probFinder2();
                if (functions.probFinder2Bool==true){
                    functions.disp();
                    functions.player = -1;
                    continue;
                }
            }
        }
        while (functions.cont);

        if (!functions.isWin) {
            functions.player=functions.O;
            System.out.println("\n\nIt's a tie");
        }
        decesion();
    }

    private static void decesion(){
        System.out.println("\nPress 1 to restart the game    ;   Press 0 to Exit the game");
        int x = scanner.nextInt();
        if (x==1){
            String[] args = {"System.out.println(\"\\n------------------------------------------------------------------------------------------------------------------------------------------------------\\n\");"};
            main(args);
        }else if (x==0){
            end();
        }else{
            decesion();
        }

    }

    public static void end(){
        System.exit(1);
    }
}