import java.util.ArrayList;
public class DotCom {
    private String name;
    ArrayList<String> locationCells= new ArrayList<String>();
    int numOfHits=0;

    public void setLocationCells(ArrayList<String> array) {
        locationCells=array;
    }
    public void setName(String name) {
        this.name=name;
    }

    public String checkYourself(String userGuess) throws NullPointerException {
        //int guess = Integer.parseInt(userGuess);
        String result="Missed";
        int index=locationCells.indexOf(userGuess);
        if(index>=0) {
            locationCells.remove(index);
        }

        if(locationCells.isEmpty()) {
            result="Killed";
        }
        else {
            result="Caught";
        }
        System.out.println(result);
        return result;
    }


}