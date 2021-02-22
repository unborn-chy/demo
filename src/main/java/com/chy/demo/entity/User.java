package com.chy.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author chy
 * @since 2021-02-22 16:21
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) //数据库
    private Integer id;
    private String username;
    private String password;
}
