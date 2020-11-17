package com.geektime.java.injection;

import com.geektime.java.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 基于API实现依赖setter方法注入
 */
public class ApiInjectionDemo {

    public static void main(String[] args) {
        //创建beanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //生成User的BeanDefinition
        BeanDefinition userBeanDefinition = createUserBeanDefinition();
        beanFactory.registerBeanDefinition("user",userBeanDefinition);
        // 依赖查找并且创建bean
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    private static BeanDefinition createUserBeanDefinition(){
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        definitionBuilder.addPropertyValue("id",2);
        definitionBuilder.addPropertyValue("name","小绵羊");
        return definitionBuilder.getBeanDefinition();
    }

}
