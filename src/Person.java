import java.util.LinkedList;

public class Person extends Player{

    /**
     *
     * @param hand
     */
    public Person(LinkedList<Domino> hand){
        this.hand = hand;
        this.points = 0;
        System.out.println(this.hand);
    }

    public void play(){

    }
}
