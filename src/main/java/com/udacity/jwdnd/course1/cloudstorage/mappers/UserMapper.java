package com.udacity.jwdnd.course1.cloudstorage.mappers;

import com.udacity.jwdnd.course1.cloudstorage.models.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findUserByUsername(String username); // Set method name to use "Username" instead of "Name" to remove ambiguity.

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findUserById(Integer id);

    @Select("SELECT * FROM users")
    List<User> findAllUsers();

    @Insert("INSERT INTO users VALUES (#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "id") // Effectively runs user.setId(userMapper.findIdByName(...))
    void insert(User user);

    @Update("UPDATE users SET username = #{username}, password = #{password}, firstname = #{firstName}, lastname = #{lastName} WHERE id = #{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUserById(Integer id);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUserByName(String username); // Usernames will be unique, so I'll include this (just for funsies)
}
