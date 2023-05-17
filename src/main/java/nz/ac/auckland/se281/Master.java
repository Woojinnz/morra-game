package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Master implements Intensity {
  private int count;
  private Strategy strat;
  private int humanSum;
  ArrayList<Integer> humanFingers;

  public Master(int count, int humanSum, ArrayList<Integer> humanFingers) {
    this.count = count;
    this.humanSum = humanSum;
    this.humanFingers = humanFingers;
  }

  @Override
  public void code() {
    if (count >= 3 && count % 2 == 0) {
      strat = new Top(humanSum, count, humanFingers);

    } else if (count >= 3 && count % 2 == 1) {
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
