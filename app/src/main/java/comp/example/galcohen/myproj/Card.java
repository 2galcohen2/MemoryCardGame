package comp.example.galcohen.myproj;

/**
 * Includes al details for card
 */

public class Card {

    private final int similarCardId;
    private final int cardId;
    private final int imageRes;
    private boolean isClicked;


    public Card(int cardId, int similarCardID, int imageRes){
        this.cardId = cardId;
        this.similarCardId = similarCardID;
        this.imageRes = imageRes;
        this.isClicked = false;
    }

    public int GetImageResource()
    {
        return (this.imageRes);
    }

    public int GetSimilarCardID()
    {
        return (this.similarCardId);
    }

    public void ClickImage(){
        this.isClicked = !this.isClicked;
    }

    public boolean IsCardMatch(Card firstCard){
        return ( firstCard.GetSimilarCardID() == this.cardId );
    }

    public boolean IsCardClicked(){
        return (this.isClicked);
    }
}
