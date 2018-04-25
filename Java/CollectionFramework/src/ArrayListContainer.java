import java.util.AbstractList;
import java.util.Arrays;

public class ArrayListContainer {
    ArrayListContainer(){
        intArrayList = new ArrayListModified<>();
    }

    void addElements(int elementNum){
        for(int i = 0; i < elementNum; i++){
            intArrayList.add(((int)(Math.random()*elementNum*2)-elementNum));
//            System.out.println(intArrayList);
        }
    }

    ArrayListModified<Integer> intArrayList;
}


/**
 * A Class that minor copy of ArrayList. But I modifies for find out
 * when internal array grows. So, this class prints when internal array
 * capacity grows.
 * @param <E> class that put in container.
 */
class ArrayListModified<E> extends AbstractList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private int size;

    transient Object[] elementData;

    public ArrayListModified() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayListModified(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }

    public E get(int index) {
        rangeCheck(index);

        return elementData(index);
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    public int size() {
        return size;
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    /**
     * Key method that modified. If internal element array's capacity changes,
     * method notifies changes.
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        System.out.println("ArrayList capacity changes " + oldCapacity + " to " + newCapacity);
        printElements();
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }


    /**
     * New method made for print elements in internal array.
     */
    private void printElements(){
        System.out.print(":: Current elementData : [");
        for(int index = 0; index < elementData.length; index++){
            System.out.print(elementData[index]);
            if(index < elementData.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}