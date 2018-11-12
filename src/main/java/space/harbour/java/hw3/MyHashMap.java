package space.harbour.java.hw3;


import java.util.*;

import static java.util.Objects.hash;

public class MyHashMap<K, V> implements Map<K, V> {

    private class Element<K, V> implements Entry<K, V> {
        K key;
        V value;
        Element(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return this.value = value;
        }
    }

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    private LinkedList<Element<K, V>>[] table;
    private Set<K> keys;

    public MyHashMap() {
        table = new LinkedList[DEFAULT_INITIAL_CAPACITY];
        keys = new HashSet<K>();
    }

    public int myHash(Object key) {
        return ((hash(key) % DEFAULT_INITIAL_CAPACITY) + DEFAULT_INITIAL_CAPACITY) % DEFAULT_INITIAL_CAPACITY;
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (K key: keys)
            for (Element<K, V> elem: table[myHash(key)])
                if (elem.value.equals(value))
                    return true;
        return false;
    }

    @Override
    public V get(Object key) {
        if (!containsKey(key))
            return null;
        for (Element<K, V> elem : table[myHash(key)])
            if (elem.key.equals(key))
                return elem.value;
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (containsKey(key))
            for (Element<K, V> elem : table[myHash(key)])
                if (elem.key.equals(key))
                    return elem.value = value;
        if (!keys.add(key))
                return null;
        if (table[myHash(key)] == null)
            table[myHash(key)] = new LinkedList<>();
        table[myHash(key)].push(new Element<>(key, value));
        return value;
    }

    @Override
    public V remove(Object key) {
        if (!containsKey(key))
            return null;
        keys.remove(key);
        for (Element<K, V> elem: table[myHash(key)])
            if (elem.key.equals(key)) {
                V ret = elem.value;
                table[myHash(key)].remove(elem);
                return ret;
            }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach((key, value) -> {
            put(key, value);
        });
    }

    @Override
    public void clear() {
        for (K key: keys)
            table[myHash(key)].clear();
        keys.clear();
    }

    @Override
    public Set<K> keySet() {
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> ans = new HashSet<V>();
        for (K key: keys)
            for (Element<K, V> elem: table[myHash(key)])
                ans.add(elem.value);
        return ans;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> ans = new HashSet<>();
        for (K key: keys)
            for (Element<K, V> elem: table[myHash(key)])
                ans.add(elem);
        return ans;
    }


    public static void main(String[] args) {
        MyHashMap<String, String> hashMap = new MyHashMap<>();
        hashMap.put("hossein", "yousefi");
        hashMap.put("MK", "klages");
        hashMap.put(null, "Hallo");
        System.out.println(hashMap.myHash("marius"));
        System.out.println(hashMap.get("marius"));
        System.out.println(hashMap.get("hossein"));
        System.out.println(hashMap.get("timo"));
        System.out.println(hashMap.myHash("MK"));
        System.out.println(hashMap.containsValue("Hallo"));
    }
}
