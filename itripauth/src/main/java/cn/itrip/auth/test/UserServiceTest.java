package cn.itrip.auth.test;

import cn.itrip.auth.service.UserService;
import cn.itrip.search.beans.pojo.ItripUser;



import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void testInsertUser() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        UserService userService = (UserService)ctx.getBean("userService");
        ItripUser user = new ItripUser();
        user.setUserCode("ljjnbs@aliyun.com");
        user.setUserName("ljjnbs");
        try {
            userService.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

