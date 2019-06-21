package com.cheer.util;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    public static String[] readExcel(String file) throws IOException {
        String[] array = null;
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        array = new String[sheet.getLastRowNum()];
        int  i = 0;
        for (Row cells : sheet) {
            for (Cell cell : cells) {
                array[i] = cell.toString();
                if (array[i] ==null){
                    continue;
                }
                i++;
            }
        }
        workbook.close();
        inputStream.close();
        return array;
    }

}
