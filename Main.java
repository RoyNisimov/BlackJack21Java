import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Deck deck = new Deck();
        try {
            playAHand(deck);

        } catch (InterruptedException e){

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
        System.out.println("Player:");
        player.printHand();
        System.out.println("Dealer:");
        dealer.printHand();
        String inp = input("Hit? [0] No [1] Yes\n");
        while ((Objects.equals(inp, "1") || Objects.equals(inp, ""))){
            player.AddCard(deck.draw());
            System.out.println("Player:");
            player.printHand();
            System.out.println("Dealer:");
            dealer.printHand();
            if (player.isBusted()){
                System.out.println("You busted!");
                dealerWon(player, dealer);
                break;
            }
            if (player.sum() == 21){
                if (dealer.sum() == 21){
                    tie(player, dealer);
                    break;
                }
                playerWon(player, dealer);
                break;
            }
            inp = input("Hit? [0] No [1] Yes\n");
        }
        dealer.AddCard(deck.draw());
        while (dealer.sum() < 17 && !dealer.isBusted()){
            dealer.AddCard(deck.draw());
            System.out.println("Dealer:");
            dealer.printHand();
            TimeUnit.SECONDS.sleep(1);
            if (dealer.isBusted()){
                playerWon(player, dealer);
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

    }
    public static void playerWon(Hand player, Hand dealer) {
        System.out.println("Player:");
        player.printHand();
        System.out.println("Dealer:");
        dealer.printHand();
        System.out.println("PLAYER WON");
    }
    public static void dealerWon(Hand player, Hand dealer){
        System.out.println("Player:");
        player.printHand();
        System.out.println("Dealer:");
        dealer.printHand();
        System.out.println("DEALER WON");

    }public static void tie(Hand player, Hand dealer){
        System.out.println("Player:");
        player.printHand();
        System.out.println("Dealer:");
        dealer.printHand();
        System.out.println("TIE");

    }






}
