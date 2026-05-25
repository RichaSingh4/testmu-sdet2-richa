package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static Object[][] getTestData(
            String filePath,
            String sheetName) {

        Object[][] data;

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            Workbook workbook =
                    new XSSFWorkbook(fis);

            Sheet sheet =
                    workbook.getSheet(sheetName);

            int rows =
                    sheet.getPhysicalNumberOfRows();

            int cols =
                    sheet.getRow(0)
                            .getPhysicalNumberOfCells();

            data = new Object[rows - 1][cols];

            DataFormatter formatter =
                    new DataFormatter();

            for (int i = 1; i < rows; i++) {

                for (int j = 0; j < cols; j++) {

                    data[i - 1][j] =
                            formatter.formatCellValue(
                                    sheet.getRow(i)
                                            .getCell(j));
                }
            }

            workbook.close();

            return data;

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to read Excel file", e);
        }
    }

    public static String getCellData(
            String filePath,
            String sheetName,
            int rowNum,
            int colNum) {

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            Workbook workbook =
                    new XSSFWorkbook(fis);

            Sheet sheet =
                    workbook.getSheet(sheetName);

            DataFormatter formatter =
                    new DataFormatter();

            String value =
                    formatter.formatCellValue(
                            sheet.getRow(rowNum)
                                    .getCell(colNum));

            workbook.close();

            return value;

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to fetch cell data", e);
        }
    }
}