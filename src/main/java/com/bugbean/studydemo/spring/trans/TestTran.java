package com.bugbean.studydemo.spring.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestTran {
    @Autowired
    private TestTran testTran;

    public void a(){
        testTran.b();
    }

    @Transactional
    public void b() {

    }
}
