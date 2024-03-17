//15821093
//山岡優希
package jp.ac.aoyama.it.it_lab_3.finalex;

import jp.ac.aoyama.it.it_lab_3.business_trip_dsl_sample.BusinessTripModel;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BusinessTripRestController {
    private KieSession ksession;
    private static final String GROUP_ID = "jp.ac.aoyama.it.it_lab_3";
    private static final String ARTIFACT_Id = "business_trip_dsl_sample";
    private static final String VERSION = "1.0.0";
    public void initialize() {//初期化する
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieContainer(ks.newReleaseId(GROUP_ID, ARTIFACT_Id, VERSION));
        ksession = kc.newKieSession();
    }
    public void dispose() {
        ksession.dispose();
    }//ksessionをとじる
    //BusinessTripModelの定義を持ってくる
    public BusinessTripModel insertAndExecute(BusinessTripModel btm) {
        ksession.insert(btm);
        ksession.fireAllRules();
        return btm;
    }

    @PostMapping("/calc_daily_allowance2")
    public DailyAllowanceModel calcDailyAllowance(@RequestBody DailyAllowanceModel model) {
        System.out.println(model.getName());
        System.out.println(model.getTravelHours());

        //初期化、BusinessTripModelの初期化
        initialize();
        BusinessTripModel btm = new BusinessTripModel();
        btm.setName(model.getName());
        btm.setTravelHours(model.getTravelHours());
        btm = insertAndExecute(btm);
        //日当計算
        int dailyAllowance = btm.getDailyAllowance();
        //modelに値を入れて返す
        model.setDailyAllowance(dailyAllowance);
        dispose();

        System.out.println(model.getDailyAllowance());
        return model;
    }

    @PostMapping("/make_excel")
    public void createExcel(@RequestBody Map<String, Object> data_set) {
        makeExcel(data_set);
        Ex_final.MakeReq(data_set);
        System.out.println("post");
    }

    public void makeExcel(Map<String, Object> data_set){
        String syozoku1 = (String)data_set.get("Syozoku");
        String gakubu1 = (String)data_set.get("Gakubu");
        String Gakka = (String)data_set.get("Gakka");
        String Syokumie = (String)data_set.get("Syokumei");
        String Shimei = (String)data_set.get("Shimei");
        String Syozoku_2 = (String)data_set.get("Syozoku_2");
        String Shimei_2 = (String)data_set.get("Syozoku");
        String Mokuteki = (String)data_set.get("Mokuteki");
        String Youmuchi = (String)data_set.get("Youmuchi");
        String Youmusaki = (String)data_set.get("Youmusaki");
//        String Nittei = (String)data_set.get("Nittei");
        String Syuttyouzikan = (String)data_set.get("Syuttyouzikan");





    }
}
