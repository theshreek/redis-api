package com.theshreek.redisserver.service;

import com.theshreek.redisserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final String HASH_KEY = "USER";
    @Autowired
    private RedisTemplate <String, Object> redisTemplate;
    private static final String KEY = "USER";

    public ResponseEntity<?> saveUser(User user) {

        redisTemplate.opsForHash().put(KEY, user.getId(), user);

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(redisTemplate.opsForHash().values(KEY));
    }

    public ResponseEntity<?> getUserById(Long id){
        if (redisTemplate.opsForHash().hasKey(HASH_KEY, id)) {
            User user = (User) redisTemplate.opsForHash().get(HASH_KEY, id);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> deleteUser(Long id) {
        redisTemplate.opsForHash().delete(KEY,id);
        return ResponseEntity.ok().body("successfully deleted");
    }

    public ResponseEntity<?> updateUser( Long id,  User user) {
        if (redisTemplate.opsForHash().hasKey(HASH_KEY, id)) {
            redisTemplate.opsForHash().put(HASH_KEY, id, user);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
}
