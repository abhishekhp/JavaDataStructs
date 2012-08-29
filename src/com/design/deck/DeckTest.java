package com.design.deck;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/11/12
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
public class DeckTest {

    public static boolean isSorted(ICard[] list){
        for(int k=1; k < list.length; k++){
            if (list[k-1].compareTo(list[k]) > 0){
                return false;
            }
        }
        return true;
    }
    public static void printCards(ArrayList cards){
        for(int k=0; k < cards.size(); k++){
            System.out.println(cards.get(k));
        }
    }
    public static void main(String[] args){
        Deck d = new Deck();
        ArrayList list = new ArrayList();
        while (d.hasNext()){
            list.add(d.next());
        }
        printCards(list);
        /*Collections.sort(list);
        printCards(list);
        ICard[] clist = (ICard[]) list.toArray(new ICard[0]);
        System.out.println("sorted? "+isSorted(clist));
        */
        Collections.sort(list, new Comparator<ICard>() {
            public int compare(ICard iCard0, ICard iCard1) {
                if(iCard0.getSuit() == iCard1.getSuit())
                    return iCard0.getRank() - iCard1.getRank();
                else
                    return iCard0.getSuit() - iCard1.getSuit();

            }
        });
        printCards(list);

        int a=5,b=5,c;
        c=a + ++a + a + a++;

        System.out.print(c);

    }
}
