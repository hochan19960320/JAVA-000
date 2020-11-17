# 第四周学习笔记



### 作业2： 实现Spring Bean的装配

方式一：

基于XML配置方式。这里使用setter注入

![image-20201116212148389](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20201116212148389.png)



方式二：

基于API方式生成BeanDefintion



![image-20201116213840029](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20201116213840029.png)



方式三，基于注解的装配




HIKARI连接池的配置 在application.properties配置

spring.datasource.hikari.maximum-pool-size=10  池中最大连接数
spring.datasource.hikari.minimum-idle=10        池中维护的最小空闲连接数
spring.datasource.hikari.idle-timeout=600000       连接允许空闲的时长
spring.datasource.hikari.connection-timeout=30000  等待连接的最大毫秒数
spring.datasource.hikari.max-lifetime=1800000    池中连接最长周期

