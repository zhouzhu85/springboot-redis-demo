package com.redis.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Test
    public void contextLoads() {
        redisTemplate.opsForValue().set("test","hello world");
        String test = redisTemplate.opsForValue().get("test");
        System.out.println("test="+test);

        BoundHashOperations<String, Object, Object> ops = redisTemplate.boundHashOps("user:123");
        ops.put("name","张三");
        ops.put("age","20");

        System.out.println(ops.get("name"));
        System.out.println(ops.get("age"));
    }

}
