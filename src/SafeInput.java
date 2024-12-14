
import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; //zero length string. loop runs until it isnt
        do {
            System.out.print(prompt + ": "); //show the prompt
            retString = pipe.nextLine();
        } while (retString.isEmpty());
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int retValue = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + ": ");
            if(pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                valid = true;
            } else {
                String trash = pipe.next();
                System.out.println("Invalid input.");
            }
            pipe.nextLine();
        } while(!valid);
        return retValue;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + ": ");
            if(pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                valid = true;
            } else {
                String trash = pipe.next();
                System.out.println("Invalid input.");
            }
            pipe.nextLine();
        } while(!valid);
        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if(pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                if (retInt >= low && retInt <= high) {
                    valid = true;
                } else {
                    System.out.println("Input must be between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Integers only.");
            }
            pipe.nextLine();
        } while(!valid);
        return retInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if(pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                if (retDouble >= low && retDouble <= high) {
                    valid = true;
                } else {
                    System.out.println("Input must be between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Doubles only.");
            }
            pipe.nextLine();
        } while(!valid);
        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String answer = "";
        boolean retBool = false;
        boolean valid = false;
        do {
            System.out.print(prompt + " (Y/N): ");
            answer = pipe.nextLine();
            if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")) {
                valid = true;
                if(answer.equalsIgnoreCase("N")) {
                    retBool = false;
                } else {
                    retBool = true;
                }
            } else {
                System.out.println("Invalid input. Y or N required.");
            }
        } while(!valid);
        return retBool;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        boolean valid = false;
        String input = "";
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();
            if(input.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        } while(!valid);
        return input;
    }

    public static void prettyHeader(String msg) {
        int width = 60;
        int msgLength = msg.length();
        int totalPad = width - 6 - msgLength;
        int leftPad = totalPad / 2;
        int rightPad = totalPad - leftPad;
        for(int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("***");
        for(int i = 0; i < leftPad; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for(int i = 0; i < rightPad; i++) {
            System.out.print(" ");
        }
        System.out.println("***");
        for(int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}