//15821093
//山岡優希
package jp.ac.aoyama.it.it_lab_3.finalex;

public class DailyAllowanceModel {
    private String name;
    private int travelHours;
    private int dailyAllowance;

    public DailyAllowanceModel() {
        this.name = "";
        this.travelHours = 0;
        this.dailyAllowance = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTravelHours() {
        return travelHours;
    }

    public void setTravelHours(int travelHours) {
        this.travelHours = travelHours;
    }

    public int getDailyAllowance() {
        return dailyAllowance;
    }

    public void setDailyAllowance(int dailyAllowance) {
        this.dailyAllowance = dailyAllowance;
    }
}
