package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Jarvis {

  private Intensity level;
  private Strategy strat;

  public Jarvis(Difficulty intensity) {
    this.level = DifficultyFactory.createLevel(intensity);

    this.strat = level.getStrat();
  }

  public String[] play() {
    return strat.decideAction();
  }
}
