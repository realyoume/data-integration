package com.jw.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
@TableName("myuser")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @TableField("acc")
    private String username;

    /**
     * 用户密码
     */
    @TableField("passwd")
    private String password;

    /**
     * 用户权限
     */
    @TableField("root")
    private String root;

}
