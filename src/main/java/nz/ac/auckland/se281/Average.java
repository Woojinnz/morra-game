package nz.ac.auckland.se281;

public class Average implements Strategy {
  private int fingers;
  private int sum;
  private double avg;

  public Average(int humanSum, int count) {
    fingers = 0;
    sum = 0;
    avg = ((double) humanSum) / count;
    avg = Math.round(avg * 1) / 1.0;
  }

  @Override
  public String[] decideAction() {
    fingers = Utils.getRandomNumber(1, 5);
    sum = fingers + (int) avg;

    String[] jarvis = {Integer.toString(fingers), Integer.toString(sum)};
    return jarvis;
  }
}
