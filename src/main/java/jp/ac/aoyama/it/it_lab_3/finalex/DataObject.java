//15821090三代川桃子
package jp.ac.aoyama.it.it_lab_3.finalex;

public class DataObject {
    private  String name;
    private  int travelHours;

    public DataObject(){

    }

    public DataObject(String name, int travelHours){
        this.name=name;
        this.travelHours=travelHours;
    }

    public int getTravelHours() {
        return travelHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTravelHours(int travelHours) {
        this.travelHours = travelHours;
    }
}
