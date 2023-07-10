package com.raresoft.weeklyreport;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class WeeklyreportApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private SqlSessionFactory sessionFactory;

    @Test
    void contextLoads() {
    }

    @Test
    public void testByApplicationContext() {
        try {
            System.out.println("=========================");
            System.out.println(context.getBean("sqlSessionFactory"));
            System.out.println("=========================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
     * context 객체의 getBean() 메서드에 "sqlSessionFactory" 전달
     * context : 스프링 컨테이너 중 하나인 ApplicationContext의 객체
     * 스프링 컨테이너 : 빈의 생명 주기 관리
     * 즉, 스프링 컨테이너에 담긴 SqlSessionFactory 빈을 꺼내오는 개념 
     * getBean() 메서드의 인자로 전달한 문자열이 SqlSessionFactory 빈의 메서드명
     * 
     */

    @Test
    public void testBySqlSessionFactory() {
        try {
            System.out.println("=========================");
            System.out.println(sessionFactory.toString());
            System.out.println("=========================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
     * 테스트 코드 모두 SqlSesionFactory 타입의 객체
     * 컨테이너에서 빈을 주입하는 방식
     * 
     */
}
