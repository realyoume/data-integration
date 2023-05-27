package com.jw.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @TableId("账户名")
    private String username;

    /**
     * 用户密码
     */
    @TableField("密码")
    private String password;

    /**
     * 用户权限
     */
    @TableField("权限")
    private String root;

}
