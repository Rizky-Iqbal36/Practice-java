package Assignment;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author 1201190016 - Muhammad Rizky Iqbal Syaifullah
 * @apiNote for best use, please see this condition (width and height more than
 *          equal 5)
 */
class OOPT1 {
    public static void main(String[] args) {
        ArrayList<Integer> dimension = new ArrayList<Integer>();
        ArrayList<StringBuilder> border = new ArrayList<StringBuilder>();

        StringBuilder borderWidth = new StringBuilder("");
        StringBuilder borderHeight = new StringBuilder("==");

        ArrayList<Integer> playerStarterPoint = new ArrayList<Integer>();

        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Input height: ");
            dimension.add(input.nextInt());

            System.out.println("Input width: ");
            dimension.add(input.nextInt());

            System.out.println("Input player coordinate (x,y)");
            for (int i = 0; i < 2; i++) {
                playerStarterPoint.add(input.nextInt());
            }

            for (int i = 0; i < dimension.get(1); i++) {
                borderHeight.append("=");
                if (i == 0) {
                    borderWidth.append("| ");
                } else if (i == dimension.get(1) - 1) {
                    borderWidth.append(" |");
                } else {
                    borderWidth.append(" ");
                }
            }

            border.add(borderHeight);
            border.add(borderWidth);
        } finally {
            input.close();
            render(dimension, border, playerStarterPoint);
        }
    }

    private static void render(ArrayList<Integer> dimension, ArrayList<StringBuilder> border,
            ArrayList<Integer> playerStarterPoint) {
        System.out.printf("player coordinate: %s\n", playerStarterPoint);

        char player = 'o';
        Integer voidHeigh = dimension.get(0) + 2;

        for (int i = 0; i < voidHeigh; i++) {
            if (i == 0 || i == voidHeigh - 1) {
                System.out.println(border.get(0));
            } else {
                if (playerStarterPoint.get(1) + 1 == i) {
                    border.get(1).setCharAt(playerStarterPoint.get(0) + 1, player);
                    System.out.println(border.get(1));
                    border.get(1).setCharAt(playerStarterPoint.get(0) + 1, ' ');
                } else {
                    System.out.println(border.get(1));
                }
            }
        }
    }
}
