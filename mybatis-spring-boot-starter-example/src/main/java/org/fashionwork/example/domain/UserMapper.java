package org.fashionwork.example.domain;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhengsd
 */
@Mapper
public interface UserMapper {

    @Select("SELECT ID id, USER_ID userId, USER_NAME userName FROM T_DEMO_USER WHERE id = #{id}")
    User findById(@Param("id") String id);

    @Results(id = "userResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "userName", column = "USER_NAME")
    })
    @Select("SELECT * FROM T_DEMO_USER")
    List<User> findAll();

}
