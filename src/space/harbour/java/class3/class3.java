package space.harbour.java.class3;

import java.lang.reflect.Array;

public class class3 {


    public static <T extends Number> T maxElement(T[] array) {
        if (array == null || array.length == 0) return null;

        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            //this goes through all the indices
            if (max.doubleValue() - array[i].doubleValue() < 0) max = array[i];
        }

        //for (int i: a) {
            //this just takes all the elements of a
        //    if (max < i) max = i;
        //}

        return max;
    }

    public static void main(String... args) {
        Integer[] a = { 1, 2, 3, -5};
        System.out.println(maxElement(a));

        Short[] b = { 45, 56, 90, 33};
        System.out.println(maxElement(b));
    }
}
