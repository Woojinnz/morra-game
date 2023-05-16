package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  private String name;
  private int count;
  private Difficulty difficulty;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
    count = 1;
    this.difficulty = difficulty;
  }

  public void play() {
    String playing = "true";
    MessageCli.START_ROUND.printMessage(Integer.toString(count));
    MessageCli.ASK_INPUT.printMessage();
    while (playing == "true") {

      String input = Utils.scanner.nextLine();

      if (input.length() >= 3 && input.length() <= 4) {
        String parts[] = input.split(" ", 2);
        int finger = Integer.parseInt(parts[0]);
        int sum = Integer.parseInt(parts[1]);

        if (finger >= 1 && finger <= 5 && sum >= 1 && sum <= 10) {
          MessageCli.PRINT_INFO_HAND.printMessage(
              name, Integer.toString(finger), Integer.toString(sum));

          Jarvis jarvis = new Jarvis(difficulty);

          String[] AI = jarvis.play();
          String fingerAI = AI[0];
          String sumAI = AI[1];

          MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", fingerAI, sumAI);

          int victory = win(finger, Integer.parseInt(fingerAI), sum, Integer.parseInt(sumAI));

          switch (victory) {
            case 2:
              MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
              break;
            case 1:
              MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
              break;
            default:
              MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
          }

          count++;

          break;

        } else {
          MessageCli.INVALID_INPUT.printMessage();
        }
      } else {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }
  }

  public void showStats() {}

  public int win(int finger, int fingerai, int sum, int ai_sum) {
    if (finger + fingerai == sum & finger + fingerai != ai_sum) {
      return 2;
    } else if (finger + fingerai == ai_sum & finger + fingerai != sum) {
      return 1;
    } else {
      return 0;
    }
  }
}
