package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Top implements Strategy {
  private int fingers;
  private int sum;
  private int highest;

  ArrayList<Integer> humanFingers;
  ArrayList<Integer> mostPicked;

  private int jarvisFingers;

  public Top(int humanSum, int count, ArrayList<Integer> humanFingers) {
    fingers = 0;
    sum = 0;
    highest = 0;
    this.humanFingers = humanFingers;

    mostPicked = new ArrayList<Integer>();

    for (int i = 0; i < 5; i++) {
      mostPicked.add(0);
    }
  }

  public ArrayList<Integer> getMostPicked(ArrayList<Integer> humanFingers) {
    for (Integer number : humanFingers) {
      mostPicked.set(number - 1, mostPicked.get(number - 1) + 1);
    }

    return mostPicked;
  }

  public int getHighest(ArrayList<Integer> array) {

    for (int i = 0; i < array.size(); i++) {
      if (array.get(i) > highest) {
        highest = array.get(i);
      }
    }
    return findPosition(highest);
  }

  public int findPosition(int element) {
    return mostPicked.indexOf(element) + 1;
  }

  @Override
  public String[] decideAction() {
    fingers = Utils.getRandomNumber(1, 5);
    jarvisFingers = getHighest(getMostPicked(humanFingers));
    sum = fingers + jarvisFingers;

    String[] Jarvis = {Integer.toString(fingers), Integer.toString(sum)};
    return Jarvis;
  }
}
