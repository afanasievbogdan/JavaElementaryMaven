package HomeWork15;

import java.util.Arrays;
import java.util.Scanner;

public class Graphics {

    public String input (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число : ");
        String string = scanner.nextLine();
        try {
            int integer = Integer.parseInt(string);
        }catch (NumberFormatException | NullPointerException exception) {
            System.out.println("Неверный символ, вы можете ввести только строку содержащую цифры 0-9");
            return "";
        }
        return string;
    }

    private static final String[][][] poolOfGraphicNumbers =
            {
                    {
                            {"   ", "@ ", "  "},
                            {" @ ", "  ", "@ "},
                            {" @ ", " ", " @ "},
                            {" @", "  ", " @ "},
                            {" @", "  ", " @ "},
                            {"   ", "@ ", "  "},
                    },

                    {
                            {"  ", "  ", "@ "},
                            {"  ", "@ ", "@ "},
                            {" @", "  ", "@ "},
                            {"  ", "  ", "@ "},
                            {"  ", "  ", "@ "},
                            {"  ", "  ", "@ "},
                    },

                    {
                            {"  ", " @ ", "  "},
                            {" @ ", "  ", "@ "},
                            {"  ", "  ", "@  "},
                            {"  ", " @ ", "  "},
                            {" @ ", "  ", "  "},
                            {" @ ", "@ ", "@ "},
                    },

                    {
                            {" @ ", "@ ", "@ "},
                            {"  ", "  ", " @ "},
                            {" @ ", "@ ", "@ "},
                            {"  ", "  ", " @ "},
                            {"  ", "  ", " @ "},
                            {" @ ", "@ ", "@ "},
                    },

                    {
                            {" @ ", "  ", "@ "},
                            {" @ ", "  ", "@ "},
                            {" @ ", "@ ", "@ "},
                            {"  ", "  ", " @ "},
                            {"  ", "  ", " @ "},
                            {"  ", "  ", " @ "},
                    },

                    {
                            {" @ ", "@ ", "@ "},
                            {" @ ", "  ", "  "},
                            {" @ ", "@ ", "@ "},
                            {"  ", "  ", " @ "},
                            {"  ", "  ", " @ "},
                            {" @ ", "@ ", "@ "},
                    },

                    {
                            {" @ ", "@ ", "@ "},
                            {" @ ", "  ", "  "},
                            {" @ ", "@ ", "@ "},
                            {" @", "  ", " @ "},
                            {" @", "  ", " @ "},
                            {" @ ", "@ ", "@ "},
                    },

                    {
                            {" @ ", "@ ", "@ "},
                            {"  ", "  ", " @ "},
                            {"  ", " ", " @  "},
                            {"  ", " @", "   "},
                            {" ", " @", "    "},
                            {" @", " ", "    "},
                    },

                    {
                            {" @ ", "@ ", "@ "},
                            {" @ ", "  ", "@ "},
                            {" @ ", "@ ", "@ "},
                            {" @", "  ", " @ "},
                            {" @", "  ", " @ "},
                            {" @ ", "@ ", "@ "},
                    },

                    {
                            {" @ ", "@", " @ "},
                            {" @ ", "  ", "@ "},
                            {" @ ", "@", " @ "},
                            {" ", "  ", "  @ "},
                            {" ", "  ", "  @ "},
                            {" @ ", "@ ", "@ "},
                    }
            };

    public static void printGraphics(String string) {
        for (int line = 0; line < 6; line++) {
            System.out.println(" ");
            for (int pos = 0; pos < string.length(); pos++) {
                String current = string.substring(pos, pos + 1);
                    int index = Integer.parseInt(current);
                    for (int column = 0; column < 3; column++) {
                        System.out.print(poolOfGraphicNumbers[index][line][column]);
                    }
                }
            }
        }


    public static void main(String[] args) {
        Graphics graphics = new Graphics();

        String s = graphics.input();
        printGraphics(s);

    }
}
