package com.offcn.pojo;

import lombok.Data;
import javax.annotation.Generated;
import javax.persistence.*;

/**
 * @ClassName User
 * @Description TODO
 * @Author Administrator
 * @Date 2019/12/19 20:19
 * @Version 1.0
 */
@Data
@Entity
//@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue
    //@Column(name = "user_id")
    private Integer id;
    @Column(name="name",length = 20,nullable = false)
    private String name;
    @Column(name="age",length = 4,nullable = true)
    private Integer age;

}
