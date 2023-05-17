package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {
  // This is the Factory Design method, where the factory decides the difficulty in realtime.
  public static Intensity createLevel(
      Difficulty intensity, int count, int humanSum, ArrayList<Integer> humanFingers) {
    // This is the factory method, which decides which difficulty to use based on the difficlty
    Intensity result;
    switch (intensity) {
        // This is the easy difficulty, which is the same as the random strategy
      case EASY:
        {
          result = new EasyDifficulty();
          break;
        }
        // This is the medium difficulty, which is the same as the average + random strategy
      case MEDIUM:
        {
          result = new Medium(count, humanSum);
          break;
        }
        // This is the hard difficulty, which is the same as the top + random strategy
      case HARD:
        {
          result = new HardDifficulty(count, humanSum, humanFingers);
          break;
        }
        // This is the master difficulty, which is the same as the top + average + random strategy
      case MASTER:
        {
          result = new Master(count, humanSum, humanFingers);
          break;
        }

      default:
        return null;
    }
    // This is the code block which runs the strategy
    if (result != null) {
      result.code();
    }
    return result;
  }
}
