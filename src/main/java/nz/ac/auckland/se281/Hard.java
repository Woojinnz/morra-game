package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Hard implements Intensity {
  private int count;
  private Strategy strat;
  private int humanSum;
  ArrayList<Integer> humanFingers;

  public Hard(int count, int humanSum, ArrayList<Integer> humanFingers) {
    this.count = count;
    this.humanSum = humanSum;
    this.humanFingers = humanFingers;
  }

  @Override
  public void code() {
    if (count >= 3) {
      strat = new Top(humanSum, count, humanFingers);

    } else {
      strat = new RandomStrat();
    }
  }

  @Override
  public Strategy getStrat() {
    return strat;
  }
}
