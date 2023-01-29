package io.loop.batchImprv.batchTest.controller;

import io.loop.batchImprv.batchTest.domain.Dummy;
import io.loop.batchImprv.batchTest.service.TestSerivce;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2(topic = "***TestController Class yeeeeaaaah!!")
public class TestController {
    @Autowired
    TestSerivce testSerivceImpl;

    @GetMapping("/hello/{type}")
    public String hello(@PathVariable("type") String type) throws Exception {
        try {
            testSerivceImpl.batchInsertDummies();
            testSerivceImpl.foreachInsertDummies();
        } catch (Exception e) {
            log.error(e);
        }
        return "Hello world";
    }

}

