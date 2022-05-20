import java.util.LinkedList;

public class Bot extends Player{

    /**
     *
     * @param hand
     */
    public Bot(LinkedList<Domino> hand){
        this.hand = hand;
        this.points = 0;
        System.out.println(this.hand);
    }

    /**
     *
     */
    public void play(){

    }
}
