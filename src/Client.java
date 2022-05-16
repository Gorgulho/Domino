public class Client {
    public static void main(String[] args) throws NoMorePiecesToGive {
        Dealer dl = new Dealer();
        System.out.printf(dl.giveHand().toString() + "\n");
        System.out.printf(dl.giveHand().toString() + "\n");
        System.out.printf(dl.giveHand().toString() + "\n");
        System.out.printf(dl.giveHand().toString() + "\n");
        System.out.printf(dl.giveHand().toString() + "\n");
    }
}
