package io.loop.batchImprv.batchTest.service;

import io.loop.batchImprv.batchTest.domain.Dummy;
import io.loop.batchImprv.common.service.BaseDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TestDao extends BaseDao {

    private SqlSessionTemplate sqlSessionTemplate;

    public Dummy selectTest() {
        return (Dummy) selectOne("selectTest");
    }

    public void insertDummy(Dummy dm) {
        insert("insertDummy", dm);
    }

    public void insertDummies(List<Dummy> dms) {
        batchInsert("insertDummy", dms);
    }
}
