//15821090三代川桃子
package jp.ac.aoyama.it.it_lab_3.finalex;

import jp.ac.aoyama.it.it_lab_3.business_trip_dsl_sample.BusinessTripModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BusinessTripController {

    private KieSession ksession;
    private static final String GROUP_ID="jp.ac.aoyama.it.it_lab_3";
    private static final String ARTIFACT_Id="business_trip_dsl_sample";
    private static final String VERSION="1.0.0";

    @BeforeEach
    public void initialize(){
        KieServices ks=KieServices.Factory.get();
        KieContainer kc=ks.newKieContainer(ks.newReleaseId(GROUP_ID,ARTIFACT_Id,VERSION));
        ksession=kc.newKieSession();
    }
    @AfterEach
    public void dispose(){
        ksession.dispose();
    }

    public BusinessTripModel insertAndExecute(BusinessTripModel btm){
        ksession.insert(btm);
        ksession.fireAllRules();
        return btm;
    }
    @GetMapping("/shinseisya_input")
    public String businessTripInput(Model model) {
        //model.addAttribute("businessTripModel", new DataObject());
        return "shinseisya_input";
    }
    @GetMapping("/input_travel_info")
    public String InputTravelInfo(Model model) {
        //model.addAttribute("businessTripModel", new DataObject());
        return "input_travel_info";
    }

    @PostMapping("/shinseisya_input")
    public String processShinseisyaInput(@ModelAttribute DataObject dataObject, RedirectAttributes redirectAttributes) {
        // データを保存または処理する

        // plan_inputに必要なデータを渡す
        redirectAttributes.addFlashAttribute("dataObject", dataObject);

        // plan_inputにリダイレクト
        return "redirect:/input_travel_info";
    }



    @GetMapping("/plan_input")
    public String planInput(Model model) {
        //model.addAttribute("businessTripModel", new DataObject());
        return "plan_input";
    }

    @GetMapping("/top")
    public String Top(Model model) {
        //model.addAttribute("businessTripModel", new DataObject());
        return "top";
    }

    @PostMapping("/back")
    public String BackTop(@ModelAttribute DataObject dataObject, RedirectAttributes redirectAttributes) {
        // データを保存または処理する

        // plan_inputに必要なデータを渡す
        redirectAttributes.addFlashAttribute("dataObject", dataObject);

        // plan_inputにリダイレクト
        return "redirect:/top";
    }

    @PostMapping("/business_trip_output")
    public String businessTripOutput(@RequestParam(value="name")String name,
                                     @RequestParam(value="travel_hours")int travel_hours,Model model) {


        initialize();
        BusinessTripModel btm=new BusinessTripModel();


        model.addAttribute("name", name);
        model.addAttribute("travel_hours", travel_hours);
        btm.setName(name);
        btm.setTravelHours(travel_hours);
        btm=insertAndExecute(btm);
        model.addAttribute("dailyAllowance", btm.getDailyAllowance());
        dispose();
        return "business_trip_output";
    }

}


