# 第五周学习笔记



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

### 动态代理笔记



![image-20201118203157257](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20201118203157257.png)

jdkProxy代理之后的类型





### maven/spring 的 profile 机制，都有什么用法？





### 总结 Hibernate 与 MyBatis 的各方面异同点。



本人见解。

Hibernate：简单的增删改查用起来还不错，但是如果有复杂的联表查询，一对多，多对多这种关系很容易搞死人，这种复杂的sql还是要人能看到比较好。不能太依赖api

Mybatis：可以在xml写sql。

而目前在mybatis越来越多插件的出现，例如mybatis-plus，用mybatis来做简单的crud也很“快乐”，复杂的sql还是可以手写。所以一般让我选，我还是无脑选Mybatis-Plus(滑稽)



### prepareStatement 的用法和解释

1**.PreparedStatement是预编译的**,**对于批量处理可以大大提高效率**. **也叫JDBC存储过程**

2.使用 Statement 对象。在对数据库只执行**一次性存取的时侯**，用 Statement 对象进行处理。**PreparedStatement 对象的开销比Statement大**，对于一次性操作并不会带来额外的好处。
3.statement每次执行sql语句，相关数据库都要执行sql语句的编译，preparedstatement是预编译得, preparedstatement支持批处理



preparedstatement的executeBatch()是通过减少网络往返来提高性能的， 1次往返是预储PreparedStatement, 另一次是执行batch命令。虽然该命令用到数据库更多的cpu周期，但是利用cpu批量处理任务还是还快。对比于网络io。

对此，JDBC也是通过减少数据库驱动与数据库之间的网络通讯次数来提高性能的。



