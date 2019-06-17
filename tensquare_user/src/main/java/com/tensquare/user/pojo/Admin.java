package com.tensquare.user.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: tensquare_parent
 * @description: 管理员实体类
 * @author: cf
 * @create: 2019-06-17 10:58
 */
@Entity
@Table(name="tb_admin")
public class Admin {
    @Id
    private String id;//ID
    private String loginname;//登陆名称
    private String password;//密码
    private String state;//状态


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
