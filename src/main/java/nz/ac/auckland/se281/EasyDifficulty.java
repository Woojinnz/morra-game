package nz.ac.auckland.se281;

public class EasyDifficulty implements Intensity {
  private Strategy strat;

  @Override
  public void code() {
    strat = new RandomStrat();
  }

  @Override
  public Strategy getStrat() {
    return strat;
  }
}
