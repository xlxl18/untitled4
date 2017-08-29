import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class DotComBust {
    private  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses=0;
    GameHelper helper = new GameHelper();
    public void setUpGame() {
        dotComList.add(new DotCom());
        dotComList.add(new DotCom());
        dotComList.add(new DotCom());
        dotComList.get(0).setName("Pets.com");
        dotComList.get(1).setName("AskMe.com");
        dotComList.get(2).setName("Go2.com");
        System.out.println("Hi, your aim is to kill all of the shipes");
        System.out.println("Pets.com, AskMe.com, Go2.com");
        System.out.println("You need make as less trues as you can");
        for(DotCom dotComToSet: dotComList) {
           ArrayList<String> newLocation = helper.placeDotCom(3);
           dotComToSet.setLocationCells(newLocation);
        }
    }

    public void startPlaying() {
        while(!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("Make the course ");
            checkUserGuess(userGuess);
        }
    }
    public void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Miss";
        for(DotCom dotComToTest : dotComList) {
            result = dotComToTest.checkYourself(userGuess);
            if(result.equals("Caught")) {
                break;
            }
            if (result.equals("Killed")) {
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    public void finishGame() {
        System.out.println("All sites were destroyed!");
        if(numOfGuesses<=18) {
            System.out.println("You waste "+ numOfGuesses+" tries");

        }
        else {
            System.out.println("You waste a lot of time");
        }
    }
    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();

    }
}
