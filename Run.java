import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Deck deck = new Deck();
        ArrayList<Player> players = new ArrayList<>();

        for(Card card : deck.getCards())
        {
            System.out.println(card);
        }
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many players do you want: ");
        int num_players = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < num_players; i++)
        {
            System.out.println("What is player " + (i + 1) + "'s name: ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }
        
        System.out.println(players);

        deck.shuffle();

        for(Player player : players)
        {
            player.askBet(player);
        }

        for(Player player : players)
        {
            player.getCard(deck);
            System.out.println(player.getName(player) + " your hand value is " + player.getHandValue());
        }

        for(Player player : players)
        {
            System.out.println(player.getName(player) + ", it is your turn");
            player.playTurn(deck);
            if (player.checkBust(player))
            {
                System.out.println("You busted loser!");
            }

        }
    
    }
}
