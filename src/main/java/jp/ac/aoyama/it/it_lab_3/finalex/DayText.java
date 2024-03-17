package jp.ac.aoyama.it.it_lab_3.finalex;

public class DayText {
    private int day;
    private String text;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
