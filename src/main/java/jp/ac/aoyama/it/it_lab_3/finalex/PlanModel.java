package jp.ac.aoyama.it.it_lab_3.finalex;

import java.util.List;

public class PlanModel {
    private int n;
    private List<DayText> textData;

    public int getN(){
        return n;
    }

    public void setN(int n){
        this.n=n;
    }

    public List<DayText> getTextData() {
        return textData;
    }

    public void setTextData(List<DayText> textData) {
        this.textData = textData;
    }
}
