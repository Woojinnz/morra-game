package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Jarvis {

  private Intensity level;

  public Jarvis(Difficulty difficulty, int count, int humanSum, ArrayList<Integer> humanFingers) {

    this.level = DifficultyFactory.createLevel(difficulty, count, humanSum, humanFingers);
  }

  public Strategy setStrat(Intensity level) {
    this.level = level;
    return level.getStrat();
  }

  public String[] play() {
    return setStrat(level).decideAction();
  }
}
