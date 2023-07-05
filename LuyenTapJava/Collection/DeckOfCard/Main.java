package LuyenTapJava.Collection.DeckOfCard;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
//      System.out.println(deck);
        Card.printDeck(deck);
        Card[] cardArr = new Card[13];
        Card aceHeartCard = Card.getFaceCard(Card.Suit.HEART, 'A');
        System.out.println(aceHeartCard);
        Arrays.fill(cardArr, aceHeartCard);
        Card.printDeck(Arrays.asList(cardArr), "Aces of decks", 1);

        //List init size = 0;
        System.out.println("init size");
        List<Card> listInitSize = new ArrayList<>(52);
        Collections.fill(listInitSize, aceHeartCard);
        Card.printDeck(listInitSize, "List init size", 1);
        System.out.println(listInitSize.size());

        //n copy collection copy card
        System.out.println("Copy collection");
        List<Card> listNCopy = Collections.nCopies(13, aceHeartCard);
        Card.printDeck(listNCopy, "Collection copy", 1);

        //collection addAll arr
        List<Card> listAdd = new ArrayList<>();
        Collections.addAll(listAdd, cardArr);
        Card.printDeck(listAdd, "Collection add all", 1);

        //create kings card
        Card kingOfClub = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> listKingOfClub = Collections.nCopies(10, kingOfClub);
        Card.printDeck(listKingOfClub, "List card kings", 1);

        //copy collecion thay the phan tu o list source

        Collections.copy(listAdd, listKingOfClub);
//        Card.printDeck(listAdd, "Copy list", 1);
//        Collections.copy(listCopy, listKingOfClub);

        //list
        List<Card> listCopy = List.copyOf(listKingOfClub);
        Card.printDeck(listCopy, "List copy", 1);

        //Dao bai
        Card.printDeck(deck);
        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffle", 4);
        //Dao nguoc
        Collections.reverse(deck);
        Card.printDeck(deck, "Revert", 4);

        //Sorting lambda
        var sortingAlgorithm = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Sorting", 13);
        Collections.reverse(deck);
        Card.printDeck(deck, "Sorting", 13);
        List<Card> kings = new ArrayList<>(deck.subList(4,8));
        Card.printDeck(kings, "Kings item", 1);
        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Ten item", 1);
        int indexSubList = Collections.indexOfSubList(deck, kings);
        System.out.println("index sub list " + indexSubList);
        System.out.println("Contain all " + deck.containsAll(kings));

        //contradictory contain
        boolean disjoint = Collections.disjoint(tens, kings);
        System.out.println("disjoint " + disjoint);

        //Binary Search
        Collections.reverse(deck);
        Card.printDeck(deck, "Current deck", 13);
        Card tenOfHeart = Card.getNumbericCard(Card.Suit.HEART, 10);
        int indexFound = Collections.binarySearch(deck, tenOfHeart, sortingAlgorithm);
        System.out.println("Found ten of heart: " + indexFound);
        System.out.println("Card found index: " + deck.get(indexFound));

        //replace
        Card tenOfClub = Card.getNumbericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(tens, tenOfClub, tenOfHeart);
        Card.printDeck(tens, "List tens", 1);
        if(Collections.replaceAll(tens, tenOfClub, tenOfHeart)){
            System.out.println("Replace success!!");
        }else {
            System.out.println("Replace error!!");
        }

        //replace
        System.out.println("Ten of heart cards " + Collections.frequency(tens, tenOfHeart));
        //Max, min
        System.out.println("Max deck: " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Min deck: " + Collections.min(deck, sortingAlgorithm));

        //Sort
        var sortAlgorithm = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        //Rotate
        Collections.sort(deck, sortAlgorithm);
        Card.printDeck(deck, "deck current", 4);
        List<Card> subListDeck = deck.subList(0, 13);
        Card.printDeck(subListDeck, "Card sub list", 1);
        Collections.rotate(subListDeck, 2);
        Card.printDeck(subListDeck, "Card sub list", 1);
        Collections.rotate(subListDeck, -2);
        Card.printDeck(subListDeck, "Card sub list", 1);
        //Swap item
        for (int i = 0; i < subListDeck.size()/2; i++) {
            Collections.swap(deck, i, subListDeck.size() - i - 1);
        }
        Card.printDeck(subListDeck, "Card sub list", 1);

        //Hashset
        List<Card> hashTable = new ArrayList<>();
        hashTable = deck.subList(0, 10);
        Card.printDeck(hashTable, "Test", 1);
        Set<Card> test = new HashSet<>(hashTable);
        System.out.println(test);
        System.out.println(hashTable.get(0).equals(hashTable.get(2)));
    }
}
