import javax.swing.JOptionPane;

public class RPS
{
    public static void main(String[] args)
    {
        final int NUM_GAMES = 10;
        int com;
        int userScore = 0;
        int comScore = 0;
        int tieGame = 0;
        int gameCount = 0;
        String userPick = "";
        String comPick = "";

        while (gameCount < NUM_GAMES) 
        {
            gameCount++;
            com = (int)(Math.random() * 3) + 1; 

            // Reset strings each time a new round is played
            userPick = "";

            // Validate the player data, allowing for some misspellings, loop dialog prompt if user gives invalid selection
            while (!userPick.equals("rock") && !userPick.equals("paper") && !userPick.equals("scissors"))
            {
                userPick = JOptionPane.showInputDialog(null, "Rock, Paper, or Scissors?");
                userPick = userPick.toLowerCase();

                if (userPick.startsWith("ro"))
                {
                    userPick = "rock";
                }
                else
                {
                    if(userPick.startsWith("pa"))
                    {
                        userPick = "paper";
                    }
                    else
                    {
                        if (userPick.startsWith("sc"))
                        {
                            userPick = "scissors";
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Invalid entry");
                        }
                    }
                }
            }

            switch(com)
            {
                case 1: comPick = "rock";
                        break;
                case 2: comPick = "paper";
                        break;
                default: comPick = "scissors";
            }


            if (userPick.equals(comPick))
            {
                tieGame++;
                tieGame(userPick);
                scoreCall(userScore, comScore);
            }
            else
            {
                switch(userPick)
                {
                    case "rock": 
                        switch(comPick)
                        {
                            case "paper":
                                comScore++;
                                comWin(userPick, comPick);
                                scoreCall(userScore, comScore);
                                break;
                            case "scissors":
                                userScore++;
                                userWin(userPick, comPick);
                                scoreCall(userScore, comScore);
                                break;
                        }
                        break;
                    case "paper":
                        switch(comPick)
                        {
                            case "scissors":
                                comScore++;
                                comWin(userPick, comPick);
                                scoreCall(userScore, comScore);
                                break;
                            case "rock":
                                userScore++;
                                userWin(userPick, comPick);
                                scoreCall(userScore, comScore);
                                break;
                        }
                        break;
                    case "scissors":
                        switch(comPick)
                        {
                            case "rock":
                                comScore++;
                                comWin(userPick, comPick);
                                scoreCall(userScore, comScore);
                                break;
                            case "paper":
                                userScore++;
                                userWin(userPick, comPick);
                                scoreCall(userScore, comScore);
                                break;
                        }
                        break;
                }
            }
        }
        
        if (comScore > userScore)
        {
            JOptionPane.showMessageDialog(null, "Computer Wins! " + comScore + " to " + userScore + "\nYou had " + tieGame + " tie games, and you played " + gameCount + " rounds.");
        }
        else if (userScore > comScore)
        {
            JOptionPane.showMessageDialog(null, "User wins! " + userScore + " to " + comScore + "\nYou had " + tieGame + " tie games, and you played " + gameCount + " rounds.");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Tie game! " + userScore + " to " + comScore + "\nYou had " + tieGame + " tie games, and you played " + gameCount + " rounds.");
        }
    }

    public static void comWin(String user, String com)
    {
        JOptionPane.showMessageDialog(null, "Computer wins! " + com + " beats " + user);
    }

    public static void userWin(String user, String com)
    {
        JOptionPane.showMessageDialog(null, "You win! " + user + " beats " + com);
    }

    public static void tieGame(String choice)
    {
        JOptionPane.showMessageDialog(null, "Tie game! You both chose " + choice);
    }

    public static void scoreCall(int user, int com)
    {
        JOptionPane.showMessageDialog(null, "Your score: " + user + ", Computer score: " + com);
    }
}
