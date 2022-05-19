import java.util.LinkedList;
import java.util.Random;

public class Dealer {
    private final LinkedList<Domino> allDominos;

    /**
     *
     */
    public Dealer(){
        this.allDominos = new LinkedList<>();
        setDominos();
        for (Domino dm : allDominos){
            System.out.println(dm.getClass().getName() + dm.isPair() + dm);
        }
    }

    /**
     *
     */
    private void setDominos(){
        for (int i = 0; i <= 6; i++){
            for (int j = 0; j <= i; j++){
                this.allDominos.add(new Domino(i, j));
            }
        }
    }

    /**
     *
     * @return
     * @throws NoMorePiecesToGive
     */
    public LinkedList<Domino> giveHand() throws NoMorePiecesToGive {
        try{
            Random rand = new Random();
            LinkedList<Domino> hand = new LinkedList<>();
            for (int i = 0; i < 7; i++){
                hand.add(this.allDominos.remove(rand.nextInt(this.allDominos.size())));
            }
            return hand;
        } catch (RuntimeException e) {
            throw new NoMorePiecesToGive("No more hand's can be given\n" + e);
        }

    }
}
