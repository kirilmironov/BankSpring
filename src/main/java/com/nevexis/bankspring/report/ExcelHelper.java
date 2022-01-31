package com.nevexis.bankspring.report;


import java.io.OutputStream;
import java.util.List;

import com.nevexis.bankspring.model.Account;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERS = {"Id", "Name", "Balance", "Egn"};
    static String SHEET = "Accounts";

    public static void accountsToExcel(List<Account> accountList, OutputStream out) throws IOException {
        try (Workbook workbook = new XSSFWorkbook();) {

            Sheet sheet = workbook.createSheet(SHEET);
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERS.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERS[col]);
            }

            int rowIdx = 1;
            for (Account acc : accountList) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(acc.getId());
                row.createCell(1).setCellValue(acc.getName());
                row.createCell(2).setCellValue(acc.getBalance().toString());
                row.createCell(3).setCellValue(acc.getEgn());
            }

             workbook.write(out);
       } catch (IOException e) {
            throw new RuntimeException("Fail to import data to Excel file!");
        }
    }
}
