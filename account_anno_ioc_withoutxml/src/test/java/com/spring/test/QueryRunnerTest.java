package com.spring.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName QueryRunnerTest
 * <p>
 * 测试queryrunner是否单例
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/5 17:38
 **/
public class QueryRunnerTest {

    @Test
    public void testQueryRunner() {
        //1 获取容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2 获取QueryRunner对象
        QueryRunner runner = context.getBean("runner", QueryRunner.class);
        QueryRunner runner2 = context.getBean("runner", QueryRunner.class);
        System.out.println(runner == runner2);
    }
}
