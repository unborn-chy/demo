package com.chy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Test
    public void contextLoads() {
        String str1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjI5ODE5MTA4LCJ1c2VybmFtZSI6ImNoeSJ9.xFcGaHqmPpJBt5FM2x0CQicKYlts-CF2j4FiLq89yr8";
        String str2 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjI5ODE5MTA4LCJ1c2VybmFtZSI6ImNoeSJ9.xFcGaHqmPpJBt5FM2x0CQicKYlts-CF2j4FiLq89yr8";
        System.out.println(str1.equals(str2));
    }

}
