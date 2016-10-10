package com.rhoynar.qa.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;

/**
 * Created by harsh on 7/7/2016.
 */
public class ExcelUtils {

    private static final Logger log = LogManager.getLogger(ExcelUtils.class);

    /**
     * Opens the xlsx file based on the filename and sheet passed in.
     * Creates the 2 dimension array filled with the data.
     *
     * @param fname     - File name (relative path from resources directory)
     * @param sheetName - Sheet name within the excel file.
     * @return Object[][] 2 dimensional array with data from the xlsx file
     */
    public static String[][] dataProvider(String fname, String sheetName) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String fileName = Paths.get(classLoader.getResource(fname).toURI()).toString();
            //log.info("Filename to be loaded: " + fileName);

            File xlsFile = new File(fileName);
            FileInputStream file = new FileInputStream(xlsFile);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum() + 1;
            int colCount = sheet.getRow(0).getLastCellNum();

            //log.info("Rows: " + rowCount + " Columns: " + colCount);

            String[][] retval = new String[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    //System.out.print(row.getCell(j) + "\t\t");
                    retval[i - 1][j] = row.getCell(j).toString().trim();
                }
                //System.out.println();
            }
            return retval;

        } catch (Exception ex) {
            log.error("Error occurred while loading excel file: " + ex.toString());
            return null;
        }
    }
}