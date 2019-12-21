package com.offcn.repository;

import com.offcn.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 一套的CRUD最基本的已经被实现了
     * @param name
     * @return
     */

    //根据姓名查询 完全匹配
    User findByName(String name);
    //根据姓名模糊查询
    List<User> findByNameLike(String name);
    //依据姓名和年龄 多条件查询
    List<User> findByNameAndAge(String name, Integer age);
    //使用年龄大于查询
    List<User> findByAgeGreaterThan(Integer age);

    /**
     *  jpql占位符 ?1 表示第一个参数 ?2表示第二个参数
     * 自定义接口方法 JPQL语句 jpql语句查询测试
     * @param userId
     * @return
     */
    @Query("select u from User u where u.id=?1")
    User getUserById(Integer userId);

    @Query("select u from User u")
    public User getUsers();

    @Query("select u from User u where u.name=?1")
    User getByUserName(String name);

    @Query("select u from User u where u.name like %:name%")
    List<User> getByUserNameLike(@Param("name") String name);

    @Query("select u from User u where u.name=?1 and age=?2")
    List<User> getByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    //原始sql执行数据库的查询
    @Query(value = "select * from user where name=?",nativeQuery = true)
    User getByUserNameNative(String name);

    @Query(value = "select * from user u where u.name like %?%",nativeQuery = true)
    List<User> getByUserNameLikeNative(String name);

    @Query(value = "select * from user u where u.name=? and age=?",nativeQuery = true)
    List<User> getByNameAndAgeNative(@Param("name") String name, @Param("age") Integer age);

}
