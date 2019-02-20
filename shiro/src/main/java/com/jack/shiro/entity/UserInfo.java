package com.jack.shiro.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author : peng
 * @Description : 用户信息 - 实体类
 * @Date : 2019-02-20 11:18
 */
@Getter
@Setter
@Entity
public class UserInfo implements Serializable {

    private static final long serialVersionUid = 1L;
    /**
     *User_ID
     */
    @Id @GeneratedValue
    private Long userId;
    
    /**
     *用户账号
     */
    private String userName;
    /**
     *密码
     */
    private String password;
    /**
     *用户姓名
     */
    private String name;
    /**
     *加密密码的盐
     */
    private String salt;
    /**
     *用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 ,
     *         1:正常状态,2：用户被锁定.  
     */
    private byte status;
    /**
     *用户与角色之间的关系:
     * 一个用户对应多个角色  one2many
     */
    @ManyToMany(fetch=FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;
    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.userName+this.salt;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", salt='" + salt + '\'' +
                ", status=" + status +
                ", roleList=" + roleList +
                '}';
    }
}
