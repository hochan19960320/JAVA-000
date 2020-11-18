package com.geektime.java.spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AutoSchoolConfiguration.class)
public class AutoConfigurationTest {
    @Autowired
    School school;

    @Test
    public void test() {
        System.out.println(school.toString());
    }

}
