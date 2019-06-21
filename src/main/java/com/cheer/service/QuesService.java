package com.cheer.service;

import com.cheer.model.Ques;

import java.util.List;

public interface QuesService {
    void insert(Ques ques) throws Exception;

    List<Ques> getList();

    List<String> getAnswer();
}
