import java.util.*;

public class DiceGameSimulation {
    private static final int DICE_COUNT = 5;
    private static final int SIMULATIONS = 10000;
    private static final Random rand = new Random();

    public static void main(String[] args) {
        Map<Integer, Integer> scoreFrequency = new TreeMap<>();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < SIMULATIONS; i++) {
            int score = simulateGame();
            scoreFrequency.put(score, scoreFrequency.getOrDefault(score, 0) + 1);
        }

        long endTime = System.currentTimeMillis();
        double duration = (endTime - startTime) / 1000.0;

        System.out.println("Number of simulations was " + SIMULATIONS + " using " + DICE_COUNT + " dice.");
        for (Map.Entry<Integer, Integer> entry : scoreFrequency.entrySet()) {
            int score = entry.getKey();
            int count = entry.getValue();
            double percentage = (double) count / SIMULATIONS * 100;
            System.out.printf("Total %d occurs %.2f occurred %.1f times.%n", score, percentage / 100, (double) count);
        }

        System.out.printf("Total simulation took %.2f seconds.%n", duration);
    }

    private static int simulateGame() {
        List<Integer> dice = rollDice(DICE_COUNT);
        int totalScore = 0;

        while (!dice.isEmpty()) {
            if (dice.contains(3)) {
                // Remove all 3s and score 0
                dice.removeIf(die -> die == 3);
                // 0 score for this roll
            } else {
                // Remove the lowest die and add its value to total score
                int min = Collections.min(dice);
                totalScore += min;
                dice.remove((Integer) min);
            }

            if (!dice.isEmpty()) {
                dice = rollDice(dice.size());
            }
        }

        return totalScore;
    }

    private static List<Integer> rollDice(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(rand.nextInt(6) + 1);
        }
        return result;
    }
}
