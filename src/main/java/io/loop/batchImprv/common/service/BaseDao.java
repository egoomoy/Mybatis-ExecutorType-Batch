package io.loop.batchImprv.common.service;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BaseDao {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    protected SqlSession sqlSession;

    @Autowired
    @Qualifier("batchSqlSessionTemplate")
    protected SqlSession batchSqlSession;

    protected Object selectOne(String sqlId) {
        return this.sqlSession.selectOne(sqlId);
    }

    protected void insert(String sqlId, Object param) {
        this.sqlSession.insert(sqlId, param);
    }

    protected void batchInsert(String sqlId, List<?> paramList) {
        for (Object param : paramList) {
            this.batchSqlSession.insert(sqlId, param);
        }
    }
}
