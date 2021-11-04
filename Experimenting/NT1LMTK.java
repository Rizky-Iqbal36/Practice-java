package Experimenting;

import java.util.Scanner;

class Main {
    private static String[] answerKeys = { "TFTTTTTF", "TTTTTTTT", "FFFTTTTT", "TFTTTTTT", "TTTTTTTT", "TTFFTTTT",
            "TTTTTTTT", "TTTTTTTT", "TTTTTTTTTTTTTTTT", "TTTTTTTT", "TTTTTTTTTTTTTTTT", "FFTTTTTTTTTTTTTT",
            "TTTTTTTTTTTTTTTT", "TTTTTTTTTTTTTTTT", "TTTTTTTTTTTTTTTT", "TTTTTTTT" };

    public static void main(String[] args) {
        System.out.println("Input a value ");
        Scanner input = new Scanner(System.in);
        try {
            String values = input.next();
            calculate(values);
        } finally {
            input.close();
        }
    }

    private static void calculate(String values) {
        if (values.length() != 176) {
            System.out.println("inputan kau harusnya ada 176");
        } else {
            int wrongAnswer = 0;
            int valueIndex = 0;
            for (int i = 0; i < Main.answerKeys.length; i++) {
                for (int p = 0; p < Main.answerKeys[i].length(); p++) {
                    if (!Character.toString(values.charAt(valueIndex))
                            .equals(Character.toString(Main.answerKeys[i].charAt(p)))) {
                        wrongAnswer += Main.answerKeys[i].length();
                        valueIndex += (Main.answerKeys[i].length() - p);
                        break;
                    }
                    valueIndex++;
                }
            }
            Double totalNilai = (176 - wrongAnswer) * 0.568182;
            System.out.printf("Jumlah salah = %d\nTotal nilai = %f %n", wrongAnswer, totalNilai);
        }
    }
}