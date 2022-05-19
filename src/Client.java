import org.junit.platform.engine.support.descriptor.FileSystemSource;

import java.util.LinkedList;
public class Client {
    public static void main(String[] args) throws NoMorePiecesToGive {
        LinkedList<Domino> allDominos = new LinkedList<>();
        for(int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                allDominos.add(new Domino(i, j));
            }
        }
        Board b = new Board(allDominos.get(41), 56, 84);
        Player one = new Player();
        Player two = new Player();
        Player three = new Player();
        Player p = new Player();
        Dealer d = new Dealer(allDominos);
        d.giveHand(one, two, three, p);
    }
}
/* Domino zeroZero = new Domino(0, 0);
        Domino zeroOne = new Domino(0, 1);
        Domino zeroTwo = new Domino(0, 2);
        Domino zeroThree = new Domino(0, 3);
        Domino zeroFour = new Domino(0, 4);
        Domino zeroFive = new Domino(0, 5);
        Domino zeroSix = new Domino(0, 6);
        Domino oneZero = new Domino(1, 0);
        Domino oneTwo = new Domino(1, 1);
        Domino oneThree = new Domino(1, 2);
        Domino oneFour = new Domino(1, 3);
        Domino oneFive = new Domino(1, 4);
        Domino oneSix = new Domino(1, 5);
        Domino twoZero = new Domino(1, 6);
        Domino twoOne = new Domino(2, 0);
        Domino twoTwo = new Domino(2, 1);
        Domino twoThree = new Domino(2, 2);
        Domino twoFour= new Domino(2, 3);
        Domino twoFive = new Domino(2, 4);
        Domino twoSix = new Domino(2, 5);
        Domino threeZero = new Domino(2, 6);
        Domino threeOne = new Domino(3, 1);
        Domino threeTwo = new Domino(3, 2);
        Domino threeThree = new Domino(3, 3);
        Domino threeFour = new Domino(3, 4);
        Domino threeFive = new Domino(3, 5);
        Domino threeSix = new Domino(3, 6);
        Domino fourZero = new Domino(4, 0);
        Domino fourOne = new Domino(4, 1);
        Domino fourTwo = new Domino(4, 2);
        Domino fourThree = new Domino(4, 3);
        Domino fourFour = new Domino(4, 4);
        Domino fourFive = new Domino(4, 5);
        Domino fourSix = new Domino(4, 6);
        Domino fiveZero = new Domino(5, 0);
        Domino fiveOne = new Domino(5, 1);
        Domino fiveTwo = new Domino(5, 2);
        Domino fiveThree = new Domino(5, 3);
        Domino fiveFour = new Domino(5, 4);
        Domino fiveFive = new Domino(5, 5);
        Domino fiveSix = new Domino(5, 6);
        Domino sixZero = new Domino(6, 0);
        Domino sixOne = new Domino(6, 1);
        Domino sixTwo = new Domino(6, 2);
        Domino sixThree = new Domino(6, 3);
        Domino sixFour = new Domino(6, 4);
        Domino sixFive = new Domino(6, 5);
        Domino sixSix = new Domino(6, 6);
        LinkedList<Domino> allPieces;*/