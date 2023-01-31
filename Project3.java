import java.util.Scanner;

public class Main {

    static Scanner scanner;

    /**
     * method to display welcome message
     */
    public static void displayWelcomeMessage() {
        System.out.println("Hi. This is the program Project3 which was created by Raj.");
        System.out.println("It accepts 3 test scores as numbers between 0 and 100 and calculates the average.");
        System.out.println("Then find a matching grade letter and calculate GPA.");
        System.out.println("It works in the loop until an user decides to exit");
    }

    /**
     * method to display ending message
     */
    public static void displayEndingMessage() {
        System.out.println("Thank you for using this program");
    }

    /**
     * method to wait Enter key
     */
    public static void pressEnterToContinue() {
        System.out.print("Press Enter To Continue.");
        scanner.nextLine();
    }

    /**
     * method to get test score from user input
     * @return test score within 0-100 range
     */
    public static int getTestScore() {
        int score;
        do {
            System.out.print("Enter the test score between 0 and 100: ");
            score = scanner.nextInt();
            scanner.nextLine();
        } while (score < 0 || score > 100);
        return score;
    }

    /**
     * method to calculate average
     * @param one first number
     * @param two second number
     * @param three third number
     * @return average of three numbers
     */
    public static double calcAverage(int one, int two, int three) {
        return (one + two + three) / 3.0;
    }

    /**
     * method to find letter grade by average value
     * @param courseAverage average numeric value
     * @return letter grade
     */
    public static char findLetterGrade(double courseAverage) {
        if (courseAverage > 90) {
            return 'A';
        }
        if (courseAverage > 80) {
            return 'B';
        }
        if (courseAverage > 70) {
            return 'C';
        }
        if (courseAverage > 60) {
            return 'D';
        }
        return 'F';
    }

    /**
     * method to calculate GPA
     * @param grade - letter grade
     * @return GPA
     */
    public static double calcGPA(char grade) {
        switch (grade) {
            case 'A':
                return 4.0;
            case 'B':
                return 3.0;
            case 'C':
                return 2.0;
            case 'D':
                return 1.0;
            case 'F':
                return 0;
        }
        return -1;
    }

    /**
     * method to get user decision if run the program again
     * @return 'Y' or 'N'
     */
    public static char runAgain() {
        char decision = 0;
        do {
            System.out.print("would you like to run the program again?(Y/N)");
            String userInput = scanner.nextLine();
            if (userInput.length() == 1) {
                decision = Character.toUpperCase(userInput.charAt(0));
            }
        } while (decision != 'Y' && decision != 'N');
        return decision;
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        char decision;
        displayWelcomeMessage();
        pressEnterToContinue();
        do {
            System.out.println("Enter three test scores");
            int first = getTestScore();
            System.out.println("The first score accepted");
            int second = getTestScore();
            System.out.println("The second score accepted");
            int third = getTestScore();
            System.out.println("The third score accepted");
            double average = calcAverage(first, second, third);
            System.out.println(String.format("Average of three grades:%.2f", average));
            char grade = findLetterGrade(average);
            System.out.println("The letter grade:" + grade);
            System.out.println(String.format("The GPA:%.3f", calcGPA(grade)));
            pressEnterToContinue();
            decision = runAgain();
        } while (decision == 'Y');
        displayEndingMessage();
        pressEnterToContinue();
    }

}
