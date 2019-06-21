package com.cheer.dao;

import com.cheer.model.Ques;

import java.util.List;

public interface QuesMapper {

    //插一条数据
    int insert(Ques ques);
    //遍历数据
    List<Ques> getList();
    //查找一条数据
    List<String> getAnswer();
}
