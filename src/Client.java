import java.util.LinkedList;
import java.util.Random;

public class Client {
    private static LinkedList<Domino> createDominos(){
        LinkedList<Domino> pieces = new LinkedList<>();
        for (int i = 0; i <= 6; i++){
            for (int j = 0; j <= i; j++){
                if (i == j) pieces.add(new Pair(i));
                else pieces.add(new Piece(i, j));
            }
        }
        return pieces;
    }

    private static int findSixSix(Player[] pl){
        Domino sixSix = new Pair(6);
        for (int i = 0; i < pl.length; i++){
            if (pl[i].hasPiece(sixSix)) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws NoMorePiecesToGive {

        Dealer d = new Dealer(createDominos());
        LinkedList<Domino>[] hands = d.giveHand();

        Player[] players = new Player[4];

        players[0] = new Bot(hands[0]);      //bot
        players[1] = new Bot(hands[1]);      //bot
        players[2] = new Bot(hands[2]);      //bot
        players[3] = new Person(hands[3]);   //person

        int playerIndice = findSixSix(players);

        Board b = new Board(players[playerIndice].givePiece(6, 6), 56, 84);

        for(Player p : players){
            System.out.println(p.getHand() + p.getClass().getName());
        }
        b.addDominoToCorner(new Piece(6, 4), new Pair(6));
        players[0].play();
        //System.out.println(b);

        /*Domino a = new Domino(7, 7);
        b.fillPrint();
        b.printTurn(a, 15, 15);
        while(players[0].hasPieces() || players[1].hasPieces() || players[2].hasPieces() || players[3].hasPieces()){
            b.printTurn(new Domino(7, 7), 15, 15);
        }*/
    }
}
