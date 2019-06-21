package com.cheer.importer;

import com.cheer.model.Ques;
import com.cheer.service.QuesService;
import com.cheer.service.impl.QuesServiceImpl;
import com.cheer.util.ReadExcel;

import java.io.IOException;

public class ImportImpl {
    //实现将解析的表格文件插入数据库
    public void importData(String file) throws Exception {
        //将解析的表格装入一个数组里
        String[] str = ReadExcel.readExcel(file);

        QuesService quesService = new QuesServiceImpl();
        Ques ques = new Ques();
        //遍历存入数据库
        for (int i = 0;i < str.length; i++){

            int num = i % 6;

            switch (num){
                case 0:
                    ques.setQuestion(str[i]);
                    break;
                case 1:
                    ques.setOptionA(str[i]);
                    break;
                case 2:
                    ques.setOptionB(str[i]);
                    break;
                case 3:
                    ques.setOptionC(str[i]);
                    break;
                case 4:
                    ques.setOptionD(str[i]);
                    break;
                case 5:
                    ques.setAnswer(str[i]);
                    quesService.insert(ques);
                    break;
            }
        }
    }
}
