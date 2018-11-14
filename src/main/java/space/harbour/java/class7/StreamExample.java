package space.harbour.java.class7;

public class StreamExample {


    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }


    static class Something {
        String startsWith(String s) {
            return s.substring(0,1);
        }
    }


    public static void main(String[] args) {

        Something something = new Something();
        Converter<String, String> converter2 = something::startsWith;
        String result2 = converter2.convert("JAVA");
        System.out.println(result2);

        Converter<String, String> converter3 = converter2::convert;
        System.out.println(converter3.convert("INCEPTION"));



        Converter<String, Integer> converter = (from) -> Integer.valueOf(from, 16);
        // radix refers to binary system (0,1); if it's 16 then it's 0-9 and a-f or something similar
        Integer result = converter.convert("123");
        System.out.println(result);

        Converter<String, Integer> converter1 = Integer::valueOf;
        Integer result1 = converter1.convert("123");
        System.out.println(result1);

        Runnable example = new Runnable() {
            @Override
            public void run() {

            }
        };

        System.out.println(example.getClass().getName());
        System.out.println(something.getClass().getName());

    }
}
