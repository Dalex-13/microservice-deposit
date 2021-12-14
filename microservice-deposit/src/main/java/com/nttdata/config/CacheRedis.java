package com.nttdata.config;

import org.redisson.config.Config;
import org.redisson.Redisson;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import org.redisson.api.RedissonClient;
import java.util.Map;

@Configuration
@EnableCaching
public class CacheRedis {

    @Bean
    public CacheManager getCache(RedissonClient redissonClient){
        Map<String, CacheRedis> config=new HashMap<>();
        config.put("deposit",new CacheRedis());
        return new RedissonSpringCacheManager(redissonClient);
    }


    @Bean(destroyMethod ="shutdown")
    public RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);

    }

}
