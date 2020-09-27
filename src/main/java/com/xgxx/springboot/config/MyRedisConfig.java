package com.xgxx.springboot.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.xgxx.springboot.entities.Department;
import com.xgxx.springboot.entities.Employee;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.Duration;


/**
 * @ClassName MyRedisConfig
 * @Description TODO  redis 序列化等
 * @Author Dx
 * @Date 2020/9/22 10:39
 * @Version 1.0
 **/
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Object> empRedisTemplate(RedisConnectionFactory redisConnectionFactory)throws UnknownHostException {
        RedisTemplate<Object,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//        //格式化Date时间
//        ObjectMapper om = new ObjectMapper();
////        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
//
//
//        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        om.registerModule(new JavaTimeModule());

//        serializer.setObjectMapper(om);
        template.setDefaultSerializer(serializer);

        return template;
    }

//    @Bean
//    public ObjectMapper serializingObjectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        objectMapper.registerModule(new JavaTimeModule());
//        return objectMapper;
//    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory){
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofDays(1))
                .disableCachingNullValues()
                .serializeKeysWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        return RedisCacheManager.builder(factory).cacheDefaults(cacheConfiguration).build();}

//    @Bean
//    public RedisTemplate<Object, Employee> empRedisTemplate(
//            RedisConnectionFactory redisConnectionFactory)
//            throws UnknownHostException {
//        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<Employee> ser = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
//        template.setDefaultSerializer(ser);
//        return template;
//    }
//
//    @Bean
//    public RedisTemplate<Object, Department> deptRedisTemplate(
//            RedisConnectionFactory redisConnectionFactory)
//            throws UnknownHostException {
//        RedisTemplate<Object, Department> template = new RedisTemplate<Object, Department>();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<Department> ser = new Jackson2JsonRedisSerializer<Department>(Department.class);
//        template.setDefaultSerializer(ser);
//        return template;
//    }
//
//    @Bean(name = "redisTemplate")
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, String> template = new RedisTemplate<>();
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        template.setKeySerializer(stringSerializer);
//        template.setValueSerializer(stringSerializer);
//        template.setHashKeySerializer(stringSerializer);
//        template.setHashValueSerializer(stringSerializer);
//        template.setConnectionFactory(factory);
//        return template;
//    }
//
////    @Bean
////    /** cache key generation strategy */
////    public KeyGenerator KeyGenerator() {
////        return new KeyGenerator() {
////            @Override
////            public Object generate(Object target, Method method, Object... params) {
////                StringBuilder sb = new StringBuilder();
////                sb.append(target.getClass().getName());
////                sb.append(method.getName());
////                for (Object obj : params) {
////                    sb.append(obj.toString());
////                }
////                return sb.toString();
////            }
////        };
////    }
//
//    @Bean
//    /**  redis-cache configuration */
//    public CacheManager cacheManager(RedisConnectionFactory factory) {
//        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//
//        //解决查询缓存转换异常的问题
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//
//        // 配置序列化（解决乱码的问题）
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                // 7 天缓存过期
//                .entryTtl(Duration.ofDays(7))
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
//                .disableCachingNullValues();
//
//        RedisCacheManager cacheManager = RedisCacheManager.builder(factory)
//                .cacheDefaults(config)
//                .build();
//        return cacheManager;
//    }

}
