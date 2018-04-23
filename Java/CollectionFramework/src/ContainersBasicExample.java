import java.util.*;

public class ContainersBasicExample {
    ContainersBasicExample(){
        intArrayList = new ArrayList<>();
        intLinkedList = new LinkedList<>();
        intStack = new Stack<>();
        intHashSet = new HashSet<>();
        intTreeSet = new TreeSet<>();
        intLinkedHashSet = new LinkedHashSet<>();
        intHashMap = new HashMap<>();
        intLinkedHashMap = new LinkedHashMap<>();
        intHashtable = new Hashtable<>();
        intTreeMap = new TreeMap<>();
    }

    /**
     * Add 'elementNum' of elements in containers. Elements are generated with
     * random function and inserted in arrayList. Other containers are referencing
     * element value and its insert order with arrayList.
     *
     * @param elementNum the number of elements what you want to add to containers each.
     */
    void addElements(int elementNum){

        System.out.println("  < Element inserting estimate time >");

        int startElement = 0;
        long beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < elementNum; i++){
            intArrayList.add(((int)(Math.random()*elementNum*2)-elementNum));
        }
        long timeInputArrayList = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < elementNum; i++){
            intLinkedList.addLast(intArrayList.get(i));
        }
        long timeInputLinkedList = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < elementNum; i++){
            intStack.add(intArrayList.get(i));
        }
        long timeInputStack = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < elementNum; i++){
            intHashSet.add(intArrayList.get(i));
        }
        long timeInputHashSet = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < elementNum; i++){
            intTreeSet.add(intArrayList.get(i));
        }
        long timeInputTreeSet = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < elementNum; i++){
            intLinkedHashSet.add(intArrayList.get(i));
        }
        long timeInputLinkedHashSet = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < elementNum; i++){
            intHashMap.put(i, i);
        }
        long timeInputHashMap = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < elementNum; i++){
            intLinkedHashMap.put(i, i);
        }
        long timeInputLinkedHashMap = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < elementNum; i++){
            intHashtable.put(i, i);
        }
        long timeInputHashtable = System.currentTimeMillis() - beforeInput;
        beforeInput = System.currentTimeMillis();

        for(int i = startElement; i < elementNum; i++){
            intTreeMap.put(i, i);
        }
        long timeInputTreeMap = System.currentTimeMillis() - beforeInput;


        System.out.println(":: ArrayList : " + (timeInputArrayList/1000.0) + "sec");
        System.out.println(":: LinkedList : " + (timeInputLinkedList/1000.0) + "sec");
        System.out.println(":: Stack : " + (timeInputStack/1000.0) + "sec");
        System.out.println(":: HashSet : " + (timeInputHashSet/1000.0) + "sec");
        System.out.println(":: TreeSet : " + (timeInputTreeSet/1000.0) + "sec");
        System.out.println(":: LinkedHashSet : " + (timeInputLinkedHashSet/1000.0) + "sec");
        System.out.println(":: HashMap : " + (timeInputHashMap/1000.0) + "sec");
        System.out.println(":: LinkedHashMap : " + (timeInputLinkedHashMap/1000.0) + "sec");
        System.out.println(":: Hashtable : " + (timeInputHashtable/1000.0) + "sec");
        System.out.println(":: TreeMap : " + (timeInputTreeMap/1000.0) + "sec");

    }

    /**
     * Print elements in containers sequentially. Containers may print
     * elements with same order as arrayList. And may not.(like HashSet)
     *
     * @param endElementNum the number of elements what you want to print.
     *                      If it's bigger than container's size, it shrinks
     *                      to fit with container's size.
     */
    void printElements(int endElementNum){
        System.out.println("\n  < Element Sorting >");

        int elementNum = 0;
        if(endElementNum > intArrayList.size()){
            endElementNum = intArrayList.size();
        }

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


    ArrayList<Integer> intArrayList;
    LinkedList<Integer> intLinkedList;
    Stack<Integer> intStack;
    HashSet<Integer> intHashSet;
    TreeSet<Integer> intTreeSet;
    LinkedHashSet<Integer> intLinkedHashSet;
    HashMap<Integer, Integer> intHashMap;
    LinkedHashMap<Integer, Integer> intLinkedHashMap;
    Hashtable<Integer, Integer> intHashtable;
    TreeMap<Integer, Integer> intTreeMap;
}
