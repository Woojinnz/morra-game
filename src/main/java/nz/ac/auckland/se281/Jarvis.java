package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Jarvis {

  private Intensity level;
  private Strategy strat;

  public Jarvis(Difficulty difficulty, int count, int humanSum, ArrayList<Integer> humanFingers) {

    this.level = DifficultyFactory.createLevel(difficulty, count, humanSum, humanFingers);

    this.strat = level.getStrat();
  }

  public void changeStrat(Morra game) {}

  public String[] play() {
    return strat.decideAction();
  }
}
