package com.cheer.dao;

import com.cheer.model.Ques;
import com.cheer.model.Student;

import java.util.List;

public interface QuesMapper {
    int insert(Ques ques);

    List<Ques> getList();

    List<String> getAnswer();
}
