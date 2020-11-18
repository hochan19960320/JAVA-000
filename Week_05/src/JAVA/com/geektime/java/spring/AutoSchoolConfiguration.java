package com.geektime.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConditionalOnProperty(prefix = "school", value = "enabled", havingValue = "true")
@PropertySource("classpath:application.properties")
@ConditionalOnClass(School.class)
@EnableConfigurationProperties(SchoolProperties.class)
public class AutoSchoolConfiguration {

    @Autowired
    private  SchoolProperties schoolProperties;

    @Bean
    public School school() {
        List<Integer> studentIds = schoolProperties.getStudentIds();
        List<String> studentNames = schoolProperties.getStudentNames();
        List<Integer> classIds = schoolProperties.getMyClassIds();
        List<String> classNames = schoolProperties.getMyClassNames();


        List<Student> students = new ArrayList<>(studentIds.size());
        for (int i=0; i<studentIds.size(); i++) {
            students.add(new Student(studentIds.get(i), studentNames.get(i)));
        }

        List<MyClass> myClasses = new ArrayList<>();
        for (int i=0; i<classIds.size(); i++) {
            myClasses.add(new MyClass(classIds.get(i), classNames.get(i)));
        }

        return new School(myClasses);
    }
}
