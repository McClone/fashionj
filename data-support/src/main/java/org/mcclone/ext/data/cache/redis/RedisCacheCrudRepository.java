package org.mcclone.ext.data.cache.redis;

import org.mcclone.ext.data.cache.CacheCrudRepository;
import org.mcclone.ext.data.orm.Persistable;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * @author zhengsd
 */
public class RedisCacheCrudRepository<T extends Persistable, PK extends Serializable> implements CacheCrudRepository<T, PK> {

    private RedisTemplate redisTemplate;

    public RedisCacheCrudRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(T t) {

    }

    public void deleteById(PK id) {

    }

    public void update(T t) {

    }

    public T findById(PK id) {
        return null;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
