import java.util.LinkedList;
import java.util.Random;

public class Dealer {
    /**
     *
     */
    private LinkedList <Domino> allDominos;
    public Dealer(LinkedList <Domino> allDominos){
        this.allDominos = allDominos;
        //setDominos();
        for (Domino dm : allDominos){
            System.out.println(dm.getClass().getName() + dm.isPair() + dm);
        }
    }

    /**
     *
     */
    /*private void setDominos(){
        for (int i = 0; i <= 6; i++){
            for (int j = 0; j <= i; j++){
                this.allDominos.add(new Domino(i, j));
            }
        }
    }
*/
    /**
     *
     * @return
     * @throws NoMorePiecesToGive
     */
    //O dealer recebe os 4 players. O random sixsix é para decidir qual dos players ficará com a peça 6|6.
    //O a terá um valor entre [0;3] e será esse o valor do indice do array de players que ficará com a peça 6|6
    //como este player já terá uma peça atribuida, só temos de atribuir mais seis peças e por isso fiz à parte.
    //seguidamente são atribuidas peças aos outros players.

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
