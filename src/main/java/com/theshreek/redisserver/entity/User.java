package com.theshreek.redisserver.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("User")
@Getter
@Setter
public class User implements Serializable {
    @Id
    private Long id;
    private String name;
    private String address;

}
