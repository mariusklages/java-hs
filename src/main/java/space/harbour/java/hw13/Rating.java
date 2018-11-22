package space.harbour.java.hw13;

public class Rating {

    private String source;
    private float value;
    private int votes;

    public Rating(String source, float value) {
        this.source = source;
        this.value = value;
    }

    public Rating(String source, float value, int votes) {
        this(source, value);
        this.votes = votes;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

}
