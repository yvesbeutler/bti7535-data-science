package ch.yvesbeutler.exercise.tfd;

/**
 * @author yvesbeutler
 * maybe used later..
 */
public class SingleWord {
    private String label;
    private int number;

    public SingleWord(String label) {
        this.label = label;
    }

    void increase() {
        number++;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
