package space.harbour.java.class8;

public class LowerCaseState implements State {

    @Override
    public void print(StateContext context, char letter) {
        System.out.print(String.valueOf(letter).toLowerCase());
        if (letter == '.' || letter == ' ') {
            context.setState(new UpperCaseState());
        }
    }
}
