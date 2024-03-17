package jp.ac.aoyama.it.it_lab_3.finalex;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class PlanOutput {


    public static void setRegionBorder(CellRangeAddress region, Sheet sheet) {
        RegionUtil.setBorderBottom(BorderStyle.THIN, region, sheet);
        RegionUtil.setBorderTop(BorderStyle.THIN, region, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, region, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, region, sheet);
        RegionUtil.setBottomBorderColor(IndexedColors.BLACK.getIndex(), region, sheet);
        RegionUtil.setTopBorderColor(IndexedColors.BLACK.getIndex(), region, sheet);
        RegionUtil.setLeftBorderColor(IndexedColors.BLACK.getIndex(), region, sheet);
        RegionUtil.setRightBorderColor(IndexedColors.BLACK.getIndex(), region, sheet);
    }
    public static void generateExcel(int n,List<DayText> textData) {
        //年月日使う
        // n=n+2;

        Workbook wb = new XSSFWorkbook();
        Sheet sheet1 = wb.createSheet("出張計画");

        //出張依頼申請書
        // セルのスタイルオブジェクトの作成
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        Font font = wb.createFont();
        font.setBold(true);
//        font.setFontName("メイリオ");
        font.setFontHeightInPoints((short) 18);
        style.setFont(font);

        CellStyle style2 = wb.createCellStyle();

        style2 = wb.createCellStyle();
        style2.setBorderBottom(BorderStyle.THIN);
        style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderLeft(BorderStyle.THIN);
        style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderRight(BorderStyle.THIN);
        style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderTop(BorderStyle.THIN);
        style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style2.setAlignment(HorizontalAlignment.CENTER);
        style2.setVerticalAlignment(VerticalAlignment.CENTER);
        Font font2 = wb.createFont();
        font2.setBold(true);
//        font2.setFontName("メイリオ");
        font2.setFontHeightInPoints((short) 14);
        style2.setFont(font2);

        CellStyle style3 = wb.createCellStyle();
        Font font3 = wb.createFont();
        font3.setFontName("Meiryo");
        style3.setFont(font3);
        style3 = wb.createCellStyle();
        style3.setBorderBottom(BorderStyle.THIN);
        style3.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style3.setBorderLeft(BorderStyle.THIN);
        style3.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style3.setBorderRight(BorderStyle.THIN);
        style3.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style3.setBorderTop(BorderStyle.THIN);
        style3.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style3.setFont(font3);

        //1行目
        Row row0 = sheet1.createRow(0);
        row0.createCell(0).setCellValue("出張計画");
//        sheet1.addMergedRegion(new CellRangeAddress(
//                0, // 結合するセルの最初の行番号
//                0, // 結合するセルの最後の行番号
//                0, // 結合するセルの最初の列番号
//                6  // 結合するセルの最後の列番号
//        ));//年月日使う場合

        sheet1.addMergedRegion(new CellRangeAddress(
                0, // 結合するセルの最初の行番号
                0, // 結合するセルの最後の行番号
                0, // 結合するセルの最初の列番号
                2  // 結合するセルの最後の列番号
        ));


//２行目
        Row row1 = sheet1.createRow(1);
        //年月日使う
//        row1.createCell(0).setCellValue("年月日");
//        sheet1.addMergedRegion(new CellRangeAddress(
//                1, // 結合するセルの最初の行番号
//                1, // 結合するセルの最後の行番号
//                0, // 結合するセルの最初の列番号
//                5  // 結合するセルの最後の列番号
//        ));
//        row1.createCell(6).setCellValue("移動または用務");

        row1.createCell(0).setCellValue("何日目");
        sheet1.addMergedRegion(new CellRangeAddress(
                1, // 結合するセルの最初の行番号
                1, // 結合するセルの最後の行番号
                0, // 結合するセルの最初の列番号
                1  // 結合するセルの最後の列番号
        ));
        row1.createCell(1);
        sheet1.autoSizeColumn(0);

        //row1.createCell(2).setCellValue("移動または用務");
        row1.createCell(2).setCellValue("用務");


        //int n=5;//計算された日数＋行き帰り(2)
        List<Row> rows = new ArrayList<>();

        //3行目以降入力されたnの値に従って列作成
        for (int i = 0; i < n; i++) {
            Row row = sheet1.createRow(2 + i);
            rows.add(row);
        }

        //３行目以降に値を入れる

        //年月日入れる
//        for(int i=0;i<n;i++){
//            //Row row2 = sheet1.createRow(2+i);
//            rows.get(i).createCell(0).setCellValue("");
//            rows.get(i).createCell(1).setCellValue("年");
//            rows.get(i).createCell(2).setCellValue("");
//            rows.get(i).createCell(3).setCellValue("月");
//            rows.get(i).createCell(4).setCellValue("");
//            rows.get(i).createCell(5).setCellValue("日");
        //行きと帰り
//            if(i==0||i==n-1) {
//                rows.get(i).createCell(6).setCellValue("");
//            }
//            else{
//                rows.get(i).createCell(6).setCellValue(textData.get(i-1).getText());
//            }
//        }

        for(int i=0;i<n;i++){
            //Row row2 = sheet1.createRow(2+i);
            rows.get(i).createCell(0).setCellValue(i+1);
            rows.get(i).createCell(1).setCellValue("日目");
            rows.get(i).createCell(2).setCellValue(textData.get(i).getText());
            sheet1.autoSizeColumn(2);

        }
        //sheet1.autoSizeColumn(2);//自動幅

        for (Cell cell : row1) {
            cell.setCellStyle(style3);
        }
        for(int i=0;i<n;i++){
            for(Cell cell:rows.get(i)){
                cell.setCellStyle(style3);
            }
        }

        //styleの設定
        //年月日使う
//        row0.getCell(0).setCellStyle(style);
//        row1.getCell(0).setCellStyle(style2);
//        row1.getCell(6).setCellStyle(style2);

        row0.getCell(0).setCellStyle(style);
        row1.getCell(0).setCellStyle(style2);
        row1.getCell(2).setCellStyle(style2);
        row1.getCell(1).getCellStyle().setWrapText(true);



        // 1,2列目の幅を自動で設定
        //年月日使う
//        sheet1.autoSizeColumn(0);
//        sheet1.autoSizeColumn(1);
//        sheet1.autoSizeColumn(2);
//        sheet1.autoSizeColumn(3);
//        sheet1.autoSizeColumn(4);
//        sheet1.autoSizeColumn(5);
//        sheet1.autoSizeColumn(6);

        sheet1.autoSizeColumn(0);
        sheet1.autoSizeColumn(1);
        sheet1.autoSizeColumn(2);

        try {
            OutputStream fileOut = new FileOutputStream("plan-output.xlsx");
            wb.write(fileOut);
            wb.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        generateExcel(5);
//    }

}

