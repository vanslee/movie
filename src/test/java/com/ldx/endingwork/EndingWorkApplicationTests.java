package com.ldx.endingwork;

import com.ldx.EndingWorkApplication;
import com.ldx.front.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = EndingWorkApplication.class)
@RunWith(SpringRunner.class)
class EndingWorkApplicationTests {
@Autowired
private UserService userService;
    @Test
    void contextLoads() {
        userService.list().forEach(System.out::println);
    }

}
