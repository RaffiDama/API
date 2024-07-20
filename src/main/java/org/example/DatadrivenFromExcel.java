package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class DatadrivenFromExcel {

    public static void main(String args[]) throws IOException {

        FileInputStream file = new FileInputStream("C:\\Users\\raffi\\Pratice\\API\\src\\main\\resources\\Book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        int sheets = workbook.getNumberOfSheets();

        for (int i =0;i<sheets;i++){
            if (workbook.getSheetName(i).equalsIgnoreCase("testone")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                System.out.println(i);

                //now we have sheet data we need to get row data using below code
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();

                //now we have rows data we need to get cells data using below iterator
                Iterator<Cell> cells = firstRow.cellIterator();

                //now we need to pick required cell using below code
                int k =0;
                int column=0;
                while (cells.hasNext()){
                    Cell value = cells.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Testcase")){
                        System.out.println(value);
                        column=k;
                        System.out.println(column);
                    }
                    k++;
                }

                while (rows.hasNext()){
                    Row r=rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase("one")){
                        Iterator<Cell> c = r.cellIterator();
                        while (c.hasNext()){
                            System.out.println(c.next().getStringCellValue());
                        }
                    }
                }
            }
        }
    }
}
