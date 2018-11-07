package space.harbour.java.class3;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
//import org.apache.commons.collections4.CollectionUtils.*;


public class MyIterable<T> implements Iterable<T> {
    private T[] array;

    public MyIterable(T[] array) {
        this.array = array;
    }

    class MyIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public T next() {
            return array[index++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 5, 9, 18};
        MyIterable<Integer> myIterable = new MyIterable<>(a);

        for(Integer i: myIterable) {
            System.out.println(i);
        }

        String[] s = {"ABC", "CYX", "Hello" };
        MyIterable<String> myIterable2 = new MyIterable<>(s);

        for(String i: myIterable2) {
            System.out.println(i);
        }

    }
}
