package com.cykj.test;

import com.cykj.controller.TbRenterController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: LQB
 * @Description:
 * @create: 2022/11/26 9:50
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(new String[]{"spring-dao.xml", "spring-service.xml"});

        TbRenterController iocBean = ioc.getBean(TbRenterController.class);
        System.out.println(iocBean);
    }

}
