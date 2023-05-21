package nz.ac.auckland.se281;

public class Medium implements Intensity {
  private int count;
  private Strategy strat;
  private int humanSum;

  public Medium(int count, int humanSum) {
    this.count = count;
    this.humanSum = humanSum;
    System.out.println(count);
  }

  @Override
  public void code() {
    if (count >= 3) {
      strat = new Average(humanSum, count);

    } else {
      strat = new RandomStrat();
    }
  }

  @Override
  public Strategy getStrat() {
    return strat;
  }
}
