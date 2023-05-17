package nz.ac.auckland.se281;


public class Jarvis {

  private Intensity level;
  private Strategy strat;

  public Jarvis(Morra game) {

    this.level =
        DifficultyFactory.createLevel(
            game.getDifficulty(), game.getStratCount(), game.getHumanSum(), game.getHumanFingers());

    this.strat = level.getStrat();
  }

  public void changeStrat(Morra game) {}

  public String[] play() {
    return strat.decideAction();
  }
}
