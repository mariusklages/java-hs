import java.util.LinkedList;
import java.util.Map;

import static java.util.Objects.hash;

//public class Main<K, V> implements Map<K, V> {

    //DEFAULT_INITIAL_CAPACITY must be a power of 2
//    static final int DEFAULT_INITIAL_CAPACITY = 16;
  //  private LinkedList<V> table;
    //private int size;



//    public int size() {
//        return size;
//    }


//    public V get(Object key) {

//        if (key == null)
//            return null;

//        int hash = hash(key);
//
//        int i = hash % table.length;
//
//        return table[i];
//
//    }
//
//    public V put(K key, V value) {
//
//        if (key == null)
//            return null;
//
//        int hash = hash(key);
//
//        int i = hash % table.length;
//
//        table[i] = value;
//        size++;
//
//        return value;
//        }
//
//
//    public V remove(Object key) {
//
//
//
//        Entry<K,V> e = removeEntryForKey(key);
//        return (e == null ? null : e.value);
//        }
//
//    public static void main(String[] args) {
//
//    }
//
//}