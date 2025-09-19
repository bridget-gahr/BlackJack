import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
    }

    public int playTurn(Deck deck)
    {
        System.out.println("Would you like to hit or stay (hit/stay) ");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        
        if (action == "hit")
        {
            hit(deck);
            return getHandValue();
        }
        else if (action == "stay")
        {
            return getHandValue();
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
            if(card.getCardFace(card) == "A")
            {
                a_count ++;
            }
        }

        while(hand_value > 21 && a_count > 0)
        {
            a_count --;
            hand_value = hand_value - 11;
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

}