package io.loop.batchImprv.batchTest.service.impl;

import io.loop.batchImprv.batchTest.domain.Dummy;
import io.loop.batchImprv.batchTest.service.TestDao;
import io.loop.batchImprv.batchTest.service.TestSerivce;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2(topic = "***TestServiceImpl Class yeeeeaaaah!!")
public class TestServiceImpl implements TestSerivce {
    @Autowired
    TestDao testDao;

    @Override
    public Dummy findDummy() throws Exception {
        return testDao.selectTest();
    }

    @Override
    public void insertDummy() throws Exception {
        Dummy lc = new Dummy();
        lc.setName("one");
        lc.setGender("F");
        testDao.insertDummy(lc);
    }

    @Override
    @Transactional
    public void batchInsertDummies() throws Exception {
        log.info("batchSqlSession 배치 테스트 시작");
        long startTime = System.currentTimeMillis();

        String[] nameArr = {"Alero", "Ed", "Kathryn", "Prea", "Sean", "Peter", "spam", "bungee", "swallow", "eht"};
        String[] genderArr = {"M", "F", "N"};
        int cycleCount = 10;
        int oneOfCycle = 100000;

        for (int i = 0; i < cycleCount; i++) {
            List<Dummy> dummies = new ArrayList<Dummy>();
            for (int j = 0; j < oneOfCycle; j++) {
                Dummy dm = new Dummy();
                dm.setGender(genderArr[(int) (Math.random() * 3)]);
                dm.setName(nameArr[(int) (Math.random() * 10)]);
                dummies.add(dm);
            }
            testDao.insertDummies(dummies);
        }
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("batchSqlSession 배치 테스트 종료");
        log.info("batchSqlSession 배치" + " 소요시간  : " + resultTime / 1000 + "초(" + resultTime + ")");
    }


    @Override
    @Transactional
    public void foreachInsertDummies() throws Exception {
        log.info("foreach 배치 테스트 시작");
        long startTime = System.currentTimeMillis();

        String[] nameArr = {"Alero", "Ed", "Kathryn", "Prea", "Sean", "Peter", "spam", "bungee", "swallow", "eht"};
        String[] genderArr = {"M", "F", "N"};
        int cycleCount = 10;
        int oneOfCycle = 100000;

        for (int i = 0; i < cycleCount; i++) {
            for (int j = 0; j < oneOfCycle; j++) {
                Dummy dm = new Dummy();
                dm.setGender(genderArr[(int) (Math.random() * 3)]);
                dm.setName(nameArr[(int) (Math.random() * 10)]);
                testDao.insertDummy(dm);
            }
        }
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("foreach 배치 테스트 종료");
        log.info("foreach 배치" + " 소요시간  : " + resultTime / 1000 + "초(" + resultTime + ")");
    }
}
