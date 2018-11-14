package space.harbour.java.class8;

public class StateExample {
    public static void main(String[] args) {
        StateContext context = new StateContext(new UpperCaseState());

        String s = "sPaCe HARBOUR university jAVA";
        for (Character c: s.toCharArray()) {
            context.print(c);
        }
    }
}
