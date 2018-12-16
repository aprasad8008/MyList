/**
 * @author aprasad72
 * @version 1.0.0
 * @param <E> is a generic type
 * Concrete class defines methods in List interface
*/
public class MyList<E> implements List<E> {

    private E[] elements;
    private int size;
    /**
     * constructor gives instance variables assignments
     * initializes generic type array (instance variable)
     * size (instance variable; count of non-null elements in array)
     * sets size to initial amount of 0
     */
    public MyList() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }
    /**
     * @param capacity int value size of elements array (instance variable)
     * constructor sets generic type array (elements) to size of capacity
     * sets size to initial amount of 0
     */
    public MyList(int capacity) {
        elements = (E[]) new Object[capacity];
        size = 0;
    }
     /**
     * @param e a generic type E
     * throws an IllegalArgumentException if e is null
     * adds the passed-in element to the last position in the elements array
     * increases size by one with addition to array
     * accounts for if array is completely filled or has null spaces
     */
    public void add(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Parameter is not valid");
        }

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                elements[i] = e;
                size++;
                return;
            }
        }
        E[] temp = (E[]) new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            temp[i] = elements[i];
        }
        int tempSize = elements.length;
        elements = temp;
        elements[tempSize] = e;
        size++;
    }
    /**
     * @param index int value to get specific element for given index
     * @return E (generic type) element within elements array
     * selects an element from the given index in the elements array
     * returns null if elements array is empty
     * throws IndexOutOfBoundsException if elements array is empty
     */
    public E get(int index) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException(
                "Given index is out of bounds");
        }
        if (!this.isEmpty()) {
            E temp = elements[index];
            return temp;
        }
        return null;
    }
    /**
     * @param e a generic type E
     * @param replaceWith a generic type E
     * replaces all instances of e with replaceWith in the list
     * throws IllegalArgumentException if e or replaceWith is null
     */
    public void replace(E e, E replaceWith) {
        if (e == null || replaceWith == null) {
            throw new IllegalArgumentException("Parameter is not valid");
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                if (elements[i].equals(e)) {
                    elements[i] = replaceWith;
                }
            }
        }
    }
    /**
     * @param e a generic type E
     * @return int (count of how many instances were removed)
     * if equivelent to e, removes element and shifts other elements to the left
     * throws IllegalArgumentException if e is null
     */
    public int remove(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Parameter is not valid");
        }
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                if (elements[i].equals(e)) {
                    elements[i] = null;
                    count++;
                    for (int k = i; k < elements.length - 1; k++) {
                        E temp = elements[k + 1];
                        elements[k + 1] = elements[k];
                        elements[k] = temp;
                    }
                    i--;
                }
            }
        }
        size -= count;
        return count;
    }
    /**
     * @param e a generic type E
     * @return int (count of instances of e in elements array)
     * checks to see how many instances of e are in the elements array
     * throws IllegalArgumentException if e is null
     */
    public int contains(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Parameter is not valid");
        }
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                if (elements[i].equals(e)) {
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * @return boolean
     * checks to see if elements in elements array are null
     * all null, then it is empty
     */
    public boolean isEmpty() {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                return false;
            }
        }
        return true;
    }
    /**
     * sets all elements in elements array to null
     * sets size to 0
     */
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    /**
     * @return int size instance variable (count of non-null elements in array)
     */
    public int size() {
        return size;
    }
    /**
     * @param e a generic type E
     * @return generic type E array
     * e is filled with as many non null elements of the elements array
     * starts from the beginning of elements array
     * additional spaces become null
     * accounts for if given e array is greater and less in length than elements
     * throws IllegalArgumentException if e is null
     */
    public E[] toArray(E[] e) {
        if (e == null) {
            throw new IllegalArgumentException("Parameter is not valid");
        }
        if (e.length > elements.length) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] != null) {
                    e[i] = elements[i];
                } else {
                    e[i] = null;
                }
            }
            for (int k = elements.length; k < e.length; k++) {
                e[k] = null;
            }
        } else {
            for (int i = 0; i < e.length; i++) {
                if (elements[i] != null) {
                    e[i] = elements[i];
                } else {
                    e[i] = null;
                }
            }
        }
        return e;
    }
}
