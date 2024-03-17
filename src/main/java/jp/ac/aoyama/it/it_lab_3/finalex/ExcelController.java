package jp.ac.aoyama.it.it_lab_3.finalex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExcelController {

    @GetMapping("/excel-form")
    public String showExcelForm() {
        return "excel-form";
    }

    @ResponseBody
    @PostMapping("/generate-excel")
    public PlanModel generateExcel(@RequestBody PlanModel p) {
        // ここでエクセル生成のロジックを呼び出す
            int n=p.getN();
            List<DayText> textData = p.getTextData();

            PlanOutput.generateExcel(n, textData);
            //PlanOutput.generateExcel(n);
            return p;

    }
}
