import java.util.ArrayList;

public class Dealer extends Player
{
    public Dealer()
    {
        super("Robert");
    }

    public boolean isHard()
        {
            int hand_value = 0;
            int a_count = 0;
            for(Card card : this.getHand())
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

            if (a_count == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }


    public int dealerTurn(Deck deck)
    {
        ArrayList<Card> hand = new ArrayList<>();
        this.getCard(deck);
        while (this.getHandValue() < 17)
        {
            this.hit(deck);
        }
        if(this.getHandValue() == 17)
        {
            if (isHard() == true)
            {
                return this.getHandValue();
            }
            else
            {
                this.hit(deck);
                return this.getHandValue();
            }
        }
        else if (this.getHandValue() > 21)
        {
             System.out.println("The dealer busted!");
             return this.getHandValue();
        }
        else
        {
            System.out.println("The dealers hand value is " + this.getHandValue());
            return this.getHandValue();
        }
    }
}