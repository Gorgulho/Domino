import java.util.LinkedList;
import java.util.Random;

public class Dealer {
    private LinkedList <Domino> allDominos;

    /**
     * Creates the dealer with all the possible Dominos
     * @param allDominos - LinkedList<Domino> with all the possible Dominos.
     */
    public Dealer(LinkedList <Domino> allDominos){
        this.allDominos = allDominos;
    }

    /**
     *
     * @return an array with 4 LinkedList's with 7 pieces each.
     *         Each LinkList it's a hand for each player.
     * @throws NoMorePiecesToGive - If this method is call more than one time, this exception will be trown with the sentence "No more hand's can be given".
     */
    public LinkedList<Domino>[] giveHand() throws NoMorePiecesToGive {
        try{
            Random rand = new Random();
            LinkedList<Domino>[] hands = new LinkedList[4];

            hands[0] = new LinkedList<>();
            hands[1] = new LinkedList<>();
            hands[2] = new LinkedList<>();
            hands[3] = new LinkedList<>();

            for (int j = 0; j <=6; j++){
                hands[0].add(this.allDominos.remove(rand.nextInt(this.allDominos.size())));
                hands[1].add(this.allDominos.remove(rand.nextInt(this.allDominos.size())));
                hands[2].add(this.allDominos.remove(rand.nextInt(this.allDominos.size())));
                hands[3].add(this.allDominos.remove(rand.nextInt(this.allDominos.size())));
            }

            return hands;
        } catch (RuntimeException e) {
            throw new NoMorePiecesToGive("No more hand's can be given\n" + e);
        }
    }
}
