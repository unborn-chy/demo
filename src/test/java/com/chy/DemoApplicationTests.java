package com.chy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        String s = map.get(2);
        System.out.println("s:" + s);
    }

}
