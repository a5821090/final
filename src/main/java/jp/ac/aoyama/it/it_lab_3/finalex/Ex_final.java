//15821088 湊敢太郎

package jp.ac.aoyama.it.it_lab_3.finalex;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;


public class Ex_final {
    public static void main(String[] args) {
        // ブックの作成
        Workbook wb = new XSSFWorkbook();
        // シートの作成
        Sheet sheet1 = wb.createSheet("出張依頼申請書");


        Font font_main = wb.createFont();
        font_main.setFontName("メイリオ");

        Font font = wb.createFont();
        font.setFontName("メイリオ");
        font.setBold(true);

        CellStyle borderedStyle = wb.createCellStyle();
        borderedStyle.setBorderTop(BorderStyle.THIN);
        borderedStyle.setBorderBottom(BorderStyle.THIN);
        borderedStyle.setBorderLeft(BorderStyle.THIN);
        borderedStyle.setBorderRight(BorderStyle.THIN);
        borderedStyle.setFont(font_main);

        // フォントの作成
        Font boldFont = wb.createFont();
        boldFont.setBold(true);
        boldFont.setFontHeightInPoints((short) 14);

        // 申請者、出張者、費用用のスタイルを作成
        CellStyle headerStyle = wb.createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setFont(boldFont);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
//        headerStyle.setFont(font);

        // タイトル用のスタイルを作成
        CellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        Font titleFont = wb.createFont();
        titleFont.setBold(true);
        titleFont.setFontHeightInPoints((short) 18);
        titleStyle.setFont(titleFont);

        // A列のデータを入れる
        Row row0 = sheet1.createRow(0);
        Row row1 = sheet1.createRow(1);
        Row row2 = sheet1.createRow(2);
        Row row3 = sheet1.createRow(3);
        Row row4 = sheet1.createRow(4);
        Row row5 = sheet1.createRow(5);
        Row row6 = sheet1.createRow(6);
        Row row7 = sheet1.createRow(7);
        Row row8 = sheet1.createRow(8);
        Row row9 = sheet1.createRow(9);
        Row row10 = sheet1.createRow(10);
        Row row11 = sheet1.createRow(11);
        Row row12 = sheet1.createRow(12);
        Row row13 = sheet1.createRow(13);
        Row row14 = sheet1.createRow(14);
        Row row15 = sheet1.createRow(15);
        Row row16 = sheet1.createRow(16);

        createCellWithStyle(row0, 0, "出張依頼申請書", titleStyle, sheet1);
        sheet1.addMergedRegion(new CellRangeAddress(
                0, 0, 0, 2
        ));

        row2.createCell(0).setCellValue("");
        row3.createCell(0).setCellValue("");
        row4.createCell(0).setCellValue("");
        row5.createCell(0).setCellValue("");

        sheet1.addMergedRegion(new CellRangeAddress(
                1, 5, 0, 0
        ));

        createCellWithStyle(row1, 0, "申請者", headerStyle, sheet1);

        row7.createCell(0).setCellValue("");
        row8.createCell(0).setCellValue("");
        row9.createCell(0).setCellValue("");
        row10.createCell(0).setCellValue("");
        row11.createCell(0).setCellValue("");
        row12.createCell(0).setCellValue("");
        row13.createCell(0).setCellValue("");

        sheet1.addMergedRegion(new CellRangeAddress(
                6, 13, 0, 0
        ));

        createCellWithStyle(row6, 0, "出張者", headerStyle, sheet1);

        row15.createCell(0).setCellValue("");
        row16.createCell(0).setCellValue("");
        sheet1.addMergedRegion(new CellRangeAddress(
                14, 16, 0, 0
        ));

        createCellWithStyle(row14, 0, "費用", headerStyle, sheet1);
        createCellWithStyle(row16, 0, "費用", headerStyle, sheet1);

        createCellWithStyle(row1, 1, "所属", borderedStyle, sheet1);
        createCellWithStyle(row2, 1, "学部", borderedStyle, sheet1);
        createCellWithStyle(row3, 1, "学科", borderedStyle, sheet1);
        createCellWithStyle(row4, 1, "職名", borderedStyle, sheet1);
        createCellWithStyle(row5, 1, "氏名", borderedStyle, sheet1);
        createCellWithStyle(row6, 1, "所属機関名・部局", borderedStyle, sheet1);
        createCellWithStyle(row6, 2, "", borderedStyle, sheet1);
        createCellWithStyle(row7, 1, "職名", borderedStyle, sheet1);
        createCellWithStyle(row8, 1, "氏名", borderedStyle, sheet1);
        createCellWithStyle(row9, 1, "出張目的", borderedStyle, sheet1);
        createCellWithStyle(row10, 1, "用務地", borderedStyle, sheet1);
        createCellWithStyle(row11, 1, "用務先", borderedStyle, sheet1);
        createCellWithStyle(row12, 1, "日程", borderedStyle, sheet1);
        createCellWithStyle(row13, 1, "出張時間（日帰りの場合）", borderedStyle, sheet1);
        createCellWithStyle(row13, 2, "", borderedStyle, sheet1);
        createCellWithStyle(row14, 1, "日当", borderedStyle, sheet1);
        createCellWithStyle(row15, 1, "宿泊費", borderedStyle, sheet1);
        createCellWithStyle(row16, 1, "運賃", borderedStyle, sheet1);

        // C2からC17までの各セルに枠線を設定
        createCellWithStyle(row1,2,"", borderedStyle, sheet1);
        createCellWithStyle(row2,2,"", borderedStyle, sheet1);
        createCellWithStyle(row3,2,"", borderedStyle, sheet1);
        createCellWithStyle(row4,2,"", borderedStyle, sheet1);
        createCellWithStyle(row5,2,"", borderedStyle, sheet1);
        createCellWithStyle(row6,2,"", borderedStyle, sheet1);
        createCellWithStyle(row7,2,"", borderedStyle, sheet1);
        createCellWithStyle(row8,2,"", borderedStyle, sheet1);
        createCellWithStyle(row9,2,"", borderedStyle, sheet1);
        createCellWithStyle(row10,2,"", borderedStyle, sheet1);
        createCellWithStyle(row11,2,"", borderedStyle, sheet1);
        createCellWithStyle(row12,2,"", borderedStyle, sheet1);
        createCellWithStyle(row13,2,"", borderedStyle, sheet1);
        createCellWithStyle(row14,2,"", borderedStyle, sheet1);
        createCellWithStyle(row15,2,"", borderedStyle, sheet1);
        createCellWithStyle(row16,2,"", borderedStyle, sheet1);

        sheet1.autoSizeColumn(0);
        sheet1.autoSizeColumn(1);
        sheet1.setColumnWidth(2, 256 * 60);

        try {
            // ファイル出力
            OutputStream fileOut = new FileOutputStream("EX_final.xlsx");
            wb.write(fileOut);
            wb.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createCellWithStyle(Row row, int column, String value, CellStyle style, Sheet sheet) {
        Cell cell = row.createCell(column);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }

    public static void MakeReq(Map<String, Object> data_set){
        String syozoku1 = (String)data_set.get("Syozoku");
        String gakubu1 = (String)data_set.get("Gakubu");
        String gakka1 = (String)data_set.get("Gakka");
        String syokumei1 = (String)data_set.get("Syokumei");
        String shimei1 = (String)data_set.get("Shimei");
        String syozoku2 = (String)data_set.get("Syozoku_2");
        String syokumei2 = (String)data_set.get("Syozoku");
        String shimei2 = (String)data_set.get("Shimei_2");
        String mokutekei = (String)data_set.get("Mokuteki");
        String youmuchi = (String)data_set.get("Youmuchi");
        String youmusaki = (String)data_set.get("Youmusaki");
        String nittei_1 = (String)data_set.get("Nittei_1");
        String nittei_2 = (String)data_set.get("Nittei_2");
        String syuttyoujikan = (String)data_set.get("Syuttyouzikan");
        String nittou = (String)data_set.get("Nittou");
        String unchin = (String)data_set.get("Unchin");
        String syukuhakuhi = (String)data_set.get("Syukuhakuhi");

        // ブックの作成
        Workbook wb = new XSSFWorkbook();
        // シートの作成
        Sheet sheet1 = wb.createSheet("出張依頼申請書");


        Font font_main = wb.createFont();
        font_main.setFontName("メイリオ");

        Font font = wb.createFont();
        font.setFontName("メイリオ");
        font.setBold(true);

        CellStyle borderedStyle = wb.createCellStyle();
        borderedStyle.setBorderTop(BorderStyle.THIN);
        borderedStyle.setBorderBottom(BorderStyle.THIN);
        borderedStyle.setBorderLeft(BorderStyle.THIN);
        borderedStyle.setBorderRight(BorderStyle.THIN);
        borderedStyle.setFont(font_main);

        // フォントの作成
        Font boldFont = wb.createFont();
        boldFont.setBold(true);
        boldFont.setFontHeightInPoints((short) 14);

        // 申請者、出張者、費用用のスタイルを作成
        CellStyle headerStyle = wb.createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setFont(boldFont);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
//        headerStyle.setFont(font);

        // タイトル用のスタイルを作成
        CellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        Font titleFont = wb.createFont();
        titleFont.setBold(true);
        titleFont.setFontHeightInPoints((short) 18);
        titleStyle.setFont(titleFont);

        // A列のデータを入れる
        Row row0 = sheet1.createRow(0);
        Row row1 = sheet1.createRow(1);
        Row row2 = sheet1.createRow(2);
        Row row3 = sheet1.createRow(3);
        Row row4 = sheet1.createRow(4);
        Row row5 = sheet1.createRow(5);
        Row row6 = sheet1.createRow(6);
        Row row7 = sheet1.createRow(7);
        Row row8 = sheet1.createRow(8);
        Row row9 = sheet1.createRow(9);
        Row row10 = sheet1.createRow(10);
        Row row11 = sheet1.createRow(11);
        Row row12 = sheet1.createRow(12);
        Row row13 = sheet1.createRow(13);
        Row row14 = sheet1.createRow(14);
        Row row15 = sheet1.createRow(15);
        Row row16 = sheet1.createRow(16);

        createCellWithStyle(row0, 0, "出張依頼申請書", titleStyle, sheet1);
        sheet1.addMergedRegion(new CellRangeAddress(
                0, 0, 0, 2
        ));

        row2.createCell(0).setCellValue("");
        row3.createCell(0).setCellValue("");
        row4.createCell(0).setCellValue("");
        row5.createCell(0).setCellValue("");

        sheet1.addMergedRegion(new CellRangeAddress(
                1, 5, 0, 0
        ));

        createCellWithStyle(row1, 0, "申請者", headerStyle, sheet1);

        row7.createCell(0).setCellValue("");
        row8.createCell(0).setCellValue("");
        row9.createCell(0).setCellValue("");
        row10.createCell(0).setCellValue("");
        row11.createCell(0).setCellValue("");
        row12.createCell(0).setCellValue("");
        row13.createCell(0).setCellValue("");

        sheet1.addMergedRegion(new CellRangeAddress(
                6, 13, 0, 0
        ));

        createCellWithStyle(row6, 0, "出張者", headerStyle, sheet1);

        row15.createCell(0).setCellValue("");
        row16.createCell(0).setCellValue("");
        sheet1.addMergedRegion(new CellRangeAddress(
                14, 16, 0, 0
        ));

        createCellWithStyle(row14, 0, "費用", headerStyle, sheet1);
        createCellWithStyle(row16, 0, "費用", headerStyle, sheet1);

        createCellWithStyle(row1, 1, "所属", borderedStyle, sheet1);
        createCellWithStyle(row2, 1, "学部", borderedStyle, sheet1);
        createCellWithStyle(row3, 1, "学科", borderedStyle, sheet1);
        createCellWithStyle(row4, 1, "職名", borderedStyle, sheet1);
        createCellWithStyle(row5, 1, "氏名", borderedStyle, sheet1);
        createCellWithStyle(row6, 1, "所属機関名・部局", borderedStyle, sheet1);
        createCellWithStyle(row6, 2, "", borderedStyle, sheet1);
        createCellWithStyle(row7, 1, "職名", borderedStyle, sheet1);
        createCellWithStyle(row8, 1, "氏名", borderedStyle, sheet1);
        createCellWithStyle(row9, 1, "出張目的", borderedStyle, sheet1);
        createCellWithStyle(row10, 1, "用務地", borderedStyle, sheet1);
        createCellWithStyle(row11, 1, "用務先", borderedStyle, sheet1);
        createCellWithStyle(row12, 1, "日程", borderedStyle, sheet1);
        createCellWithStyle(row13, 1, "出張時間（日帰りの場合）", borderedStyle, sheet1);
        createCellWithStyle(row13, 2, "", borderedStyle, sheet1);
        createCellWithStyle(row14, 1, "日当", borderedStyle, sheet1);
        createCellWithStyle(row15, 1, "宿泊費", borderedStyle, sheet1);
        createCellWithStyle(row16, 1, "運賃", borderedStyle, sheet1);

        // C2からC17までの各セルに枠線を設定
        createCellWithStyle(row1,2,syozoku1, borderedStyle, sheet1);
        createCellWithStyle(row2,2,gakubu1, borderedStyle, sheet1);
        createCellWithStyle(row3,2,gakka1, borderedStyle, sheet1);
        createCellWithStyle(row4,2,syokumei1, borderedStyle, sheet1);
        createCellWithStyle(row5,2,shimei1, borderedStyle, sheet1);
        createCellWithStyle(row6,2,syozoku2, borderedStyle, sheet1);
        createCellWithStyle(row7,2,syokumei2, borderedStyle, sheet1);
        createCellWithStyle(row8,2,shimei2, borderedStyle, sheet1);
        createCellWithStyle(row9,2,mokutekei, borderedStyle, sheet1);
        createCellWithStyle(row10,2,youmuchi, borderedStyle, sheet1);
        createCellWithStyle(row11,2,youmusaki, borderedStyle, sheet1);
        createCellWithStyle(row12,2,nittei_1+"から"+nittei_2, borderedStyle, sheet1);
        createCellWithStyle(row13,2,syuttyoujikan, borderedStyle, sheet1);
        createCellWithStyle(row14,2,nittou, borderedStyle, sheet1);
        createCellWithStyle(row15,2,syukuhakuhi, borderedStyle, sheet1);
        createCellWithStyle(row16,2,unchin, borderedStyle, sheet1);
//        createCellWithStyle(row14,2,nittou, borderedStyle, sheet1);
//        createCellWithStyle(row15,2,syukuhakuhi, borderedStyle, sheet1);
//        createCellWithStyle(row16,2,unchin, borderedStyle, sheet1);

        sheet1.autoSizeColumn(0);
        sheet1.autoSizeColumn(1);
        sheet1.setColumnWidth(2, 256 * 60);

        try {
            // ファイル出力
            OutputStream fileOut = new FileOutputStream("EX_final.xlsx");
            wb.write(fileOut);
            wb.close();
            System.out.println("print");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
