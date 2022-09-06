package com.xkcoding.cache.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoCacheRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void testString() {
        //redisTemplate.opsForValue().set("name", "redisTemplate");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name = "+name);
    }

}
