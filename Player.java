import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String name;
    private double money;
    private double bet;
    private ArrayList<Card> hand = new ArrayList<>();

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
    }

    public void playTurn(Deck deck)
    {
        Scanner scanner = new Scanner(System.in);
        String action = "hit";
        
        while (action.equals("hit"))
        {
            System.out.println("Would you like to hit or stay (hit/stay) ");
            action = scanner.nextLine();

            if (action.equals("stay"))
            {
                System.out.println("Your hand value is " + getHandValue());
                break;
            }
            else
            {
                hit(deck);
                System.out.println("Your new hand value is " + getHandValue());
                if (getHandValue() > 21)
                {
                    System.out.println("You busted loser!");
                    break;
                }
            }
        }
    }

    public void hit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.hand.add(newCard);
    }

    public int getHandValue()
    {
        int hand_value = 0;
        int a_count = 0;
        for(Card card : hand)
        {
            hand_value += card.getCardValue(card);
            if(card.getCardFace(card).equals("A"))
            {
                a_count ++;
            }
        }

        while(hand_value > 21 && a_count > 0)
        {
            a_count --;
            hand_value = hand_value - 10;
        }
    
        return hand_value;
    }

    public void getCard(Deck deck)
    {
        for(int i = 0; i < 2; i++)
        {
            this.hit(deck);
        }
    }

     public void askBet(Player player)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.name + " what do you want to bet: ");
        int bet = scanner.nextInt();
        scanner.nextLine();
        this.bet = bet;
    }

    public String getName(Player player)
    {
        return player.name;
    }

     public ArrayList<Card> getHand()
    {
        return this.hand;
    }

    public boolean checkBust(Player player)
    {
        if (getHandValue() < 22)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

}