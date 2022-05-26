import java.util.LinkedList;
import java.util.List;

public class Client {
    /**
     * Creates all the possible Dominos.
     * @return a LinkedList<Domino> with all the possible Dominos.
     */
    private static LinkedList<Domino> createDominos() {
        LinkedList<Domino> pieces = new LinkedList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) pieces.add(new Pair(i));
                else pieces.add(new Piece(i, j));
            }
        }
        return pieces;
    }

    /**
     * Goes truh all the playes in the array and calculate the points for each player.
     * @param players Array with the players that we want to calculate the points.
     */
    private static void calculatePlayersPoints(Player[] players){
        for (Player p : players){
            p.calculatePoints();
        }
    }

    /**
     * orders all the players in a growing way.
     * @param players Array with the players.
     * @param pIndex Index in the players array where the wining player is.
     * @return Array with the players ordered by the first place to the fourth place.
     */
    private static Player[] getPodium(Player[] players, int pIndex){
        Player[] podium = new Player[players.length];
        int count = 0;
        podium[count++] = players[pIndex];
        for (Player p : players){
            if (podium[0] != p){
                podium[count++] = p;
            }
        }

        for (int i = 1; i < podium.length; i++){
            int j = i;
            while (j > 0 && podium[j - 1].getPoints() > podium[j].getPoints()) {
                Player temp = podium[j - 1];
                podium[j - 1] = podium[j];
                podium[j] = temp;
                j--;
            }
        }
        return podium;
    }

    /**
     * Prints the classification board for the players.
     * @param players Array with the players.
     * @param pIndex Index in the players array where the wining player is.
     */
    private static void printResults(Player[] players, int pIndex){
        calculatePlayersPoints(players);

        Player[] podium = getPodium(players, pIndex);

        System.out.println("Primeiro - Vencedor " + podium[0]);
        System.out.println("Segundo " + podium[1]);
        System.out.println("Terceiro " + podium[2]);
        System.out.println("Quarto " + podium[3]);
    }

    /**
     * Searches in all the players with of them has the 6|6 piece.
     * @param pl Array with the players.
     * @return Index of the player with the piece 6|6, -1 otherwise.
     */
    private static int findSixSix(Player[] pl) {
        Domino sixSix = new Pair(6);
        for (int i = 0; i < pl.length; i++) {
            if (pl[i].hasPiece(sixSix)) return i;
        }
        return -1;
    }


    public static void main(String[] args) throws NoMorePiecesToGive {
        Dealer d = new Dealer(createDominos());
        LinkedList<Domino>[] hands = d.giveHand();

        //Players creation
        Player[] players = new Player[4];

        players[0] = new Bot(hands[0]);      //bot
        players[1] = new Bot(hands[1]);      //bot
        players[2] = new Bot(hands[2]);      //bot
        players[3] = new Person(hands[3]);   //person

        int playerIndice = findSixSix(players);

        //Board creation
        Board b = new Board(players[playerIndice++].givePiece(6, 6), 56, 84);

        Domino[] piecesToPlay;

        LinkedList<Domino> piecesCantPlay = new LinkedList<>();

        //where all the players will play, stops the play if one player gets out of pieces or the board has no more possible corners
        while (players[0].hasPieces() && players[1].hasPieces() && players[2].hasPieces() && players[3].hasPieces() && b.getCornersDomino().size() != 0) {
            if (playerIndice == 4) playerIndice = 0;
            if (playerIndice == 3) {
                b.boardState();
                System.out.println(players[playerIndice].getHand());
            }
            if (playerIndice == 3) {
                piecesToPlay = players[playerIndice].play(b.getCornersDomino());
                if (piecesToPlay != null) {

                    List<Side> doubleCheck = b.canConectNode(piecesToPlay[0], piecesToPlay[1]);
                    if (doubleCheck.size() != 0) {
                        if (!b.addDominoToCorner(piecesToPlay[0], piecesToPlay[1])) {
                            piecesCantPlay.add(piecesToPlay[0]);
                            players[playerIndice].recivePiecesBack(piecesCantPlay);
                        }
                    }
                }
            } else {
                while (true) {
                    piecesToPlay = players[playerIndice].play(b.getCornersDomino());
                    if (piecesToPlay != null) {
                        List<Side> doubleCheck = b.canConectNode(piecesToPlay[0], piecesToPlay[1]);
                        if (doubleCheck.size() != 0) {
                            if (!b.addDominoToCorner(piecesToPlay[0], piecesToPlay[1])) {
                                piecesCantPlay.add(piecesToPlay[0]);
                            } else {
                                players[playerIndice].recivePiecesBack(piecesCantPlay);
                                break;
                            }
                        } else piecesCantPlay.add(piecesToPlay[0]);
                    } else {
                        players[playerIndice].recivePiecesBack(piecesCantPlay);
                        break;
                    }
                }

            }
            playerIndice++;
        }
        b.boardState();

        printResults(players, playerIndice - 1);
    }
}
