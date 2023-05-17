package nz.ac.auckland.se281;

public class RandomStrat implements Strategy {
  private int fingers;
  private int sum;

  public RandomStrat() {
    fingers = 0;
    sum = 0;
  }

  @Override
  public String[] decideAction() {
    fingers = Utils.getRandomNumber(1, 5);

    sum = Utils.getRandomNumber(fingers + 1, fingers + 5);

    String[] jarvis = {Integer.toString(fingers), Integer.toString(sum)};

    return jarvis;
  }
}
