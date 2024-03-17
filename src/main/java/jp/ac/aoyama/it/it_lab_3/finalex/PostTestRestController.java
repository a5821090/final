//15821093
//山岡優希
package jp.ac.aoyama.it.it_lab_3.finalex;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostTestRestController {

    @PostMapping("/calc_daily_allowance")
    public DailyAllowanceModel calcDailyAllowance(@RequestBody DailyAllowanceModel model) {
        System.out.println(model.getName());
        System.out.println(model.getTravelHours());
        int travelHours = model.getTravelHours();
        if (travelHours < 4) {
            model.setDailyAllowance(0);
        } else if (4 <= travelHours && travelHours < 8) {
            model.setDailyAllowance(1000);
        } else if (8 <= travelHours && travelHours < 12) {
            model.setDailyAllowance(2000);
        } else if (12 <= travelHours) {
            model.setDailyAllowance(3000);
        }
        System.out.println(model.getDailyAllowance());
        return model;
    }

    @PostMapping("/calc_accommodation_fee")
    public AccommodationFeeModel calcAccommodationFee(@RequestBody AccommodationFeeModel model){
        System.out.println(model.getName());
        System.out.println(model.getJobTitle());
        System.out.println(model.getTravelCategory());
        System.out.println(model.getNumberOgNights());
        System.out.println(model.getCityType());

        String jobTitle = model.getJobTitle();
        String travelCategory = model.getTravelCategory();
        int numberOfNights = model.getNumberOgNights();
        String cityType = model.getCityType();

        //宿泊⽇数が0の場合，宿泊料は0円
        if(numberOfNights <= 0){
            model.setAccommodationFee(0);
        }else if(travelCategory.equals("国内")){
            //出張分類が国内，宿泊⽇数が1⽇以上の場合，宿泊料は12,000円×宿泊⽇数
            model.setAccommodationFee(numberOfNights * 12000);
        } else if (travelCategory.equals("国外")) {
            //出張分類が国外，宿泊⽇数が1⽇以上
            if(cityType.equals("指定都市")) {
                //出張先が指定都市
                if(jobTitle.equals("教授")){
                    //職位が教授のとき
                    model.setAccommodationFee(numberOfNights * 21000);
                }else{
                    //職位が准教授、助教、助手のとき
                    model.setAccommodationFee(numberOfNights * 19000);
                }
            }else{
                //出張先が指定都市以外
                if(jobTitle.equals("教授")){
                    //職位が教授のとき
                    model.setAccommodationFee(numberOfNights * 19000);
                }else{
                    //職位が准教授、助教、助手のとき
                    model.setAccommodationFee(numberOfNights * 17000);
                }
            }
        }

        return  model;
    }
}
