package main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        exerciseE();
    }

    public static void exerciseE() {
        computeArrayAverage(new int[]{4, 78, 21, 103});
        String language = readLanguage();
        displayWelcomeMessage(language);
        displayLoopedWelcomeMessage();
    }

    public static void computeArrayAverage(int[] arr) {
        System.out.println(Arrays.stream(arr).reduce(0, Integer::sum) / arr.length);
    }

    public static void displayWelcomeMessage(String language) {
        switch (language) {
            case "FR" : System.out.println("Bienvenue");
                break;
            case "NL" : System.out.println("Goeiedag");
                break;
            case "GE" : System.out.println("Willkommen");
                break;
            default: System.out.println("Welcome");
                break;
        }
    }

    private static String readLanguage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a two letter abbreviation of your language");
        return sc.nextLine().toUpperCase();
    }

    public static void displayLoopedWelcomeMessage() {
        boolean continuousWelcome = true;
        Scanner sc = new Scanner(System.in);
        while (continuousWelcome) {
            displayWelcomeMessage("EN");
            System.out.println("Would you like to be greeted again Y/N ?");
            String answer = manageIncorrectAnswer(sc.nextLine());
            continuousWelcome = answer.equalsIgnoreCase("y");
        }
    }

    private static String manageIncorrectAnswer(String answer) {
        Scanner sc = new Scanner(System.in);
        if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
            while(true) {
                System.out.println("Illegal response \"" + answer + "\" please answer by Y or N");
                answer = sc.nextLine();
                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))
                    break;
            }
        }

        return answer;
    }

}
