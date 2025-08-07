import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Deck deck = new Deck();
        while (true){
            try {
                playAHand(deck);
                // System.out.println(deck.getCount());
            } catch (InterruptedException e){

            }
        }


    }

    public static String input(String prompt){
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        return s.nextLine();
    }

    public static void playAHand(Deck deck) throws InterruptedException {
        // burn a card.
        deck.burn();
        Hand player = new Hand();
        Hand dealer = new Hand();
        player.AddCard(deck.draw());
        dealer.AddCard(deck.draw());
        player.AddCard(deck.draw());
        Card dealerSecretCard = deck.draw();
        System.out.println(Colors.ANSI_BLUE + "Player:" + Colors.ANSI_RESET);
        player.printHand();
        System.out.println(Colors.ANSI_PURPLE + "Dealer: " + Colors.ANSI_RESET);
        dealer.printHand();
        // Player plays
        String inp = input(Colors.ANSI_RED + "[0] Stay "+ Colors.ANSI_GREEN + "[1] Hit\n" + Colors.ANSI_RESET);
        while ((Objects.equals(inp, "1") || Objects.equals(inp, ""))){
            player.AddCard(deck.draw());
            System.out.println(Colors.ANSI_BLUE + "Player:" + Colors.ANSI_RESET);

            player.printHand();
            System.out.println(Colors.ANSI_PURPLE + "Dealer: " + Colors.ANSI_RESET);
            dealer.printHand();
            if (player.isBusted()){
                System.out.println("You busted!");
                dealerWon(player, dealer);
                return;
            }
            if (player.sum() == 21){
                if (dealer.sum() == 21){
                    tie(player, dealer);
                    return;
                }
                playerWon(player, dealer);
                return;
            }
            inp = input(Colors.ANSI_RED + "[0] Stay "+ Colors.ANSI_GREEN + "[1] Hit\n" + Colors.ANSI_RESET);
        }

        // dealer plays
        dealer.AddCard(dealerSecretCard);
        while (dealer.sum() < 17 && !dealer.isBusted()){
            dealer.AddCard(deck.draw());
            System.out.println(Colors.ANSI_PURPLE + "Dealer: " + Colors.ANSI_RESET);
            dealer.printHand();
            TimeUnit.SECONDS.sleep(1);
            if (dealer.isBusted()){
                playerWon(player, dealer);
                return;
            }
        }

        if (dealer.sum() > player.sum()){
            dealerWon(player, dealer);
        }
        else if (dealer.sum() < player.sum()){
            playerWon(player, dealer);
        }
        else {
            tie(player, dealer);
        }

        // mucks cards
        dealer.muckHand(deck);
        player.muckHand(deck);
    }
    public static void playerWon(Hand player, Hand dealer) {
        System.out.println(Colors.ANSI_BLUE + "Player:" + Colors.ANSI_RESET);
        player.printHand();
        System.out.println(Colors.ANSI_PURPLE + "Dealer: " + Colors.ANSI_RESET);
        dealer.printHand();
        System.out.println(Colors.ANSI_GREEN + "PLAYER WON" + Colors.ANSI_RESET);
    }
    public static void dealerWon(Hand player, Hand dealer){
        System.out.println(Colors.ANSI_BLUE + "Player:" + Colors.ANSI_RESET);
        player.printHand();
        System.out.println(Colors.ANSI_PURPLE + "Dealer: " + Colors.ANSI_RESET);
        dealer.printHand();
        System.out.println(Colors.ANSI_RED + "DEALER WON" + Colors.ANSI_RESET);


    }public static void tie(Hand player, Hand dealer){
        System.out.println(Colors.ANSI_BLUE + "Player:" + Colors.ANSI_RESET);
        player.printHand();
        System.out.println(Colors.ANSI_PURPLE + "Dealer: " + Colors.ANSI_RESET);
        dealer.printHand();
        System.out.println("TIE");

    }
}
