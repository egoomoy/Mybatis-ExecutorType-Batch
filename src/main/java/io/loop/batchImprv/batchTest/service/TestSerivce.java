package io.loop.batchImprv.batchTest.service;

import io.loop.batchImprv.batchTest.domain.Dummy;

public interface TestSerivce {
    Dummy findDummy() throws Exception;
    void insertDummy() throws Exception;
    void batchInsertDummies() throws Exception;
    void foreachInsertDummies() throws Exception;


}
