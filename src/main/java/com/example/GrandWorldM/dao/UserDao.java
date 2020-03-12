package com.example.GrandWorldM.dao;

import com.example.GrandWorldM.entity.User;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 通过名字查询用户信息
     */
    @Select("SELECT * FROM t_user WHERE name = #{name}")
    User findUserByName(@Param("name") String name);

    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM t_user")
    List<User> findAllUser();

    /**
     * 插入用户信息
     */
    @Insert("INSERT INTO t_user(name,age,money) VALUES(#{name}, #{age}, #{money})")
    void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Integer money);

    /**
     * 根据 id 更新用户信息
     */
    @Update("UPDATE t_user SET name = #{name},age = #{age},money= #{money} WHERE id = #{id}")
    void updateUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Integer money,
                    @Param("id") int id);

    /**
     * 根据 id 删除用户信息
     */
    @Delete("DELETE from t_user WHERE id = #{id}")
    void deleteUser(@Param("id") int id);
}
