package space.harbour.java.hw2;
import java.util.Scanner;

public class Slang {



    public static String fixAbbreviations(String abb) {
        if(abb.contains("PLS") || abb.contains("FYI") || abb.contains("GTFO") || abb.contains("ASAP"))
            abb = abb.replace("PLS", "please");
            abb = abb.replace("FYI", "for your information");
            abb = abb.replace("GTFO", "please, leave me alone");
            abb = abb.replace("ASAP", "as soon as possible");
            return abb;
    }

    public static String fixSmiles(String abb) {
        if(abb.contains(":)") || abb.contains(":(") || abb.contains("¯\\_(ツ)_/¯"))
            abb = abb.replace(":)", "[smiling]");
            abb = abb.replace(":(", "[sad]");
            abb = abb.replace("¯\\_(ツ)_/¯", "[such is life]");
            return abb;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to say? ");
        String input = scan.nextLine();
        input = fixAbbreviations(input);
        input = fixSmiles(input);
        System.out.println(input);
    }

}
