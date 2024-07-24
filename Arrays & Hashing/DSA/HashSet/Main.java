/*
 * HashSet
 * - generic
 * - hashing
 * - add
 * - contains
 * - remove
 * - dynamic
 * - separate chaining
 * 
 */

import java.util.LinkedList;

class HashSet <E> {
    // private

    private LinkedList<E>[] buckets;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final float LOAD_FACTOR = 0.5f;

    private int hashIndex(E element){
        if (element == null) return -1;
        else return Math.abs(element.hashCode()%buckets.length);
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        LinkedList<E>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;

        for(LinkedList<E> bucket : oldBuckets){
            if(bucket!=null){
                for(E element: bucket){
                    add(element);
                }
            }
        }
    }

    // public

    @SuppressWarnings("unchecked")
    public HashSet(){
        buckets = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }


    public void add(E element){
        int index = hashIndex(element);
        if(buckets[index] == null) buckets[index] = new LinkedList<E>();

        buckets[index].add(element);
        size++;

        if((float) size/ buckets.length > LOAD_FACTOR){
            resize();
        }
    }


    public boolean contains(E element){
        int index = hashIndex(element);
        if(buckets[index] == null) return false;
        return buckets[index].contains(element);
    }

    public void remove(E element){
        int index = hashIndex(element);
        if(contains(element)){
            buckets[index].remove(element);
            System.out.println("Element removed");
        }
        else{
            System.err.println("Element does not exist in the HashSet");
        }
    }

    public void printSet(){
        for(LinkedList<E> list: buckets){
            if(list != null){
                for(E element: list){
                    System.out.print(element + " ");
                }
            }
        }
        System.out.println();
    }

}

public class Main {
    public static void main(String[] args){
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(1);
        set.printSet();
        System.out.println("Contains 3? " + set.contains(3));
        set.remove(3);
        set.printSet();
        System.out.println("Contains 3? " + set.contains(3));


    }
}
