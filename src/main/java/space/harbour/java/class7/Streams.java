package space.harbour.java.class7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

//    public List<String> stringList;
//
//    List<String> newList = stringList.stream()
//            .map(s -> s.substring(0,4))
//            .equals(String "heat")
//            .collect(Collectors.toList());
//
//
//    boolean ifAnyMatch = stringList.stream()
//        .anyMatch(s -> s.contains("aoeu"));
//

    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                new String[] {"heat", "heal", "theater", "healer", "aoeuheat"}
        );

        List<String> heat = words.stream()
                .filter(s -> s.contains("heat"))
                .collect(Collectors.toList());


        heat.forEach(System.out::println);

        boolean containsAoeu = words.stream().anyMatch(s -> s.contains("aoeu"));
        System.out.println(containsAoeu);


//        boolean flag = false;
//        for (int i = 0; i < words.size(); i++) {
//            if (words.get(i).contains("aoeu")) {
//                flag = true;
//                break;
//            }
//        }
        // the lines commented out could be used if no stream is wanted

    }
}
