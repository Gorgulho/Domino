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
    public void giveHand(Player one, Player two, Player three, Player four) throws NoMorePiecesToGive {
        try{
            Random sixsix = new Random();
            int a = sixsix.nextInt(0, 3);
            Player [] players = new Player[4];
            players[0] = one;
            players[1] = two;
            players[2] = three;
            players[3] = four;
            players[a].hand.add(allDominos.get(41));
            this.allDominos.remove(allDominos.get(41));
            Random rand = new Random();
            for(int i = 0; i < 7; i++){
                players[a].hand.add(this.allDominos.remove(rand.nextInt(this.allDominos.size())));
            }

            for(int i = 0; i < 4; i++){
                if(i != a){
                    for (int j = 0; j < 8; j++){
                        players[i].hand.add(this.allDominos.remove(rand.nextInt(this.allDominos.size())));
                    }
                }
            }
        } catch (RuntimeException e) {
            throw new NoMorePiecesToGive("No more hand's can be given\n" + e);
        }
    }
}
