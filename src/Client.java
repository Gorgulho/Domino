import java.util.LinkedList;
import java.util.Random;

public class Client {
    private static LinkedList<Domino> createDominos(){
        LinkedList<Domino> pieces = new LinkedList<>();
        for (int i = 0; i <= 6; i++){
            for (int j = 0; j <= i; j++){
                pieces.add(new Domino(i, j));
            }
        }
        return pieces;
    }

    private static int findSixSix(Player[] pl){
        Domino sixSix = new Domino(6, 6);
        for (int i = 0; i < pl.length; i++){
            if (pl[i].hasPiece(sixSix)) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws NoMorePiecesToGive {
        //são criadas todas as peças de dominos e guardadas na linkedList. Esta linkedList será enviada ao dealer.
        /*for (int i = 0; i <= 6; i++){
            for (int j = 0; j <= i; j++){
                allDominos.add(new Domino(i, j));
            }
        }*/
        //tabuleiro criado e a peça presente em all.Dominos.get(27) é a 6|6 que será a firstDomino.
        // o tamanho 56 por 84 é o máximo possivel e previne situações em que todas as peças estão na horizontal
        // ou em que todas as peças estão na vertical.
        //os players são criados sendo que o player p será o user. O dealer é criado e são enviadas todas as peças
        // na linha 24, está o comando que faz com que as peças sejam distribuidas (na classe dealer).

        Dealer d = new Dealer(createDominos());
        LinkedList<Domino>[] hands = d.giveHand();

        Player[] players = new Player[4];

        players[0] = new Bot(hands[0]);      //bot
        players[1] = new Bot(hands[1]);      //bot
        players[2] = new Bot(hands[2]);      //bot
        players[3] = new Person(hands[3]);   //person

        int playerIndice = findSixSix(players);

        Board b = new Board(players[playerIndice].givePiece(6, 6), 56, 84);
        System.out.println(b);

        for(Player p : players){
            System.out.println(p.getHand() + p.getClass().getName());
        }
    }
}
/* Domino zeroZero = new Domino(0, 0);
        Domino zeroOne = new Domino(0, 1);
        Domino zeroTwo = new Domino(0, 2);
        Domino zeroThree = new Domino(0, 3);
        Domino zeroFour = new Domino(0, 4);
        Domino zeroFive = new Domino(0, 5);
        Domino zeroSix = new Domino(0, 6);
        Domino oneTwo = new Domino(1, 1);
        Domino oneThree = new Domino(1, 2);
        Domino oneFour = new Domino(1, 3);
        Domino oneFive = new Domino(1, 4);
        Domino oneSix = new Domino(1, 5);
        Domino twoZero = new Domino(1, 6);
        Domino twoThree = new Domino(2, 2);
        Domino twoFour= new Domino(2, 3);
        Domino twoFive = new Domino(2, 4);
        Domino twoSix = new Domino(2, 5);
        Domino threeZero = new Domino(2, 6);
        Domino threeThree = new Domino(3, 3);
        Domino threeFour = new Domino(3, 4);
        Domino threeFive = new Domino(3, 5);
        Domino threeSix = new Domino(3, 6);
        Domino fourFour = new Domino(4, 4);
        Domino fourFive = new Domino(4, 5);
        Domino fourSix = new Domino(4, 6);
        Domino fiveFive = new Domino(5, 5);
        Domino fiveSix = new Domino(5, 6);
        Domino sixSix = new Domino(6, 6);
        LinkedList<Domino> allPieces;*/