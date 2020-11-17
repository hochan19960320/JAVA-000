package com.geektime.java.injection;

import com.geektime.java.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class AnnotationInjectionDemo {

    public static void main(String[] args) {
        //创建BeanFactory 这里使用一个注解配置的上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册当前类为一个配置类。。这句话一定要加，或者用@Configuration
        applicationContext.register(AnnotationInjectionDemo.class);
        //启动applicationContext应用上下文
        applicationContext.refresh();
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
        //显示关闭Spring应用上下文
        applicationContext.close();
    }

    @Bean
    public User user(){
        User user = new User();
        user.setId(3L);
        user.setName("小狼");
        return user;
    }
}
