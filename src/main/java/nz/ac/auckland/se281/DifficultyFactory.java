package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {
// This is the Factory Design method, where the factory decides the difficulty in realtime.
  public static Intensity createLevel(
      Difficulty intensity, int count, int humanSum, ArrayList<Integer> humanFingers) {

    Intensity result;
    switch (intensity) {
      case EASY:
        {
          result = new EasyDifficulty();
          break;
        }

      case MEDIUM:
        {
          result = new Medium(count, humanSum);
          break;
        }

      case HARD:
        {
          result = new HardDifficulty(count, humanSum, humanFingers);
          break;
        }

      case MASTER:
        {
          result = new Master(count, humanSum, humanFingers);
          break;
        }

      default:
        return null;
    }

    if (result != null) {
      result.code();
    }
    return result;
  }
}
