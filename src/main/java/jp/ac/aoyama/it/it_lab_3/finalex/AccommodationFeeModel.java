//15821093
//山岡優希
package jp.ac.aoyama.it.it_lab_3.finalex;

public class AccommodationFeeModel {
    private String name;
    private String jobTitle;
    private String travelCategory;
    private int numberOgNights;
    private String cityType;
    private int accommodationFee;

    AccommodationFeeModel(){
        this.name = "";
        this.jobTitle = "教授";
        this.travelCategory = "国内";
        this.numberOgNights = 0;
        this.cityType = "指定都市";
        this.accommodationFee = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getTravelCategory() {
        return travelCategory;
    }

    public void setTravelCategory(String travelCategory) {
        this.travelCategory = travelCategory;
    }

    public int getNumberOgNights() {
        return numberOgNights;
    }

    public void setNumberOgNights(int numberOgNights) {
        this.numberOgNights = numberOgNights;
    }

    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

    public int getAccommodationFee() {
        return accommodationFee;
    }

    public void setAccommodationFee(int accommodationFee) {
        this.accommodationFee = accommodationFee;
    }
}
