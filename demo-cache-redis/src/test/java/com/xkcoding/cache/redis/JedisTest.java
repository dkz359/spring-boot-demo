package com.xkcoding.cache.redis;

import com.xkcoding.cache.redis.jedis.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * jedis测试
 *
 * @ClassName JedisTest
 * @Author dukz
 * @Date 2022/9/6
 * @Version 1.0
 */
public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    public void setup(){
        //jedis = new Jedis("192.168.1.5", 6379);
        //jedis = new Jedis("150.158.2.152", 6379);
        jedis = JedisConnectionFactory.getJedis();
        jedis.select(0);
    }

    @Test
    public void testString(){
        String name = jedis.get("love");
        System.out.println("name = "+name);
    }

    @Test
    public void testHash(){
        jedis.hset("jedis:user:1", "name", "lijialing");
        jedis.hset("jedis:user:1", "age", "18");
        jedis.hset("jedis:user:1", "sex", "woman");
    }

    @AfterEach
    public void clear(){
        if (jedis != null) {
            jedis.close();
        }
    }
}
