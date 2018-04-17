import javafx.util.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args){

        ArrayList<Integer> intArrayList = new ArrayList<>();
        LinkedList<Integer> intLinkedList = new LinkedList<>();
        Stack<Integer> intStack = new Stack<>();
        HashSet<Integer> intHashSet = new HashSet<>();
        TreeSet<Integer> intTreeSet = new TreeSet<>();
        LinkedHashSet<Integer> intLinkedHashSet = new LinkedHashSet<>();
        HashMap<Integer, Integer> intHashMap = new HashMap<>();


        System.out.println("  < Element inserting estimate time >");

        int startElement = 0;
        int endElement = 100000;
        long beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < endElement; i++){
            // randomly insert between -100000 to 100000
            intArrayList.add(((int)(Math.random()*endElement*2)-100000));
        }
        long timeInputArrayList = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < endElement; i++){
            intLinkedList.addLast(intArrayList.get(i));
        }
        long timeInputLinkedList = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < endElement; i++){
            intStack.add(intArrayList.get(i));
        }
        long timeInputStack = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < endElement; i++){
            intHashSet.add(intArrayList.get(i));
        }
        long timeInputHashSet = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < endElement; i++){
            intTreeSet.add(intArrayList.get(i));
        }
        long timeInputTreeSet = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < endElement; i++){
            intLinkedHashSet.add(intArrayList.get(i));
        }
        long timeInputLinkedHashSet = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < endElement; i++){
            intHashMap.put(i, i);
        }
        long timeInputHashMap = System.currentTimeMillis() - beforeInput;

        System.out.println(":: ArrayList : " + (timeInputArrayList/1000.0) + "sec");
        System.out.println(":: LinkedList : " + (timeInputLinkedList/1000.0) + "sec");
        System.out.println(":: Stack : " + (timeInputStack/1000.0) + "sec");
        System.out.println(":: HashSet : " + (timeInputHashSet/1000.0) + "sec");
        System.out.println(":: TreeSet : " + (timeInputTreeSet/1000.0) + "sec");
        System.out.println(":: LinkedHashSet : " + (timeInputLinkedHashSet/1000.0) + "sec");
        System.out.println(":: HashMap : " + (timeInputHashMap/1000.0) + "sec");

        System.out.println("\n  < Element Sorting >");

        int elementNum = 0;
        int endElementNum = 20;

        System.out.print(":: ArrayList : ");
        for(int element : intArrayList){
            System.out.print(element + ", ");

            if(elementNum == endElementNum){
                break;
            }
            elementNum += 1;
        }
        System.out.println();

        elementNum = 0;
        System.out.print(":: LinkedList : ");
        for(int element : intLinkedList){
            System.out.print(element + ", ");

            if(elementNum == endElementNum){
                break;
            }
            elementNum += 1;
        }
        System.out.println();

        elementNum = 0;
        System.out.print(":: Stack : ");
        for(int element : intStack){
            System.out.print(element + ", ");

            if(elementNum == endElementNum){
                break;
            }
            elementNum += 1;
        }
        System.out.println();

        elementNum = 0;
        System.out.print(":: HashSet : ");
        for(int element : intHashSet){
            System.out.print(element + ", ");

            if(elementNum == endElementNum){
                break;
            }
            elementNum += 1;
        }
        System.out.println();

        elementNum = 0;
        System.out.print(":: TreeSet : ");
        for(int element : intTreeSet){
            System.out.print(element + ", ");

            if(elementNum == endElementNum){
                break;
            }
            elementNum += 1;
        }
        System.out.println();

        elementNum = 0;
        System.out.print(":: LinkedHashSet : ");
        for(int element : intLinkedHashSet){
            System.out.print(element + ", ");

            if(elementNum == endElementNum){
                break;
            }
            elementNum += 1;
        }
        System.out.println();

    }
}
