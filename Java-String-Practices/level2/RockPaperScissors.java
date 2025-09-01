import java.util.Scanner;

public class RockPaperScissors {

    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        switch (choice) {
            case 0: return "rock";
            case 1: return "paper";
            default: return "scissors";
        }
    }

    public static String determineWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("paper") && computer.equals("rock")) ||
            (user.equals("scissors") && computer.equals("paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    public static String[][] calculateStats(int userWins, int computerWins, int draws, int totalGames) {
        double userPercent = (userWins * 100.0) / totalGames;
        double computerPercent = (computerWins * 100.0) / totalGames;
        double drawPercent = (draws * 100.0) / totalGames;

        String[][] stats = {
            {"User", String.valueOf(userWins), String.format("%.2f%%", userPercent)},
            {"Computer", String.valueOf(computerWins), String.format("%.2f%%", computerPercent)},
            {"Draw", String.valueOf(draws), String.format("%.2f%%", drawPercent)}
        };
        return stats;
    }

    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.printf("%-10s %-10s %-10s%n", "Game", "User", "Computer");
        System.out.println("----------------------------");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.printf("%-10d %-10s %-10s%n", i + 1, gameResults[i][0], gameResults[i][1]);
        }

        System.out.println("\nOverall Stats:");
        System.out.printf("%-10s %-10s %-10s%n", "Player", "Wins", "Percentage");
        System.out.println("--------------------------------");
        for (int i = 0; i < stats.length; i++) {
            System.out.printf("%-10s %-10s %-10s%n", stats[i][0], stats[i][1], stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of games to play:");
        int totalGames = sc.nextInt();
        sc.nextLine();

        String[][] gameResults = new String[totalGames][2];
        int userWins = 0, computerWins = 0, draws = 0;

        for (int i = 0; i < totalGames; i++) {
            System.out.println("Enter your choice for game " + (i + 1) + " (rock/paper/scissors):");
            String userChoice = sc.nextLine().toLowerCase();
            String computerChoice = getComputerChoice();

            String winner = determineWinner(userChoice, computerChoice);
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;

            gameResults[i][0] = userChoice + (winner.equals("User") ? " (Win)" : winner.equals("Draw") ? " (Draw)" : "");
            gameResults[i][1] = computerChoice + (winner.equals("Computer") ? " (Win)" : winner.equals("Draw") ? " (Draw)" : "");
        }

        String[][] stats = calculateStats(userWins, computerWins, draws, totalGames);
        displayResults(gameResults, stats);

        sc.close();
    }
}
