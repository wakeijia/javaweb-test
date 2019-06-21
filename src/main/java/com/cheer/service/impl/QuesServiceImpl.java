package com.cheer.service.impl;

import com.cheer.dao.QuesMapper;
import com.cheer.model.Ques;
import com.cheer.service.QuesService;
import com.cheer.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class QuesServiceImpl implements QuesService{

    @Override
    public void insert(Ques ques) throws Exception{
        SqlSession session = MybatisUtils.getSqlSession();
        int result = session.getMapper(QuesMapper.class).insert(ques);
        MybatisUtils.closeSqlSession(session);
        if (result != 1){
            throw new Exception("添加失败");
        }
    }

    @Override
    public List<Ques> getList() {
        SqlSession session = MybatisUtils.getSqlSession();
        List<Ques> QuesList = session.getMapper(QuesMapper.class).getList();
        MybatisUtils.closeSqlSession(session);

        return QuesList;
    }

    @Override
    public List<String> getAnswer() {
        SqlSession session = MybatisUtils.getSqlSession();
        List<String> keyList= session.getMapper(QuesMapper.class).getAnswer();
        MybatisUtils.closeSqlSession(session);
        return keyList;

    }
}
