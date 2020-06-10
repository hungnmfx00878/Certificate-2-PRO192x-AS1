import java.util.Random;
import java.util.Scanner;

public class LuckyNumber{
    public static final int MAXIMUM = 100; //Increase possible range of Lucky Number here.

    static int totalGame = 0;
    static int totalGuess = 0;
    static int bestGame = Integer.MAX_VALUE; //max value for comparing & specifying minimum tries.

    public static void main(String args[]){
        play();
        report();
    }

    private static void play() {
        Scanner scanner = new Scanner(System.in);
        Random generator = new Random();

        do {
            //Start a Game:
            int luckyNumber = generator.nextInt(MAXIMUM) + 1;
            System.out.println("The Lucky Number has just generated! Let's guess it!");
            System.out.println();
            int guessNumber;
            int countGuess = 0;

            do {
                //Give a try:
                System.out.print("Enter your Guess Number: ");
                guessNumber = scanner.nextInt();
                if (guessNumber > luckyNumber) {
                    System.out.println("Too High! The Lucky Number is lower!");
                    System.out.println();
                } else if (guessNumber < luckyNumber) {
                    System.out.println("Too Low! The Lucky Number is higher!");
                    System.out.println();
                }
                countGuess++;

            } while(guessNumber != luckyNumber);

            System.out.println();
            System.out.println("Congratulation! You found the Lucky Number after " + countGuess + " tries");
            System.out.println("Do you want to play again?");
            totalGame++;
            totalGuess += countGuess;
            bestGame = Math.min(bestGame, countGuess); //Compare to specify the best game with minimum tries.

        } while(Continue(scanner));
    }

    //Condition to play another game.
    private static boolean Continue(Scanner scanner) {
        String input = scanner.next().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }

    private static void report() {
        System.out.println();
        System.out.println("OVERALL");
        System.out.println("- Total Games: " + totalGame);
        System.out.println("- Total Guesses: " + totalGuess);
        System.out.println("- Average tries in one Game: " + (double)totalGuess/totalGame);
        System.out.println("- Best Game with " + bestGame + " tries");
    }

}