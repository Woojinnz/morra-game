package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

  public static Intensity createLevel(Difficulty intensity) {

    Intensity result;
    switch (intensity) {
      case EASY:
        {
          result = new Easy();
          break;
        }

      case MEDIUM:

      case HARD:

      case MASTER:

      default:
        return null;
    }

    if (result != null) {
      result.code();
    }
    return result;
  }
}
