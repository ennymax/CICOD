package CICOD.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;

public class ExcelUtil {
   static XSSFWorkbook workbook;
   static XSSFSheet sheet;

    static {
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\Config\\TestData.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String GetCellDataString(String sheetName, int Row, int Column) {
        sheet= workbook.getSheet(sheetName);
        String mm =sheet.getRow(Row).getCell(Column).getStringCellValue();
        System.out.println(mm);
        return mm;
    }

    public static int GetCellDataNumber(String sheetName, int Row, int Column) {
        sheet= workbook.getSheet(sheetName);
        int mm = (int) sheet.getRow(Row).getCell(Column).getNumericCellValue();
        System.out.println(mm);
        return mm;
    }
}
