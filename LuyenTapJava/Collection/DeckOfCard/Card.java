package LuyenTapJava.Collection.DeckOfCard;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) implements Comparable {
    public enum Suit{
        CLUB, DIAMOND, HEART, SPADE;
        public char getImage(){
            return (new char[]{9827, 9830, 9829, 9824})[this.ordinal()];
        }
    }

    @Override
    public String toString() {
        int index = face.equals("10") ? 2 : 1;
        String faceString = face.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }
    public static Card getNumbericCard(Suit suit, int cardNumber){
        if(cardNumber > 1 && cardNumber <= 10){
            return new Card(suit, String.valueOf(cardNumber), cardNumber -2);
        }
        System.out.println("Invalid card selected number");
        return null;
    }

    public static Card getFaceCard(Suit suit, char abbrev){
        int charIndex = "JQKA".indexOf(abbrev);
        if(charIndex > -1){
            return new Card(suit, "" + abbrev, charIndex + 9);
        }
        System.out.println("Invalid Face card selected!");
        return null;
    }
    public static List<Card> getStandardDeck(){
        List<Card> deck =  new ArrayList<>(52);
        for (Suit suit: Suit.values()){
            for (int i= 2; i <=10; i++){
                deck.add(getNumbericCard(suit, i));
            }
            for (char c : new char[]{'J', 'Q', 'K', 'A'}){
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }

    @Override
    public int compareTo(Object o) {
        Card card = (Card) o;
        return 0;
    }

    public static void printDeck(List<Card> deck){
        printDeck(deck, "Current deck", 4);
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Card card)) return false;
//
//        if (rank != card.rank) return false;
//        if (suit != card.suit) return false;
//        return Objects.equals(face, card.face);
        return true;
    }

    @Override
    public int hashCode() {
//        int result = suit != null ? suit.hashCode() : 0;
//        result = 31 * result + (face != null ? face.hashCode() : 0);
//        result = 31 * result + rank;
//        return result;
        return 1;
    }

    public static void printDeck(List<Card> deck, String description, int rows){
        System.out.println("-".repeat(50));
        System.out.println(description);
        int columns =  deck.size() / rows;
        for (int i = 0; i < rows; i++){
            int start = i * columns;
            int ends = start  + columns;
            for(int z = start; z < ends; z ++){
                System.out.print(deck.get(z) + " ");
            }
            System.out.println("");
        }
        if(deck.size()/rows != 0){
            int start = rows * columns;
            for (int i = start; i < deck.size(); i++) {
                System.out.print(deck.get(i) + " ");
            }
        }
    }
}
