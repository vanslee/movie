package com.ldx.endingwork;

import com.ldx.EndingWorkApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = EndingWorkApplication.class)
@RunWith(SpringRunner.class)
public class DemoTest1 {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void test01(){
        System.out.println("\"     XX       \".trim() = " + "  XX ".trim());
    }
    @Test
    public void test02() {
            Object msg = true;
            if(boolean.class.isInstance(msg)) System.out.println("dsada");
        System.out.println("12313123");
    }

}
