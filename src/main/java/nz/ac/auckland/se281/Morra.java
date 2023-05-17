package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  private String name;
  private int count;
  private Difficulty difficulty;
  private int stratCount;
  private int humanSum;
  private boolean playing;
  private ArrayList<Integer> humanFingers = new ArrayList<Integer>();
  private int humanWins;
  private int aiWins;
  private int pointsToWin;

  public Morra() {
    stratCount = 0;

    playing = false;
    humanFingers.clear();
  }

  // Code to create a newGame, this initalizes a lot of variables within the game.
  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    name = options[0];
    humanWins = 0;
    aiWins = 0;
    MessageCli.WELCOME_PLAYER.printMessage(name);
    count = 1;
    this.difficulty = difficulty;
    playing = true;
    this.pointsToWin = pointsToWin;
  }

  public int getStratCount() {
    return stratCount;
  }

  public Difficulty getDifficulty() {
    return difficulty;
  }

  public int getHumanSum() {
    return humanSum;
  }

  public ArrayList<Integer> getHumanFingers() {
    return humanFingers;
  }

  // play code which does the heavy work it sends the difficulty to jarvis alongside the game count
  // and such so that jarvis can correctly output its amount of fingers and sum.
  public void play() {

    if (playing == true) {
      MessageCli.START_ROUND.printMessage(Integer.toString(count));
      MessageCli.ASK_INPUT.printMessage();

      while (playing == true) {

        String input = Utils.scanner.nextLine();

        if (input.matches("^\\d \\d{1,2}$")) {

          String parts[] = input.split(" ", 2);
          int finger = Integer.parseInt(parts[0]);
          int sum = Integer.parseInt(parts[1]);
          humanFingers.add(finger);

          if (finger >= 1 && finger <= 5 && sum >= 1 && sum <= 10) {
            MessageCli.PRINT_INFO_HAND.printMessage(
                name, Integer.toString(finger), Integer.toString(sum));

            Jarvis jarvis = new Jarvis(this);
            String[] ai = jarvis.play();
            String fingerJarvis = ai[0];
            String sumJarvis = ai[1];

            MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", fingerJarvis, sumJarvis);

            int victory =
                calcuateWhoWon(
                    finger, Integer.parseInt(fingerJarvis), sum, Integer.parseInt(sumJarvis));

            switch (victory) {
              case 2:
                MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");

                humanWins++;
                break;
              case 1:
                MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
                aiWins++;
                break;
              default:
                MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
            }

            if (humanWins == pointsToWin) {
              MessageCli.END_GAME.printMessage(name, Integer.toString(count));
              playing = false;
            } else if (aiWins == pointsToWin) {
              MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(count));
              playing = false;
            }

            count++;
            stratCount++;
            humanSum += finger;

            break;

          } else {
            MessageCli.INVALID_INPUT.printMessage();
          }
        } else {
          MessageCli.INVALID_INPUT.printMessage();
        }
      }
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  // The showStats class, which just prints the current stats of the game and the wins and how much
  // more to win.
  public void showStats() {
    if (playing == false) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {

      int humanToWin = pointsToWin - humanWins;
      int aiToWin = pointsToWin - aiWins;
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          name, Integer.toString(humanWins), Integer.toString(humanToWin));

      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "Jarvis", Integer.toString(aiWins), Integer.toString(aiToWin));
    }
  }

  public int calcuateWhoWon(int finger, int fingerai, int sum, int ai_sum) {
    if (finger + fingerai == sum & finger + fingerai != ai_sum) {
      return 2;
    } else if (finger + fingerai == ai_sum & finger + fingerai != sum) {
      return 1;
    } else {
      return 0;
    }
  }
}
