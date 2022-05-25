import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Person extends Player{

    /**
     *
     * @param hand - LinkedList with the 7 Dominos for the Person to use
     */
    public Person(LinkedList<Domino> hand){
        super(hand);
    }

    @Override
    public Domino[] play(LinkedList<Domino> corners) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a peca que quer jogar? (-1|-1 caso nao possa jogar)");
        String toPlay = sc.nextLine();
        if (Objects.equals(toPlay, "-1|-1")) return null;
        System.out.println("Qual o canto que quer jogar");
        String corner = sc.nextLine();

        String[] toPlaySplit = toPlay.split("\\|", 2);
        String[] cornerSplit = corner.split("\\|", 2);

        Domino pieceToPlay = new Piece(Integer.parseInt(toPlaySplit[0]), Integer.parseInt(toPlaySplit[1]));
        Domino pieceCorner = new Piece(Integer.parseInt(cornerSplit[0]), Integer.parseInt(cornerSplit[1]));

        if (this.hasPiece(pieceToPlay) && this.existsCorner(corners, pieceCorner)) {
            if (pieceCorner.canConnect(pieceToPlay) != null){
                return new Domino[]{pieceToPlay, pieceCorner};
            }
        }
        return null;
    }

    private boolean existsCorner(LinkedList<Domino> corners, Domino corner){
        for (Domino dm : corners){
            if (dm.compareTo(corner) > 0) return true;
        }
        return false;
    }

}
