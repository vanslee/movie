package com.ldx.endingwork;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.EndingWorkApplication;
import com.ldx.front.service.MovieService;
import com.ldx.front.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = EndingWorkApplication.class)
@RunWith(SpringRunner.class)
class EndingWorkApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
@Autowired
private UserService userService;
@Autowired
private MovieService movieService;
    @Test
    void contextLoads() {
        userService.list().forEach(System.out::println);
    }
    @Test
    void test01(){
        PageInfo<Object> objectPageInfo = PageHelper.startPage(1, 8).doSelectPageInfo(() -> movieService.list());
        System.out.println("objectPageInfo = " + objectPageInfo);
    }
    @Test
    public void test03() {
        stringRedisTemplate.opsForValue().set("username","张三");
    }
    @Test
    public void test05() {
        stringRedisTemplate.opsForValue().set("token","123123123214",30, TimeUnit.SECONDS);
        // 拦截器,每次请求,刷新过期时间
//        redisTemplate.expire() 延长时间
    }
    @Test
    public void test04() {
        System.out.println(stringRedisTemplate.opsForValue().get("username"));

    }
}
