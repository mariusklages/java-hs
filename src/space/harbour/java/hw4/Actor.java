package space.harbour.java.hw4;

public class Actor extends Person {

    String asCharacter;

    public Actor(String name, String asCharacter) {
        super(name);
        this.asCharacter = asCharacter;
    }

    public String getAsCharacter() {
        return asCharacter;
    }

    public void setAsCharacter(String asCharacter) {
        this.asCharacter = asCharacter;
    }


}
