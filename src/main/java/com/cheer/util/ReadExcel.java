package com.cheer.util;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    //解析表格文件
    public static String[] readExcel(String file) throws IOException {
        String[] array = null;
        FileInputStream inputStream = new FileInputStream(file);
        //创建一个workbook对象
        Workbook workbook = WorkbookFactory.create(inputStream);
        //得到表格第一个sheet表
        Sheet sheet = workbook.getSheetAt(0);
        array = new String[sheet.getLastRowNum()];
        int  i = 0;
        //将单元格中的内容遍历到数组中
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
